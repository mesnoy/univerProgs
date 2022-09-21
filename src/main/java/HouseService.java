import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;

public class HouseService {
    public static void serialize(House house, OutputStream os) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(house);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static House deserialize(InputStream is) throws IOException {
        House result = new House();
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            result = (House) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static String serializeJSON(House house) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(house);
    }

    public static House deserializeJSON(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, House.class);
    }
}
