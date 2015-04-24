<%--
  Created by IntelliJ IDEA.
  User: JongHunLee
  Date: 2015-04-21
  Time: 오전 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.gps.server.model.GPS" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<html>
<body>
<h1>GAE + Spring 3 MVC REST + CRUD Example with JDO</h1>

Function : <a href="add">Add GPS</a>
<hr/>

<h2>All GPS</h2>
<table border="1">
    <thead>
    <tr>
        <td>User Id</td>
        <td>Time</td>
        <td>Latitude</td>
        <td>Longitude</td>
    </tr>
    </thead>

    <%

        if (request.getAttribute("gpsList") != null) {

            List<GPS> customers =
                    (List<GPS>) request.getAttribute("gpsList");

            if (!customers.isEmpty()) {
                for (GPS gps : customers) {

    %>
    <tr>
        <td><%=gps.getUserId() %>
        </td>
        <td><%=gps.getTime() %>
        </td>
        <td><%=gps.getLatitude() %>
        </td>
        <td><%=gps.getLongitude() %>
        </td>
    </tr>
    <%

                }

            }

        }
    %>

    </tr>

</table>

</body>
</html>