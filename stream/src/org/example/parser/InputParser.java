package org.example.parser;

import org.example.mapper.CSVToPojoMapper;
import org.example.model.Server;

import java.util.Arrays;
import java.util.List;

public class InputParser<T> {
    private CSVToPojoMapper mapper;

    public InputParser(CSVToPojoMapper mapper) {
        this.mapper = mapper;
    }
    public List<T> parseArray(String[] input) {
        return Arrays.stream(input)
                .map(v-> v.trim().split(",")) // split each line to array of strings
                .map(values -> (T)mapper.map(values)) // map array of strings to Student Object
                .toList();
    }
}
