package ru.saydum;

import ru.saydum.cmd.ParserCmd;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean isAscending = true;
    public static boolean isString = true;
    public static String encoding = "utf-8";
    public static String outputFileName = "";
    public static List<String> inputFileNames = new ArrayList<>();

    public static void main(String[] args) {
        // CMD Parser
        new ParserCmd(args);

        // Reader in1.txt in2.txt...
//        Reader readerFiles =  new Reader(String[] files);

        // Sorter -i -s (-a --abs, -d --desc)
//        Sorter sorterIntFiles = new Sorter(ArrayList<Integer> readerFiles, boolean stateSorter);

        // Sorter sorterStringFiles = new Sorter(ArrayList<Integer> readerFiles, boolean stateSorter);

        // Writer out.txt
//        Writer writer = new Writer(sorterIntFiles);
    }
}