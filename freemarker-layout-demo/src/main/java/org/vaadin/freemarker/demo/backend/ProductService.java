package org.vaadin.freemarker.demo.backend;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private final static String[] words = {
            "lorem", "ipsum", "dolor", "perferendis", "amet", "consectetur", "adipiscing", "elit", "recusandae",
            "eiusmod", "tempor", "incididunt", "labore", "dolore", "magna", "aliqua", "enim", "minim", "veniam",
            "quis", "nostrud", "exercitation", "ullamco", "laboris", "nisi", "aliquip", "voluptatem", "reprehenderit"
    };

    private final static String[] images = {
            "automation.svg", "car.svg", "cube.svg", "gamepad.svg", "gavel.svg", "keyboard.svg", "paint-roll.svg",
            "stethoscope.svg", "umbrella.svg", "wrench.svg"
    };

    private static ProductService instance = new ProductService();

    private List<Product> products = new ArrayList<>();

    private ProductService() {
        createRandomProducts();
    }

    public static ProductService getInstance() {
        return instance;
    }

    public List<Product> findAll() {
        return products;
    }

    private void createRandomProducts() {
        for (long i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(i);
            product.setName(getRandomWords(1));
            product.setDescription(getRandomWords(27));
            product.setPrice((double) (int) (Math.random() * (1000 - 300) + 300));
            product.setImage(images[(int) (Math.random() * images.length)]);

            products.add(product);
        }
    }

    private String getRandomWords(int count) {
        String string = "";

        for (int i = 0; i < count; i++) {
            int word = (int) (Math.random() * (words.length));
            string += words[word] + " ";
        }

        return string;
    }

}
