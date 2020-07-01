<%-- 
    Document   : registrierung.jsp
    Created on : 24.06.2020, 08:28:06
    Author     : Projektteam Freibad
--%>

<%@page import="javax.naming.NamingException"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.Freibad.beans.StatelessPersistentBeanRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.Properties"%>
<%@page import="Freibad.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrierung</title>

        <style>
            td {
                text-align: left;
                vertical-align: top;
            }

            .td_Farbe {
                color: darkslategrey;
            }

            .H_Farbe {
                background-color: darkslategray;
            }
        </style>        

    </head>

    <!-- Variablendeklarationen: -->
    <%! String vorname;
        String nachname;
        String email;
        String telefon;
        String passwort;

        Properties props;
        InitialContext ctx;
        StatelessPersistentBeanRemote persistentBean;

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

    %>

    <body>

        <script>
            function CheckEingabe() {
                return true;
            }
        </script>

        <%
            try {

                // Persistentes Bean mit JNDI-Lookup erstellen:
                ctx = new InitialContext(props);
                persistentBean = (StatelessPersistentBeanRemote) ctx.lookup("StatelessPersistentBean/remote");

                // neuen Gast anlegen:
                vorname = request.getParameter("vname");
                nachname = request.getParameter("nname");
                email = request.getParameter("mail");
                telefon = request.getParameter("telefon");
                passwort = request.getParameter("passwort");
                Gast gast = new Gast();
                gast.setVname(vorname);
                gast.setNname(nachname);
                gast.setEmail(email);
                gast.setTelefon(telefon);
                persistentBean.addGast(gast);

            } catch (Exception ex) {
                out.println("<br>" + ex.getMessage());
                ex.printStackTrace();
            }

        %>

        <form onsubmit="return CheckEingabe()" name="reservierung" action="./login.jsp">
            <table class="H_Farbe" width="100%">
                <tr>
                    <td height="100px"><h1><Font Face="Mangal" Color="white">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ONLINE-Reservierung</Font></h1>
                    </td>
                </tr>
            </table>
            <table align="center" width="1000px" cellspacing="20">
                <colgroup>
                    <col width=15%>
                    <col width=50%>
                    <col width=35%>
                </colgroup>
                <tr>
                    <td class="td_Farbe" colspan="2"><h1><b>REGISTRIERUNG</b></h1>
                        Bitte geben Sie Ihre Daten ein:
                    </td>
                    <td class="td_Farbe"><h1><b></b></h1></td>
                </tr>
                <tr>
                    <td><b>Vorname*:</b>&nbsp;</td>                    
                    <td><input type="text" id="vname" name="vname" value=""></td>                    
                    <td></td>
                </tr>
                <tr>
                    <td><b>Nachname*:</b>&nbsp;</td>
                    <td><input type="text" id="nname" name="nname" value=""></td>
                    <td></td>
                </tr>                
                <tr>
                    <td><b>Email-Adresse*:</b>&nbsp;</td>
                    <td><input type="email" id="mail" name="mail" value=""></td>
                    <td></td>
                </tr>
                <tr>
                    <td><b>Telefon-Nr.*:</b>&nbsp;</td>
                    <td><input type="tel" id="telefon" name="telefon" value=""></td>
                    <td></td>
                </tr>
                <tr>
                    <td><b>Passwort*:</b>&nbsp;</td>
                    <td><input type="password" id="geheim"  name="geheim" value=""></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td>mit * gekennzeichnete Felder müssen ausgefüllt werden</td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button type="submit" id="reg" name="reg">Registrieren</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="reset" id="loesch" name="loesch">Eingabe loeschen</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" onClick="parent.location = './start.jsp'" id="zurueck" name="zurueck">zurueck</button>
                    </td>
                    <td></td>
                </tr>
                <br><br>
            </table>
            <table class="H_Farbe" width="100%">
                <tr>
                    <td height="300px"><h1><Font Face="Mangal" Color="white"></Font></h1></td>
                </tr>
            </table>
        </form>

    </body>
</html>
