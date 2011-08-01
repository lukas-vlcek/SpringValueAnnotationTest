package org.test.springframework.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.test.springframework.bean.ConfigBean;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Lorem extends HttpServlet {

    @Autowired(required = true)
    private ConfigBean bean;

    @Override
        public void init(ServletConfig config) throws ServletException {
            super.init(config);
            SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream os = response.getOutputStream();
        os.println("Hi there, you are in Foo...");
        os.println("Values: ");
        os.println(" one: " + bean.getOne());
        os.println(" two: " + bean.getTwo());
        os.println(" three: " + bean.getThree());
        os.flush();
    }
}
