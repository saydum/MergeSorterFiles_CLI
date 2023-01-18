package ru.saydum;

import ru.saydum.cmd.ParserCmd;
import ru.saydum.reader.Reader;
import ru.saydum.sorter.Sorter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean isAscending = true;
    public static boolean isString = true;
    public static String encoding = "utf-8";
    public static String outputFileName = "";
    public static List<String> inputFileNames = new ArrayList<>();
    public static List<String> readLineData = new ArrayList<>();

    public static boolean stateSorter = true; // true = String || false = Integer

    public static void main(String[] args) {
        // CMD Parser
        new ParserCmd(args).parser();

        // Reader in1.txt in2.txt... return readLineData
        readLineData =  new Reader(inputFileNames).getReadLineData();

        // Sorter -i -s (-a --abs, -d --desc)
        Sorter sorterIntFiles = new Sorter(readLineData);

        // Sorter sorterStringFiles = new Sorter(ArrayList<String> readerFiles, boolean stateSorter);

        // Writer out.txt
//        Writer writer = new Writer(sorterIntFiles);
    }
}