package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldThrowNotFoundException() {
        Product product = new Product(5, "milk", 100 );
        Product product1 = new Product(6, "fish", 200);
        Product product2 = new Product(7, "bread", 50);

        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product);
        shopRepository.add(product1);
        shopRepository.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(10);
        });
    }

    @Test
    public void shouldRemoveProductById() {
        Product product = new Product(5, "milk", 100 );
        Product product1 = new Product(6, "fish", 200);
        Product product2 = new Product(7, "bread", 50);

        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product);
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.removeById(product1.getId());

        Product[] expected = {product, product2};
        Product[] actual = shopRepository.findAll();


        Assertions.assertArrayEquals(expected, actual);;

    }

}
