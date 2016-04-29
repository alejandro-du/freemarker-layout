package org.vaadin.freemarker.demo.ui;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Image;
import org.vaadin.freemarker.FreemarkerLayout;
import org.vaadin.freemarker.demo.backend.Product;

@StyleSheet("vaadin://styles/product.css")
public class ProductDetails extends FreemarkerLayout {

    private Product product;

    public ProductDetails(Product product) {
        super("templates/product-details.html");
        this.product = product;

        Image image = new Image(null, new ClassResource("/icons/" + product.getImage()));
        addComponent(image, "image");
    }

    public Product getProduct() {
        return product;
    }

}
