package org.vaadin.freemarker;

import com.vaadin.ui.CustomLayout;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;

public class FreemarkerLayout extends CustomLayout {

    private static Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);

    static {
        configuration.setClassForTemplateLoading(FreemarkerLayout.class, "/");
    }

    private String templateFileName;

    private Object dataModel;

    public FreemarkerLayout() {
    }

    public FreemarkerLayout(String templateFileName) {
        this.templateFileName = templateFileName;
        this.dataModel = this;
    }

    public FreemarkerLayout(String templateFileName, Object dataModel) {
        this.templateFileName = templateFileName;
        this.dataModel = dataModel;
    }

    @Override
    public void attach() {
        try {
            super.attach();

            Template template = configuration.getTemplate(templateFileName);
            StringWriter writer = new StringWriter();
            template.process(dataModel, writer);
            String html = writer.toString();
            setTemplateContents(html);

        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTemplateFileName() {
        return templateFileName;
    }

    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
    }

    public Object getDataModel() {
        return dataModel;
    }

    public void setDataModel(Object dataModel) {
        this.dataModel = dataModel;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(Configuration configuration) {
        FreemarkerLayout.configuration = configuration;
    }

}
