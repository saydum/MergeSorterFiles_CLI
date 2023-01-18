/**
 *
 * Код скопирован отсюда
 * https://github.com/SuvorovJA/FS6926/blob/master/src/main/java/ru/sua/fs6926/ParseCommandLine.java
 * */
package ru.saydum.cmd;

import org.apache.commons.cli.*;
import ru.saydum.Main;

import java.util.List;

public class ParserCmd {
    private final String[] args;
    public ParserCmd(String[] args) {
        this.args = args;
    }

    public void parser() {
        Options opt = new Options();

        opt.addOption(
                "s",
                false,
                "Файлы содержат строки. Обязателый параметр, взаимоисключительна с -i."
        );

        opt.addOption(
                "i",
                false,
                "Файлы содержат целые числа. Обязателый параметр, взаимоисключительна с -s."
        );

        opt.addOption(
                "a",
                false,
                "Сортировка по возрастанию. Используется по умолчанию при отсутствии -a или -d."
        );

        opt.addOption(
                "d",
                false,
                "Сортировка по убыванию. Необязательный параметр как -a."
        );

        opt.addOption(
                "w",
                false,
                "Файлы ожидаются в кодировке CP1251. Необязательный параметр по умолчпнии используется UTF-8."
        );

        opt.addOption(
                "h",
                "help",
                false,
                "Справочник."
        );

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(opt, args);
        } catch (UnrecognizedOptionException e) {
            System.out.println("Неизвестная опция " + e.getOption());
            usagePrintAndClose(opt, 1);
        } catch (ParseException e) {
            System.out.println("Сбой разбора командной строки " + e.getMessage());
            usagePrintAndClose(opt, 2);
        }

        if (cmd == null) {
            System.out.println("Сбой разбора командной строки по неведомой причине");
            usagePrintAndClose(opt, 3);
        } else {
            if (cmd.hasOption('h') || args.length == 0) {
                usagePrintAndClose(opt, 0);
            }
            if (!(cmd.hasOption('i') || cmd.hasOption('s'))) {
                System.out.println("Отсутствует обязательная опция -s или -i");
                usagePrintAndClose(opt, 4);
            }
            if (cmd.hasOption('i') && cmd.hasOption('s')) {
                System.out.println("Должна быть только одна опция или -s или -i");
                usagePrintAndClose(opt, 5);
            }
            if (cmd.hasOption('a') && cmd.hasOption('d')) {
                System.out.println("Должна быть только одна опция или -a или -d");
                usagePrintAndClose(opt, 6);
            }
        }

        assert cmd != null;
        List<String> files = cmd.getArgList();
        if (files.size() < 2) {
            System.out.println("Отсутствует имя файла для результата, или хотя бы одно имя входного файла.");
            usagePrintAndClose(opt, 7);
        }

        if (cmd.hasOption("d")) Main.isAscending = false;
        if (cmd.hasOption("i")) Main.isString = false;
        if (cmd.hasOption("w")) Main.encoding = "cp1251";
        Main.outputFileName = files.get(0);
        files.remove(0);
        Main.inputFileNames = files;
    }

    private static void usagePrint(Options opt) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("""
                sort-it.exe [OPTIONS] output.file input.files... \n
                output.file  Обязательное имя файла с результатом сортировки. \n
                input.files  Один, или больше входных файлов.
                """, opt);
    }

    private static void usagePrintAndClose(Options opt, int status) {
        usagePrint(opt);
        System.exit(status);
    }
}
