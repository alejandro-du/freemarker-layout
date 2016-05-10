# Downloading and running the example application

```
git clone https://github.com/alejandro-du/freemarker-layout.git

cd freemarker-layout/freemarker-layout-demo

mvn clean install jetty:run

```

Go to [http://localhost:8080](http://localhost:8080)

# Using FreeMarker templates in your Vaadin applications

1. Download the FreemarkerLayout add-on [here](https://vaadin.com/directory#!addon/freemarkerlayout-add-on) (Maven, Ivy, or JAR).

2. Create a template using the FreeMarker Template Language and "location" attributes, and place the file in the resources directory ([see this example](https://github.com/alejandro-du/freemarker-layout/blob/master/freemarker-layout-demo/src/main/resources/templates/products-table.html)).

3. Use the FreemarkerLayout class and place Vaadin components in it by using the addComponent methods and the locations defined in the template ([see this example](https://github.com/alejandro-du/freemarker-layout/blob/master/freemarker-layout-demo/src/main/java/org/vaadin/freemarker/demo/ui/ProductsTable.java)).
