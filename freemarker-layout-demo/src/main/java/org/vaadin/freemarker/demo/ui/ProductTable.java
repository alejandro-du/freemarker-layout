package org.vaadin.freemarker.demo.ui;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import org.vaadin.freemarker.FreemarkerLayout;
import org.vaadin.freemarker.demo.backend.Product;

import java.util.List;

public class ProductTable extends FreemarkerLayout {

    private List<Product> products;

    public ProductTable(List<Product> products) {
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
        Window window = new Window("Details", new ProductDetails(product));
        window.setWidth("380px");
        window.setModal(true);
        window.setResizable(false);
        UI.getCurrent().addWindow(window);
    }

}
