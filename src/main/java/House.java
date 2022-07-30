import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    private String cadastralNumber;
    private String address;
    private Person headOfTheHouse;
    private List<Flat> flats;

    public House(String cadastralNumber, String address, Person headOfTheHouse, List<Flat> flats) {
        this.cadastralNumber = cadastralNumber;
        this.address = address;
        this.headOfTheHouse = headOfTheHouse;
        this.flats = flats;
    }

    public House() {
    }

    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getHeadOfTheHouse() {
        return headOfTheHouse;
    }

    public void setHeadOfTheHouse(Person headOfTheHouse) {
        this.headOfTheHouse = headOfTheHouse;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return cadastralNumber.equals(house.cadastralNumber) && address.equals(house.address) && headOfTheHouse.equals(house.headOfTheHouse) && flats.equals(house.flats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadastralNumber, address, headOfTheHouse, flats);
    }
}
