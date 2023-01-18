package ru.saydum.reader;

import ru.saydum.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public List<String> getReadLineData() {
        return readLineData;
    }

    private final List<String> readLineData = new ArrayList<>();
    public Reader(List<String> inputFileNames) {

        for(String file : inputFileNames) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                String line = reader.readLine();
                while (line != null) {
                    if (!line.isEmpty() && !line.contains(" ") ) {
                       readLineData.add(line);
                    }
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
