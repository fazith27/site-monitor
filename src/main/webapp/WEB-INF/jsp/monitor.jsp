<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta http-equiv="refresh" content="30">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>
    .header {
      font-family: Arial, Helvetica, sans-serif;
      padding: 20px;
      text-align: center;
      font-size: 30px;
    }
    #status {
      font-family: Arial, Helvetica, sans-serif;
      border-collapse: collapse;
      width: 30%;
      table-layout: auto;
      margin-left: auto;
      margin-right: auto;
      border-radius: 1em;
      overflow: hidden;
    }

    #status td, #status th {
      border: 1px solid #ddd;
      padding: 8px;
      white-space:nowrap
    }

    #status tr{background-color: #f2f2f2;}

    #status tr:hover {background-color: #ddd;}

    #status th {
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: center;
      background-color: #A9A9A9;
      color: white;
    }

    #url {
      border: 1px solid grey;
      border-radius: 5px;
      opacity: 0.25;
      width: 100%;
      height: 20px;
    }
    #submit {
      border: 1px solid grey;
      border-radius: 5px;
      width: 100%;
      height: 20px;
    }

    #error {
      color: #a94442;
      background-color: #f2dede;
      border-color: #f2dede;
      width: 28%;
      margin-left: auto;
      margin-right: auto;
      border: 1px solid #f2dede;
      border-radius: 5px;
      padding: 3px;
      margin-bottom: 10px;
    }
    </style>
</head>
<body>
<p class="header">Health status <small>(refresh every 30 seconds)</small></p>
<c:if test = "${not empty error}">
<div id="error">
  <strong>Error : </strong> ${error} !
</div>
</c:if>
<form method="post" action="/">
  <table id="status">
    <tr>
      <th>Site URL</th>
      <th>Status</th>
    </tr>
    <c:forEach var="map" items="${monitorstatus}">
    <tr>
      <td>${map.key}</td>
      <td class="value" >${map.value}</td>
    </tr>
    </c:forEach>
    <tr>
      <td><input type="text" id="url" name="url" value="Add URL here"></td>
      <td><input type="submit" id="submit" value="Add" /></td>
    </tr>
  </table>
</form>
</body>
<script>
$(document).ready(function(){
  $('td.value').each(function(){
    if($(this).text() == 200){
        $(this).css('background-color','#5BC85B');
        $(this).text('');
    }else {
        $(this).css('background-color','#ff6347');
        $(this).text('');
    }
  });
  $('#url').click(function(){
    if($(this).val() == 'Add URL here'){
      $(this).val('');
      $(this).css('opacity', '1');
    }
  });
  $('#url').focusout(function(){
      if($(this).val() == ''){
        $(this).val('Add URL here');
        $(this).css('opacity', '0.25');
      }
    });
});
</script>
</html>