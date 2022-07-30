import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;

public class HouseService {
    public void serialize(House house, OutputStream os) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(house);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deserialize(House house, InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            house = (House) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
