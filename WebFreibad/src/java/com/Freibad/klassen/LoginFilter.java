/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Freibad.klassen;

import com.Freibad.beans.StatelessPersistentBeanRemote;
import java.io.IOException;
import java.util.logging.LogRecord;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/reservierung.jsp")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(true);
        String loginURI = request.getContextPath() + "/test.jsp";

       // boolean loggedIn = session != null && session.getAttribute("user") != null;
       String email = req.getParameter("email");
       
       StatelessPersistentBeanRemote bean = (StatelessPersistentBeanRemote)session.getAttribute("bean");
              boolean loggedIn = bean != null && bean.getLoginMail(email).size() > 0;

       boolean loginRequest = request.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        } else {
            request.getSession().setAttribute("fehler", "Anmeldungsfehler");
            response.sendRedirect(loginURI);
        }
    }

    // ...

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}