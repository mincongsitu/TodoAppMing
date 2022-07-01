package com.example.todoappexample;

import java.util.List;

public interface ExampleRepository {

    List<String> getThatData();
    List<String> getThatData(String dataPls);
    boolean isConnectionOk();

}

class ExampleRespositoryImpl implements ExampleRepository{

    @Override
    public List<String> getThatData() {
        //return everything of that data
        return null;
    }

    @Override
    public List<String> getThatData(String dataPls) {
        //return only data that looks like dataPls
        return null;
    }

    @Override
    public boolean isConnectionOk() {
        return false;
    }
}