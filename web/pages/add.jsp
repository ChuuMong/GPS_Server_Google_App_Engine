<%--
  Created by IntelliJ IDEA.
  User: JongHunLee
  Date: 2015-04-21
  Time: 오후 12:04
  To change this template use File | Settings | File Templates.
--%>
<html>
<body>
<h1>Add GPS</h1>

<form method="post" action="add">
    <table>
        <tr>
            <td>UserId :</td>
            <td><input type="text" id="userId"></td>
        </tr>
        <tr>
            <td>Time :</td>
            <td><input type="text" id="time"></td>
        </tr>
        <tr>
            <td>Latitude :</td>
            <td><input type="text" id="latitude"></td>
        </tr>
        <tr>
            <td>Longitude :</td>
            <td><input type="text" id="longitude"></td>
        </tr>
    </table>
    <input type="submit" class="save" title="Save" value="Save"/>
</form>

</body>
</html>