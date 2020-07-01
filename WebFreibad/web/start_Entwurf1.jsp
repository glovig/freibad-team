<%-- 
    Document   : test.jsp
    Created on : 24.06.2020, 15:05:51
    Author     : Projektteam Freibad
--%>

<%@page import="com.Freibad.beans.StatelessPersistentBeanRemote"%>
<%@page import="com.Freibad.beans.StatelessPersistentBean"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="com.Freibad.klassen.*"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.io.*,java.util.*,java.lang.*" %>
<%@page import="Freibad.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--
<jsp:useBean scope="session" id="persistentBean" class="com.Freibad.beans.StatelessPersistentBeanRemote"/>
--%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>TestStart</title>

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

<%!
    // Bean Variablen:
    Properties props;
    InitialContext ctx;
    StatelessPersistentBeanRemote persistentBean;

    // Variablen für die Formularfelder:
    String email;
    String passwort;
    String meldung;

    public boolean tabGastVorbelegen() {
        ArrayList<Gast> AL_Gast = TabInit_TestGast.listGastFuellen();
        for (int i = 0; i < AL_Gast.size(); i++) {
            persistentBean.addGast(AL_Gast.get(i));
        }
        return true;
    }

    public void tabIntervallVorbelegen() {
        persistentBean.loeschInhaltIntervallTab();
        Intervall[] intervallArray = TabInit.arrayIntervallFuellen();
        for (int i = 0; i < intervallArray.length; i++) {
            persistentBean.addIntervall(intervallArray[i]);
        }
    }

    // Tabelle FreibadTab neu initialisieren indem die alten Tabellen-Inhalte
    // gelöscht werden und die Tabelle neu bestückt wird:
    public void tabFreibadVorbelegen() {
        persistentBean.loeschInhaltFreibadTab();
        Freibad[] freibadArray = TabInit.arrayFreibadFuellen();
        for (int i = 0; i < freibadArray.length; i++) {
            persistentBean.addFreibad(freibadArray[i]);
        }
    }

    public boolean checkFormularEingabe(String mail) {
        //List<String> mailListe = new ArrayList();
        List<Gast> mailListe = new ArrayList();
        PrintWriter out = null;
        mailListe = persistentBean.getLoginMail(mail);
        if (mailListe.size() == 0) {
            meldung = "Diese email Adresse ist nicht hinterlegt!";
            return false;
        } else if (mailListe.size() == 1) {
            meldung = "email-Adresse korrekt";
            return true;
        } else {
            meldung = "email-Adresse mehr als 1x vorhanden!";
            return true;
        }
    }
%>
<%
    {
        props = new Properties();
        try {
            ctx = new InitialContext(props);
            persistentBean = (StatelessPersistentBeanRemote) ctx.lookup("StatelessPersistentBean/remote");
            HttpSession mySession = request.getSession();
            out.println("Bean ist null: " + (persistentBean == null));
            mySession.setAttribute("bean", persistentBean);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    // es werden TestGäste in die Tabelle GastTab reingeschrieben:
    // Tabelle IntervallTab neu initialisieren indem die alten Tabellen-Inhalte
    // gelöscht werden und die Tabelle neu bestückt wird:

%>

<%    out.println("Dies ist eine Ausgabe aus der Methode checkFormularEingabe(): " + meldung);
    String fehler = (String) request.getSession().getAttribute("fehler");
    out.println(fehler);
%>

<body>

    <script>
        function CheckEingabe() {
            if (<%=checkFormularEingabe(email)%> == true) {
                alert(<%=meldung%>);
                return false;
            } else {
                alert(<%=meldung%>);
                return false;
            }
            alert(<%=meldung%>);
        }
    </script>

    <%

        email = request.getParameter("email");
        passwort = request.getParameter("passwort");

    %>

  <!--  <form onsubmit="return <%=checkFormularEingabe(request.getParameter("email"))%>" id="start" name="start" action="./reservierung.jsp"> -->
    <form id="start" name="start" action="./reservierung.jsp">

        <table class="H_Farbe" width="100%">
            <tr>
                <td height="100px"><h1><Font Face="Mangal" Color="white">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ONLINE-Reservierung</Font></h1>
                </td>
            </tr>
        </table>
        <table align="center" width="1000px" cellspacing="20">
            <colgroup>
                <col width=10%>
                <col width=40%>
                <col width=50%>
            </colgroup>
            <tr>
                <td class="td_Farbe" colspan="2"><h1><b>ANMELDUNG</b></h1>
                    Bitte melden Sie sich mit ihrer email-Adresse und Ihrem Passwort an:
                </td>
                <td class="td_Farbe"><h1><b>REGISTRIERUNG</b></h1>
                    Wenn Sie noch keine Anmeldedaten haben können Sie sich hier registrieren:
                </td>
            </tr>
            <tr>
                <td><b>E-Mail*:</b>&nbsp;</td>
                <td><input type="email" id="email" name="email" value="" required></td>
                <td></td>
            </tr>
            <tr>
                <td><b>Passwort*:</b>&nbsp;</td>
                <td><input type="password" id="passwort" name="passwort" value="" required></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td>mit * gekennzeichnete Felder müssen ausgefüllt werden</td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <!--            <td><input type="submit" id="sende" name="sende" value="Login"></td>  -->
                <!-- <td><input type="button" onclick="pruefeLogin()" id="sende" name="sende" value="Login"></td> -->
                <!-- <td><button onclick="<% out.println("wwwwww");%>" id="sende" name="sende">Login</button></td> -->

                <td>
                    <!--    <button type="button" onclick="pruefeLogin()" id="sende" name="sende">Login</button> -->
                    <button type="submit" id="log" name="log">Login</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="reset" id="loesch" name="loesch">Eingabe loeschen</button>
                </td>
                <td><button type="button" onClick="parent.location = './registrierung.jsp'" id="reg" name="reg">Registrieren</button></td>

            <button onclick="myFunction()">Click me</button>

            </tr>
            <br><br>
        </table>
        <table class="H_Farbe" width="100%">
            <tr>
                <td height="300px"><h1><Font Face="Mangal" Color="white"></Font></h1></td>
            </tr>
        </table>
    </form>  

    <p id="demo"></p>
    <script>
        function myFunction() {
            var z = "EDEFGVC";
            document.getElementById("demo").innerHTML = "WWWWWWW" + z;
            z = z + "+++++";
        }
    </script>

</body>

</html>
