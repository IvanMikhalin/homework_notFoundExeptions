import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductsRepositoryTest {

    Book item1 = new Book (1, "Война и Мир", 12, "Л.Н. Толстой ");
    Book item2 = new Book (2, "Сказки", 23, "А.С. Пушкин");
    Smartphone item3 = new Smartphone (3, "X12", 54, "Xiomi");
    Smartphone item4 = new Smartphone (4, "S21 Ultra", 89, "Samsung");

    @Test
    public void shouldDeleteProductsById (){
        ProductsRepository repo = new ProductsRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.removeById(item2.getId());
        repo.removeById(item3.getId());

        Product[] expected ={item1, item4};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewProducts (){
        ProductsRepository repo = new ProductsRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Product[] expected ={item1, item2, item3, item4};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);

    }
}
