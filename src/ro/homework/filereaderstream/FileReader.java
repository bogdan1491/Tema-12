package ro.homework.filereaderstream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FileReader {
    private String fileName;
    private String targetMonth;
    private String outputFile;
    List<String> firstList = new ArrayList<>();
    List<String> secondList = new ArrayList<>();


    public FileReader(String fileName, String targetMonth, String outputFile) {
        this.fileName = fileName;
        this.targetMonth = targetMonth;
        this.outputFile = outputFile;
    }

    public File readFile() throws IOException {
        Files.lines(Paths.get(fileName))
                .map(s -> s.trim())
                .filter(s -> !s.isEmpty())
                .forEach(firstList::add);
        return null;
    }

    public void filterString() {
        secondList = firstList.stream()
                .filter(s -> s.contains("." + targetMonth + "."))
                .sorted()
                .map(line -> line.split(","))
                .map(a -> (a[0] + a[1]))
                .collect(Collectors.toList());
    }

    public void writeFile() throws IOException {
        Files.write(Paths.get(outputFile), secondList);
    }

    public int getFirstListSize() {
        return firstList.size();
    }

    public int getSecondListSize() {
        return secondList.size();
    }

    public String getFirstListContent(int i) {
        return firstList.get(i);
    }

    public String getSecondListContent(int i) {
        return secondList.get(i);
    }
}
