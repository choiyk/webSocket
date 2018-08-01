<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>채팅방 목록</h1>
<ul>
    <c:forEach var="room" items="rooms">
    <li><a href="/chat/rooms/${room.id }">${room.name }</a></li>
   	</c:forEach>
</ul>