public class Book extends Product{

    private String author;
    private String name;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
        this.name = name;
    }
}
