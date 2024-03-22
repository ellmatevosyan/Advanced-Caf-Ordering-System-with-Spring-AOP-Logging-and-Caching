package com.picsart.java.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {HibernateConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebJspConfig.class};
    }
    @SuppressWarnings("NullableProblems")
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
