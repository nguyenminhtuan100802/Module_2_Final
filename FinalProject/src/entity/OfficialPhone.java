package entity;

public class OfficialPhone extends Phone {
    private int warrantyPeriod;
    private String warrantyCoverage;

    public OfficialPhone(int id, String name, double price, int quantity, String manufacturer, int warrantyPeriod, String warrantyCoverage) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyCoverage = warrantyCoverage;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyCoverage() {
        return warrantyCoverage;
    }

    public void setWarrantyCoverage(String warrantyCoverage) {
        this.warrantyCoverage = warrantyCoverage;
    }

    @Override
    public String toString() {
        return "id: " + id +
                " || name: " + name +
                " || price: " + price +
                " || quantity: " + quantity +
                " || manufacturer: " + manufacturer +
                " || warrantyPeriod: " + warrantyPeriod +
                " || warrantyCoverage: " + warrantyCoverage;
    }
}
