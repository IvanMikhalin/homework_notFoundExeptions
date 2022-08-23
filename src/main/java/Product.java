public class Product {

    protected int id;
    protected int price;
    protected String name;

    public Product(int id, String name, int price) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
