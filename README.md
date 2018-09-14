[![Published on Vaadin  Directory](https://img.shields.io/badge/Vaadin%20Directory-published-00b4f0.svg)](https://vaadin.com/directory/component/freemarkerlayout-add-on)
[![Stars on vaadin.com/directory](https://img.shields.io/vaadin-directory/star/freemarkerlayout-add-on.svg)](https://vaadin.com/directory/component/freemarkerlayout-add-on)

# FreemarkerLayout

FreemarkerLayout allows you to define templates using the [FreeMarker Template Language](http://freemarker.org) to dynamically generate HTML layouts and add Vaadin components into it.

Components are located in the template by using the "location" attribute in the same way [CustomLayout](https://vaadin.com/api/com/vaadin/ui/CustomLayout.html) does.

## Examples

### Basic usage

You can use a template like the following:

```html
<div class="product">
    <div class="left">
        <div class="price">$${price}</div>
        <div class="image"><span location="image"></span></div>
        <div class="name">${name?capitalize}</div>
    </div>
    <div class="right">
        <div class="description">${description?cap_first}</div>
    </div>
</div>
```

And use the FreemarkerLayout class to read this template as follows:
```java
FreemarkerLayout productLayout = new FreemarkerLayout();
productLayout.setTemplateFileName("templates/product-details.html"); // file located in the webapp/VAADIN/templates directory
productLayout.setDataModel(product);
productLayout.addComponent(new Image(null, new ClassResource(product.getImage())), "image");
```

### Adding JavaScript and CSS

You can use the [@JavaScript](https://vaadin.com/api/com/vaadin/annotations/JavaScript.html) and the [@StyleSheet](https://vaadin.com/api/com/vaadin/annotations/StyleSheet.html) when extending FreemarkerLayout:

```java
@JavaScript({"vaadin://scripts/jquery-1.12.3.min.js", "vaadin://scripts/jquery-ui.js", "vaadin://scripts/paging.js"})
@StyleSheet({"vaadin://styles/products-table.css", "vaadin://styles/product-details.css"})
public class ProductsTable extends FreemarkerLayout {

    private List<Product> products;

    public ProductsTable(List<Product> products) {
        super("templates/products-table.html");
        
        ...
    }
    
    ...
}
```

## Downloading and running the example application

```
git clone https://github.com/alejandro-du/freemarker-layout.git

cd freemarker-layout/freemarker-layout-demo

mvn clean install jetty:run

```
Go to [http://localhost:8080](http://localhost:8080)

## Licence
The code is licensed under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.txt).
