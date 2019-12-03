<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Keep Note</title>
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send 
		 button. Handle errors like empty fields -->
<form action="saveNote" method="post">
<table>
<tr>
<td><label>Note ID</label></td>
<td><input type="text" name="noteId"/></td>
</tr>
<tr>
<td><label>Note Title</label></td>
<td><input type="text" name="noteTitle"/></td>
</tr>
<tr>
<tr>
<td><label>Note Content</label></td>
<td><input type="text" name="noteContent"/></td>
</tr>
<td><label>Note Status</label></td>
<td><input type="text" name="noteStatus"/></td>
</tr>
<tr>
<td><input type="submit" value="Add Note" ></td>
</tr>
</table>
</form>

	
<table border="1">
<tr>
<td>Note ID</td>
<td>Note Title</td>
<td>Note Content</td>
<td>Note Status</td>
<td>Note Created Time</td>
</tr>
<c:forEach items="${noteList}" var="note"> 
 <form action="deleteNote" method="post"> 
<tr>
<td><input type="text" name="noteId" value="${note.noteId}"/></td>
<td>${note.noteTitle}</td>
<td>${note.noteContent}</td>
<td>${note.noteStatus}</td>
<td>${note.createdAt}</td>
<td><input type="submit" value="delete"/></td>
</tr>
</form>
</c:forEach>
</table>
</body>
</html>