public class Smartphone extends Product{

    private String supplier;

    public Smartphone (int id, String name, int price, String supplier) {
        super(id, name, price);
        this.supplier = supplier;
    }
}
