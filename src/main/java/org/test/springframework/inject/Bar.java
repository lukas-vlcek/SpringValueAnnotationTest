package org.test.springframework.inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Bar extends HttpServlet {

    @Value("#{ values['one'] }") private int one;
    @Value("#{ values['two'] }") private int two;

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
        os.println("Hi there, you are in Bar...");
        os.print("one: ");
        os.println(one);
        os.print("two: ");
        os.println(two);
        os.flush();
    }
}
