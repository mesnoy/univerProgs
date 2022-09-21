import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.*;

public class InputAndOutputStreamTest {

    @Test
    public void readWriteBinaryTest() throws IOException {
        int[] a = {1, 2, 300};
        try (OutputStream outputStream = new FileOutputStream("a.bin")) {
            InputAndOutputStream.writeOutputStream(outputStream, a);
        }
        int[] ints = new int[a.length];
        try (InputStream inputStream = new FileInputStream("a.bin")) {
            InputAndOutputStream.readInputStream(inputStream, ints);
        }
        assertArrayEquals(a, ints);
    }

    @Test
    public void testWriteReadStream() throws IOException {
        int[] a = {1, 2, 300000000};
        try (Writer writer = new FileWriter("a.txt", StandardCharsets.UTF_8)) {
            InputAndOutputStream.writer(writer, a);
        }
        int[] b = new int[a.length];
        try (Reader reader = new FileReader("a.txt", StandardCharsets.UTF_8)) {
            InputAndOutputStream.reader(reader, b);
        }
        assertArrayEquals(a, b);
    }

    @Test
    public void readStreamTest() throws IOException {
        RandomAccessFile stream = new RandomAccessFile("c.txt", "rw");
        int[] arr = {1, 2, 3};
        for (int i : arr) {
            stream.writeInt(i);
        }
        int[] result = new int[2];
        InputAndOutputStream.randomAccessRead(stream, 1, result);
        assertArrayEquals(new int[]{2, 3}, result);
        stream.close();
    }

    @Test
    public void testGetListOfFilesByTypeTest() throws IOException {
        File a = new File("C:\\Users\\user\\IdeaProjects\\univerProgs\\a.txt");
        File c = new File("C:\\Users\\user\\IdeaProjects\\univerProgs\\c.txt");
        File d = new File("C:\\Users\\user\\IdeaProjects\\univerProgs\\house.txt");
        List<File> testList = new ArrayList<>();
        testList.add(a);
        testList.add(c);
        testList.add(d);
        Assert.assertEquals(testList, InputAndOutputStream.getFiles("txt", "C:\\Users\\user\\IdeaProjects\\univerProgs"));
    }
}
