package ro.homework.filereaderstream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("./Resources/Input.csv", "12", "./Resources/Output.csv");

        try {
            fileReader.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileReader.filterString();
        try {
            fileReader.writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
