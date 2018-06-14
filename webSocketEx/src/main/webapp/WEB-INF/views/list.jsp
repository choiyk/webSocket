<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${R}webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${R}webjars/jquery/jquery.min.js"></script>
<script src="${R}webjars/sockjs-client/sockjs.min.js"></script>
<script src="${R}webjars/stomp-websocket/stomp.min.js"></script>
<script src="${R}res/message.js"></script>
</head>
<body>
  <div class="container">
    <h1>Meeting</h1>
    <div id="message"></div>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>id</th>
          <th>name</th>
          <th>explain</th>
          <th>date</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="meeting" items="${ meetings }">
          <tr>
            <td>${ meeting.id }</td>
            <td>${ meeting.name }</td>
            <td>${ meeting.explains }</td>
            <td>${ meeting.date }</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>

