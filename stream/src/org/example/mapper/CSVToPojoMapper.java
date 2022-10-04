package org.example.mapper;

public interface CSVToPojoMapper <T>{
    public T map(String[] input);
}
