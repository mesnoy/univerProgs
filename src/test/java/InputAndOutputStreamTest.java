import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static org.testng.AssertJUnit.*;

public class InputAndOutputStreamTest {
    @Test
    public void ReadInputStreamTest() throws IOException {
        InputStream in = new FileInputStream("/home/mesa/IdeaProjects/java07/file1") {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
        int[] arrExpected = {1, 2, 3, 4, 6};
        int[] arrActual = new int[5];
        arrActual[0] = 3;
        arrActual[1] = 3;
        arrActual[2] = 3;
        arrActual[3] = 3;
        arrActual[4] = 3;
        InputAndOutputStream.readInputStream(in, arrActual);
        //InputAndOutputStream.keks(arrActual);
        assertArrayEquals(arrExpected, arrActual);
    }
}
