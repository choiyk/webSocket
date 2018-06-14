<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="${R}webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${R}webjars/jquery/jquery.min.js"></script>
<script src="${R}webjars/sockjs-client/sockjs.min.js"></script>
<script src="${R}webjars/stomp-websocket/stomp.min.js"></script>
<script src="${R}res/message.js"></script>
</head>
<body>
<div class="container">
  <h1>모임 정보</h1>
  <form method="post">
    <div class="form-group">
      <label>name:</label>
      <input id="name" name="name" class="form-control" />
    </div>
    <button id="send" type="submit" class="btn btn-primary">
      <i class="glyphicon glyphicon-ok"></i> 저장
    </button>
    <a href="list" class="btn btn-default">
      <i class="icon icon-list"></i> 목록으로
    </a>
  </form>
  <c:if test="${ not empty message }">
    <div class="alert alert-info">${ message }</div>
  </c:if>
</div>
</body>
</html>
