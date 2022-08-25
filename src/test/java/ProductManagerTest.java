import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductsRepository repo = new ProductsRepository();
    ProductManager manager = new ProductManager(repo);

    Book item1 = new Book(1, "Война и Мир", 12, "Л.Н. Толстой ");
    Book item2 = new Book(2, "Сказки", 23, "А.С. Пушкин");
    Smartphone item3 = new Smartphone(3, "X12", 54, "Xiomi");
    Smartphone item4 = new Smartphone(4, "S21 Ultra Мировая прошивка", 89, "Samsung");

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

    }

    @Test
    public void shouldShowAllProducts() {
        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = manager.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindProductsByMatches() {
        Product[] expected = {item1, item4};
        Product[] actual = manager.searchBy("Мир");

        Assertions.assertArrayEquals(expected, actual);

    }

}
