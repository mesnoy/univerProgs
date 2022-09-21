import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HouseServiceTest {

    @Test
    public void serialHouse() throws ClassNotFoundException {
        House house = new House("123", "1", new Person("A", "a", "c", "1, 1, 1"),
                List.of(new Flat(1,2,
                        List.of(new Person("a","a", "a", "1,1,1")))));
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("house.txt"))) {
            HouseService.serialize(house, stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        House resultHouse = new House();
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("house.txt"))){
            resultHouse = HouseService.deserialize(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(house, resultHouse);
    }

    @Test
    public void serialHouseJSON() throws IOException {
        House house = new House("123", "1", new Person("A", "a", "c", "1,1,1"),
                List.of(new Flat(1,2,
                        List.of(new Person("a","a", "a", "1,1,1")))));
        //System.out.println(HouseService.serializeJSON(house));
        Assert.assertEquals(house, HouseService.deserializeJSON(HouseService.serializeJSON(house)));
    }
}
