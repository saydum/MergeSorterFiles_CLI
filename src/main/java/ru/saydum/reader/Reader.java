package ru.saydum.reader;

import ru.saydum.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Reader {
    public Reader(List<String> inputFileNames) {

        for(String file : inputFileNames) {
            try {
                //создаем объект FileReader для объекта File
                FileReader fileReader = new FileReader(file);
                //создаем BufferedReader с существующего FileReader для построчного считывания
                BufferedReader reader = new BufferedReader(fileReader);
                // считаем сначала первую строку
                String line = reader.readLine();
                while (line != null) {
                    if (!line.isEmpty() && !line.contains(" ") ) {
                        Main.readLineData.add(line);
                    }
                    // считываем остальные строки в цикле
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
