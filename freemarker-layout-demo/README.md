# Using FreeMarker teamplates in Vaadin applications

You can download the FreemarkerLayout add-on [here](https://vaadin.com/directory#!addon/freemarkerlayout-add-on) (Maven, Ivy, or JAR).

Create a template using the FreeMarker Template Language and "location" attributes, and place the file in the resources directory ([see this example](https://github.com/alejandro-du/freemarker-layout/blob/master/freemarker-layout-demo/src/main/resources/templates/products-table.html)).

Use the FreemarkerLayout class and place Vaadin components in it by using the addComponent methods and the locations defined in the template ([see this example](https://github.com/alejandro-du/freemarker-layout/blob/master/freemarker-layout-demo/src/main/java/org/vaadin/freemarker/demo/ui/ProductsTable.java)).
