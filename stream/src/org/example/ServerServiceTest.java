package org.example;

import org.example.mapper.ServerMapper;
import org.example.mapper.StudentMapper;
import org.example.model.Server;
import org.example.parser.InputParser;
import org.example.services.SeverService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ServerServiceTest {
    public static void main(String[] args) {
        String[] serversInformation = {
                "Server1, Database, MySQL, 5.5",
                "Server2, Database, MySQL, 5.1",
                "Server3, OS, Ubuntu, 12.04",
                "Server1, OS, Ubuntu, 12.04",
                "Server2, OS, Ubuntu, 18.04",
                "Server3, Language, Python, 2.6.3",
                "Server4, Language, Python, 3.9.14",
                "Server4, Language, Python, 3.10.4",
                "Server5, Language, Java, 19"
        };
        ServerMapper mapper = new ServerMapper();
        List<Server> servers;
        InputParser parser = new InputParser<Server>(new ServerMapper());
        servers = parser.parseArray(serversInformation);
        System.out.println("--- servers ---");
        servers.forEach(System.out::println);

        SeverService severService = new SeverService(servers);
        System.out.println("--- software package names for which an out-of-date version is installed on at least 2 different servers.---");
        severService.outdatedSoftwaresInstalledOnAtLeastTwoServers().forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("--- server names ---");
        System.out.println(severService.serverNames());

        System.out.println("--- software categories ---");
        System.out.println(severService.softwareCategories());

        System.out.println("--- software names ---");
        System.out.println(severService.softwareNames());
    }
}
