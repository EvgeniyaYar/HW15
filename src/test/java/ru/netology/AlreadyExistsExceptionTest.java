package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlreadyExistsExceptionTest {

    @Test
    public void shouldThrowAlreadyExistsException() {
        Product product = new Product(5, "fish", 200);
        Product product1 = new Product(5, "milk", 100);

        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product);

        Assertions.assertThrows(AlreadyExistsException.class, () ->{
            shopRepository.add(product1);
        });
    }

    @Test
    public void shouldAddProduct() {
        Product product = new Product(5, "fish", 200);
        Product product1 = new Product(6, "milk", 100);

        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product);
        shopRepository.add(product1);

        Product[] expected = {product, product1};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
