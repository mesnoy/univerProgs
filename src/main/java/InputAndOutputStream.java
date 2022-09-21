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
        try (BufferedReader stream = new BufferedReader(in)){
            String s = stream.readLine();
            String[] numbers = s.split(" ");
            for(int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(numbers[i]);
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
                out.write(Integer.toString(item));
                out.write(' ');
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
    public static void randomAccessRead(RandomAccessFile in, int pos, int[] arr) throws IOException {
        try {
            in.seek(pos * 4L);
            for (int i = 0; i < arr.length - pos + 1; i++) {
                int b = in.readInt();
                arr[i] = b;
            }
            /*RandomAccessFile file = new RandomAccessFile(String.valueOf(in), "r");
            file.seek(pos);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = file.readInt();
            }*/
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static void readStream(RandomAccessFile stream, int[] arr, int pos) throws IOException {
        stream.seek(pos * 4L);
        for (int i = 0; i < arr.length - pos + 1; i++) {
            int b = stream.readInt();
            arr[i] = b;
        }
    }
    //#4
    public static List<File> getFiles(String extension, String path) throws IOException {
        List<File> result = new ArrayList<File>();
        File catalog = new File(path);
        File[] files = catalog.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(extension)) {
                    result.add(file);
                }
            }
        }
        return result;
    }

    /*public static List<String> getFiles(String path, String type){
        File dir = new File(path);
        String[] files = dir.list();
        List<String> list = new ArrayList<>();
        if(files != null) {
            for (String file : files) {
                if (file.endsWith(type)) {
                    list.add(file);
                }
            }
        }
        return list;
    }*/

    //#6

}

