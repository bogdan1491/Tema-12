import org.junit.Test;
import ro.homework.filereaderstream.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FileReaderTest {

    @Test
    public void testWhenReadFromFileFiveNames() throws IOException {
        FileReader fileReader = new FileReader("./TestResources/Input1.csv", "12", "./TestResources/Output1.csv");
        fileReader.readFile();
        assertEquals(5, fileReader.getFirstListSize());
    }

    @Test
    public void testWhenReadFromFileFourNames() throws IOException {
        FileReader fileReader = new FileReader("./TestResources/Input2.csv", "12", "./TestResources/Output1.csv");
        fileReader.readFile();
        assertEquals(4, fileReader.getFirstListSize());
    }

    @Test
    public void testWhenReadFromFileThreeNames() throws IOException {
        FileReader fileReader = new FileReader("./TestResources/Input3.csv", "12", "./TestResources/Output1.csv");
        fileReader.readFile();
        assertEquals(3, fileReader.getFirstListSize());
    }

    @Test
    public void testWhenReadFromFileTwoNames() throws IOException {
        FileReader fileReader = new FileReader("./TestResources/Input4.csv", "12", "./TestResources/Output1.csv");
        fileReader.readFile();
        assertEquals(2, fileReader.getFirstListSize());
    }

    @Test
    public void testWhenReadFromFileOneName() throws IOException {
        FileReader fileReader = new FileReader("./TestResources/Input5.csv", "12", "./TestResources/Output1.csv");
        fileReader.readFile();
        assertEquals(1, fileReader.getFirstListSize());
    }

    @Test
    public void testWhenReadFromFileFiveNamesAndFilterTheOutput() throws IOException {
        FileReader fileReader = new FileReader("./TestResources/Input1.csv", "12", "./TestResources/Output1.csv");
        fileReader.readFile();
        fileReader.filterString();
        assertEquals(3, fileReader.getSecondListSize());
    }

    @Test
    public void testWhenReadFromFileFourNamesAndFilterTheOutput() throws IOException {
        FileReader fileReader = new FileReader("./TestResources/Input2.csv", "12", "./TestResources/Output1.csv");
        fileReader.readFile();
        fileReader.filterString();
        assertEquals(2, fileReader.getSecondListSize());
    }

    @Test
    public void testWhenReadFromFileThreeNamesAndFilterTheOutput() throws IOException {
        FileReader fileReader = new FileReader("./TestResources/Input3.csv", "12", "./TestResources/Output1.csv");
        fileReader.readFile();
        fileReader.filterString();
        assertEquals(1, fileReader.getSecondListSize());
    }

    @Test
    public void testWhenReadFromFileTwoNamesAndFilterTheOutput() throws IOException {
        FileReader fileReader = new FileReader("./TestResources/Input4.csv", "12", "./TestResources/Output1.csv");
        fileReader.readFile();
        fileReader.filterString();
        assertEquals(1, fileReader.getSecondListSize());
    }

    @Test
    public void testWhenReadFromFileOneNameAndFilterTheOutput() throws IOException {
        FileReader fileReader = new FileReader("./TestResources/Input5.csv", "12", "./TestResources/Output1.csv");
        fileReader.readFile();
        fileReader.filterString();
        assertEquals(0, fileReader.getSecondListSize());
    }

    FileReader fileReader = new FileReader("./TestResources/Input1.csv", "12", "./TestResources/Output1.csv");

    @Test
    public void testIfAfterReadingFromFileTheContentIsMatching() throws IOException {
        List<String> testList = new ArrayList<>();
        fileReader.readFile();
        testList.add(fileReader.getFirstListContent(0));
        testList.add(fileReader.getFirstListContent(1));
        testList.add(fileReader.getFirstListContent(2));
        testList.add(fileReader.getFirstListContent(3));
        testList.add(fileReader.getFirstListContent(4));
        assertThat(testList.get(0), is("Radu, Mihaiescu, 17.12.1957"));
        assertThat(testList.get(1), is("Ionel, Siminiuc, 15.03.2000"));
        assertThat(testList.get(2), is("Anton, Gatea, 12.07.1987"));
        assertThat(testList.get(3), is("Ioan, Anghelescu, 25.12.1974"));
        assertThat(testList.get(4), is("Alexandru, Bulgarescu,07.12.1997"));
    }

    @Test
    public void testIfAfterReadingFromFileAndFilteringTheContentIsMatching() throws IOException {
        List<String> testList = new ArrayList<>();
        fileReader.readFile();
        fileReader.filterString();
        testList.add(fileReader.getSecondListContent(0));
        testList.add(fileReader.getSecondListContent(1));
        testList.add(fileReader.getSecondListContent(2));
        assertThat(testList.get(0), is("Alexandru Bulgarescu"));
        assertThat(testList.get(1), is("Ioan Anghelescu"));
        assertThat(testList.get(2), is("Radu Mihaiescu"));

        //The order is different because during the filtering process the data is sorted alphabetically.
    }

    @Test
    public void testWhenReadFromFileFiveNamesAndWriteToAnother() throws IOException {
        FileReader fileReader = new FileReader("./TestResources/Input1.csv", "12", "./TestResources/Output1.csv");
        fileReader.readFile();
        fileReader.filterString();
        fileReader.writeFile();


        FileReader fileReader1 = new FileReader("./TestResources/Output1.csv", "12", "./TestResources/Output1.csv");
        fileReader1.readFile();
        assertEquals(3, fileReader1.getFirstListSize());

    }

    @Test
    public void testIfAfterReadingFromFileAndWritingTheContentIsMatching() throws IOException {
        FileReader fileReader = new FileReader("./TestResources/Input1.csv", "12", "./TestResources/Output1.csv");
        fileReader.readFile();
        fileReader.filterString();
        fileReader.writeFile();


        FileReader fileReader1 = new FileReader("./TestResources/Output1.csv", "12", "./TestResources/Output1.csv");
        fileReader1.readFile();
        assertEquals(3, fileReader1.getFirstListSize());

        List<String> testList = new ArrayList<>();
        testList.add(fileReader.getSecondListContent(0));
        testList.add(fileReader.getSecondListContent(1));
        testList.add(fileReader.getSecondListContent(2));

        assertThat(testList.get(0), is("Alexandru Bulgarescu"));
        assertThat(testList.get(1), is("Ioan Anghelescu"));
        assertThat(testList.get(2), is("Radu Mihaiescu"));

        //The order is different because during the filtering process the data is sorted alphabetically.
    }
}
