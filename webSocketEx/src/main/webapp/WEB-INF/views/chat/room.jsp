<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${room.name}</title>
    <script src="/webjars/jquery/dist/jquery.min.js"></script>
    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
</head>
<body>
<h1>${room.name}(${room.id})</h1>
<div class="content" data-room-id="${room.id}" data-member="${member}">
    <ul class="chat_box">
    </ul>
    <input name="message">
    <button class="send">보내기</button>
</div>
<script>
    $(function () {
        var chatBox = $('.chat_box');
        var messageInput = $('input[name="message"]');
        var sendBtn = $('.send');
        var roomId = $('.content').data('room-id');
        var member = $('.content').data('member');

        // handshake
        var sock = new SockJS("/gs-guide-websocket");
        var client = Stomp.over(sock); // 1. SockJS를 내부에 들고 있는 client를 내어준다.

	     // 2. connection이 맺어지면 실행된다.
        client.connect({}, function () {
            // 3. send(path, header, message)로 메시지를 보낼 수 있다.
            client.send('/publish/chat/join', {}, JSON.stringify({chatRoomId: roomId, writer: member})); 
            // 4. subscribe(path, callback)로 메시지를 받을 수 있다. callback 첫번째 파라미터의 body로 메시지의 내용이 들어온다.
            client.subscribe('/subscribe/chat/room/' + roomId, function (chat) {
                var content = JSON.parse(chat.body);
                chatBox.append('<li>' + content.message + '(' + content.writer + ')</li>')
            });
        });

        sendBtn.click(function () {
            var message = messageInput.val();
            client.send('/publish/chat/message', {}, JSON.stringify({chatRoomId: roomId, message: message, writer: member}));
            messageInput.val('');
        });
    });
</script>
</body>
</html>