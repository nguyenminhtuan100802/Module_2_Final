package entity;

public class SmuggledPhone extends Phone{
    private String country;
    private String status;

    public SmuggledPhone(int id, String name, double price, int quantity, String manufacturer, String country, String status) {
        super(id, name, price, quantity, manufacturer);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SmuggledPhone{" +
                "country='" + country + '\'' +
                ", status='" + status + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
