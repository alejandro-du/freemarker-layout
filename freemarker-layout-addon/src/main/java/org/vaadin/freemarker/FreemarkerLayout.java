package org.vaadin.freemarker;

import com.vaadin.ui.CustomLayout;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;

/**
 * A specialized {@link com.vaadin.ui.CustomLayout} that allows using
 * <a href="http://freemarker.org/">Apache Freemarker</a> templates.
 */
public class FreemarkerLayout extends CustomLayout {

    private static Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);

    static {
        configuration.setClassForTemplateLoading(FreemarkerLayout.class, "/");
    }

    private String templateFileName;

    private Object dataModel;

    /**
     * Default constructor. You need to specify a templateFileName before attaching this component.
     * See the {@link #setTemplateFileName(String)} method.
     */
    public FreemarkerLayout() {
        this(null);
    }

    /**
     * Constructs a FreemarkerLayout using the specified template file name.
     * By default, a {@link freemarker.cache.ClassTemplateLoader ClassTemplateLoader} is used to load the template.
     * If you want to use a different template loader, you can get the static {@link Configuration} instance using the
     * {@link #getConfiguration()} method.
     *
     * @param templateFileName name of the file to use as a template.
     */
    public FreemarkerLayout(String templateFileName) {
        setTemplateFileName(templateFileName);
        setDataModel(this);
    }

    /**
     * Constructs a FreemarkerLayout using the specified template file name and data model.
     * By default, a {@link freemarker.cache.ClassTemplateLoader ClassTemplateLoader} is used to load the template.
     * If you want to use a different template loader, you can get the static {@link Configuration} instance using the
     * {@link #getConfiguration()} method.
     *
     * @param templateFileName
     * @param dataModel
     */
    public FreemarkerLayout(String templateFileName, Object dataModel) {
        setTemplateFileName(templateFileName);
        setDataModel(dataModel);
    }

    @Override
    public void attach() {
        super.attach();
        processTemplate();
    }

    /**
     * @return the template's file name.
     */
    public String getTemplateFileName() {
        return templateFileName;
    }

    /**
     * Sets the template's file name.
     */
    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
    }

    /**
     * @return the data model to use when processing the Freemarker template.
     */
    public Object getDataModel() {
        return dataModel;
    }

    /**
     * Sets the data model to use when processing the Freemarker template.
     */
    public void setDataModel(Object dataModel) {
        this.dataModel = dataModel;
    }

    /**
     * @return the {@link Configuration} used to process the Freemarker template.
     * Notice that this configuration is shared between all instances of FreemarkerTemplate.
     */
    public static Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Sets the {@link Configuration} to use when processing the Freemarker template.
     * Notice that this configuration is shared between all instances of FreemarkerTemplate.
     */
    public static void setConfiguration(Configuration configuration) {
        FreemarkerLayout.configuration = configuration;
    }

    private void processTemplate() {
        try {
            if (templateFileName != null) {
                Template template = configuration.getTemplate(templateFileName);
                StringWriter writer = new StringWriter();
                template.process(dataModel, writer);
                String html = writer.toString();
                setTemplateContents(html);
            }
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }

}
