import java.util.Arrays;

public class ShopRepository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = product;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        int indexToRemove = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == id) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }

        Product[] newProducts = new Product[products.length - 1];
        int newIndex = 0;
        for (int i = 0; i < products.length; i++) {
            if (i != indexToRemove) {
                newProducts[newIndex] = products[i];
                newIndex++;
            }
        }

        products = newProducts;
    }
}
