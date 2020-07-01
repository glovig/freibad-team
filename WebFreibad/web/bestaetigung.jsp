<%-- 
    Document   : bestaetigung
    Created on : 27.06.2020, 13:32:18
    Author     : Projektteam Freibad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bestaetigung</title>

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

    %>

    <%

    %>

    <body>

        <form name="reservierung" action="./start.jsp">
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
                    <td class="td_Farbe" colspan="2"><h1><b>BESTAETIGUNG</b></h1>
                        Wir bestaetigen Ihre Reservierung mit folgender Reservierungsnummer:
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>                    
                    <td>
                        <input type="text" name="nr" id="nr" value="">
                    </td>                    
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2">Bitte bewahren Sie Ihre Nummer gut auf und zeigen sie diese an der Kasse vor.</td>
                    <td></td>
                </tr>


                <tr>
                    <td><b></b>&nbsp;</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button type="submit" id="start" name="start">zurueck zur Startseite</button>
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
