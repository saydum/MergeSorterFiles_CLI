# Написать программу сортировки слиянием нескольких файлов.
Пример:

| in1.txt | in2.txt | in3.txt | out.txt |
|---------|---------|---------|---------|
| 1       | 1       | 1       | 1       |
| 4       | 8       | 2       | 1       |
| 9       | 27      | 3       | 1       |
|         |         |         | 2       |
|         |         |         | 3       |
|         |         |         | 4       |
|         |         |         | 8       |
|         |         |         | 9       |
|         |         |         | 27      |

# Как пользоваться в Linux: Протестирован :heavy_check_mark:
```bash
# Нужно указать полные пути всех файлов!!!
./sort-it.exe.AppImage -s ~/out.txt ~/in1.txt ~/in2.txt ~/in3.txt
```

# Как пользоваться на Windows: :x:
1. Скачать [sort-it.exe](https://github.com/saydum/MergeSorterFiles_CLI/releases/tag/test) файл.
2. Выполнить команду:

```shell
sort-it.exe -i -a out.txt in1.txt #(для целых чисел по возрастанию)
sort-it.exe -s out.txt in1.txt in2.txt in3.txt #(для строк по возрастанию)
sort-it.exe -d -s out.txt in1.txt in2.txt #(для строк по убыванию)
```

## Параметры программы задаются при запуске через аргументы командной строки, по порядку:
1. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
2. тип данных (-s или -i), обязательный;
3. имя выходного файла, обязательное;
4. остальные параметры – имена входных файлов, не менее одного.


---

1. `cmd.ParserCmd` - Парсер команд
2. `reader.Reader` - Принимает массив с названиями входных файлов и присваивает результат к `Main.readLineData`
3. `sorter.Sorter` - Принимает массив и выполняет сортировку слияния, результат присваивает к `Main.sortedIntLine`
4. `writer.Writer` - Принимает 1) Название выходного файла 2)`sortedIntLine` Отсортированные данные их входных файлов.
5. `Main` - Запускаемый класс, так же имеет свойства которые хранит в себе состояние и данные.

# Info

- Java v19
- Maven v4.0.0
- commons-cli v1.5.0
- javapackager v1.6.7
- IntelliJ IDEA 2022.3.1 (Community Edition)
