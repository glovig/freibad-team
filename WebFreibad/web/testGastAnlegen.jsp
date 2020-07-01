<%-- 
    Document   : testGastAnlegen
    Created on : 28.06.2020, 12:52:30
    Author     : Projektteam Freibad
--%>

<%@page import="com.Freibad.klassen.testGast"%>
<%@page import="Freibad.Gast"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.Freibad.beans.StatelessPersistentBeanRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.Properties"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Gäste anlegen</title>
    </head>
    <body>
        <%!
            Properties props;
            InitialContext ctx;
            StatelessPersistentBeanRemote beanObjekt = null;
        %>

        <%
            {
                props = new Properties();
                try {
                    props.load(new FileInputStream("jndi.properties"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    ctx = new InitialContext(props);
                } catch (NamingException ex) {
                    ex.printStackTrace();
                }
            }
            // Persistentes Bean mit JNDI-Lookup erstellen:
            try {

                // Persistentes Bean mit JNDI-Lookup erstellen:
                ctx = new InitialContext(props);
                beanObjekt = (StatelessPersistentBeanRemote) ctx.lookup("StatelessPersistentBean/remote");

            } catch (Exception ex) {
                System.out.println("<br>" + ex.getMessage());
                ex.printStackTrace();
            }

            // Testgaeste anlegen:
            Gast[] gastArray = testGast.arrayGastFuellen();
            for (int i = 0; i < gastArray.length; i++) {
                beanObjekt.addGast(gastArray[i]);
            }
        %>

    </body>
</html>
