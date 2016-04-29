package org.vaadin.freemarker.demo.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.freemarker.demo.backend.Product;
import org.vaadin.freemarker.demo.backend.ProductService;

import javax.servlet.annotation.WebServlet;
import java.util.List;

@Theme("valo")
public class DemoUI extends UI {

    private ProductService service = ProductService.getInstance();

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = DemoUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        List<Product> products = service.findAll();
        ProductTable productsTable = new ProductTable(products);

        VerticalLayout layout = new VerticalLayout(productsTable);
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
    }

}

