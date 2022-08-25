public class ProductsRepository {

    private Product[] items = new Product[0];

    public Product[] findById(int id) {
        ProductsRepository searchResult = new ProductsRepository();
        for (Product product : getItems()) {
            if (product.getId() == id) {
                searchResult.save(product);
                return searchResult.getItems();
            }
        }
        return null;
    }

    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "товар c ID " + id + " не найден"
            );
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
        return tmp;
    }

    public Product[] getItems() {
        return items;
    }
}
