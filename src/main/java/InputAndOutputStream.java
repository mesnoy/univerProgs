import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputAndOutputStream {
    //#1
    //neobhodimiy commentariy
    public static void readInputStream(InputStream in, int[] arr) throws IOException {
        try {
            DataInputStream data = new DataInputStream(in);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = data.readInt();
            }
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static void keks(int[] arr) {
        Arrays.fill(arr, 5);
    }

    public static void writeOutputStream(OutputStream out, int[] arr) throws IOException {
        try {
            DataOutputStream data = new DataOutputStream(out);
            for (int item : arr) {
                data.writeInt(item);
            }
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    //#2
    public static void reader(Reader in, int[] arr) throws IOException {
        try {
            for (int item : arr) {
                item = in.read();
            }
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static void writer(Writer out, int[] arr) throws IOException {
        try {
            for (int item : arr) {
                out.write(item);
            }
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    //#3
    public static void randomAccessRead(InputStream in, int pos, int[] arr) throws IOException {
        try {
            RandomAccessFile file = new RandomAccessFile(String.valueOf(in), "r");
            file.seek(pos);
            for (int item : arr) {
                item = file.readInt();
            }
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    //#4
    public static List<File> getFiles(String extension, String path) throws IOException {
        List<File> result = new ArrayList<File>();
        File catalog = new File(path);
        File[] files = catalog.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.getName().lastIndexOf('.' + extension) == file.getName().length() - extension.length()) {
                result.add(file);
            }
        }
        return result;
    }

    //#6

}

