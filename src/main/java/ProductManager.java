public class ProductManager {

    private ProductsRepository repo;

    public ProductManager(ProductsRepository repo) {
        this.repo = repo;
    }

    public void add(Product item) {
        repo.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        ProductsRepository searchResult = new ProductsRepository();
        for (Product product : repo.getItems()) {
            if (matches(product, text)) {
                searchResult.save(product);
                result = searchResult.getItems();
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

    public Product[] getItems() {
        Product[] findAll = repo.getItems();
        Product[] reversed = new Product[findAll.length];

        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = findAll[i];
        }
        return reversed;
    }


}

