package org.vaadin.freemarker.demo.ui;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import org.vaadin.freemarker.FreemarkerLayout;
import org.vaadin.freemarker.demo.backend.Product;

import java.util.List;

@JavaScript({"vaadin://scripts/jquery-1.12.3.min.js", "vaadin://scripts/jquery-ui.js", "vaadin://scripts/paging.js"})
public class ProductsTable extends FreemarkerLayout {

    private List<Product> products;

    public ProductsTable(List<Product> products) {
        super("templates/products-table.html");
        this.products = products;

        for (Product product : products) {
            Button button = new Button(null, FontAwesome.INFO_CIRCLE);
            button.addClickListener(e -> showDetails(product));
            addComponent(button, "details-button-" + product.getId());
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    private void showDetails(Product product) {
        FreemarkerLayout productLayout = new FreemarkerLayout();
        productLayout.setTemplateFileName("templates/product-details.html");
        productLayout.setDataModel(product);
        productLayout.addComponent(new Image(null, new ClassResource(product.getImage())), "image");

        Window window = new Window("Details", productLayout);
        window.setModal(true);
        window.setResizable(false);
        UI.getCurrent().addWindow(window);
    }

}
