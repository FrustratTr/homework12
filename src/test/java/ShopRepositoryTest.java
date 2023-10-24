import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {
    private ShopRepository shopRepository;

    @BeforeEach
    public void setUp() {
        shopRepository = new ShopRepository();
        shopRepository.add(new Product(1, "Product1", 100));
        shopRepository.add(new Product(2, "Product2", 200));
    }

    @Test
    public void testSuccessfulRemoval() {
        shopRepository.removeById(1);
        Product[] products = shopRepository.findAll();
        assertEquals(1, products.length);
        assertEquals(2, products[0].getId());
    }

    @Test
    public void testNonExistentElementRemoval() {
        NotFoundException exception = assertThrows(NotFoundException.class, () -> shopRepository.removeById(3));
        assertEquals("Element with id: 3 not found", exception.getMessage());
    }
}

