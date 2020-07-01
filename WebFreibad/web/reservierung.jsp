<%-- 
    Document   : reservierung.jsp
    Created on : 24.06.2020, 15:05:51
    Author     : Projektteam Freibad
--%>

<%@page import="com.Freibad.klassen.CheckReservierDat"%>
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
        <title>Reservierung</title>

        <script>
            function CheckAuswahl() {
                if (document.reservierung.freibad.options[6].selected == true) {
                    alert("Bitte wählen Sie einen Eintrag für Freibad!");
                    return false;
                } else if (document.reservierung.tageszeit.options[3].selected == true) {
                    alert("Bitte wählen Sie einen Eintrag für die Tageszeit!");
                    return false;
                }
                return true;
            }
        </script>

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
    <%!
        // Datums-Array für das Datumsfeld im Formular:
        String[] datArray = new String[3];
        
        // Variablen für das Bean:
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

    <%
        // Datums-Rückgabewerte für das Datumsfeld im Formular. Es werden das Anzeigedatum,
        // das frühest mögliche und das spätest mögliche Reservierungsdatum zurückgegeben:
        datArray = CheckReservierDat.datfeldReservierung();
    %>
    
    <body>

        <% 
            try {

                // Persistentes Bean mit JNDI-Lookup erstellen:
                ctx = new InitialContext(props);
                persistentBean = (StatelessPersistentBeanRemote) ctx.lookup("StatelessPersistentBean/remote");

            } catch (Exception ex) {
                out.println("<br>" + ex.getMessage());
                ex.printStackTrace();
            }

        %>

        <form onsubmit="return CheckAuswahl()" name="reservierung" action="./bestaetigung.jsp">
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
                    <td class="td_Farbe" colspan="2"><h1><b>RESERVIERUNG</b></h1>
                        Bitte geben Sie Ihre Daten ein:<br>
                        Es kann nur für den Folgetag bis max. 7 Tage in die Zukunft gebucht werden:
                    </td>
                    <td class="td_Farbe"><h1><b></b></h1></td>
                </tr>
                <tr>
                    <td><b>Freibad*:</b>&nbsp;</td>                    
                    <td>
                        <select name="freibad" size="1">
                            <option value="naturgartenbad">Naturgartenbad</option>
                            <option value="stadionbad">Stadionbad</option>
                            <option value="westbad">Westbad</option>
                            <option value="clubbad">Clubbad</option>
                            <option value="bayer07">Freibad Bayer 07</option>
                            <option value="langsee">Freibad Langsee</option>
                            <option selected></option>
                        </select>
                    </td>                    
                    <td></td>
                </tr>
                <tr>
                    <td><b>Wochentag*:</b>&nbsp;</td>
                    <td><input type="date" id="wochentag" name="wochentag" required></td>
                <script>
                    //      document.getElementById("wochentag").min = minDat;
                    //      document.getElementById("wochentag").max = maxDat;
                    document.reservierung.wochentag.value = "<%=datArray[0]%>";
                    document.reservierung.wochentag.min = "<%=datArray[1]%>";
                    document.reservierung.wochentag.max = "<%=datArray[2]%>"; 
                   
                </script>
                <td></td>
                </tr>


                <tr>
                    <td><b>Tageszeit*:</b>&nbsp;</td>
                    <td>
                        <select name="tageszeit" size="1" required>
                            <option>morgens</option>
                            <option>nachmittags</option>
                            <option>abends</option>
                            <option selected></option>
                        </select>
                    </td>
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
                        <button type="submit" id="reg" name="reg">Reservierung</button>
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
