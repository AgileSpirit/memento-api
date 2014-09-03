package io.memento.infra.config;

import com.codahale.metrics.servlets.AdminServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebAppInitializer.class);

    @Override
    public void onStartup(ServletContext container) {
        addSpringWebSupport(container);
    }

    private void addSpringWebSupport(ServletContext container) {
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(ApplicationConfig.class);
        dispatcherContext.getEnvironment().setDefaultProfiles("localhost");

        // Register and map the dispatcher servlet
        LOGGER.info("Add servlet : DispatcherServlet");
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        servlet.setLoadOnStartup(getServletIndex());
        servlet.addMapping("/*");
        
        /*
         * This listener is required for ServletListener to be aware of Spring context (ex: Metrics servlets)
         */
        container.addListener(new ContextLoaderListener(dispatcherContext));
    }

    private static int servletIndex = 0;

    private final static int getServletIndex() {
        return ++servletIndex;
    }
}
