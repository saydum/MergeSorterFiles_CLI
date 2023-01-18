package ru.saydum.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {


    public Writer(String outputFileName, List<Integer> sortedIntLine) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(outputFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < sortedIntLine.size(); i++) {
            try {
                writer.write(sortedIntLine.get(i) + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
