<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File upload</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
 <div class="container">
 
	<c:if test="${not empty message}">
		<h2 class="pb-3 pt-5">${message}</h2>
		<div><a href="${request.contextPath}/file">Dodaj novi fajl</a></div>
	</c:if>

  <c:if test ="${empty message}">
 
  <h2 class="pb-3 pt-5"> Upload file</h2>
	  <s:form method="post" enctype="multipart/form-data" action="/file/upload" modelAttribute="fileWrapper">
	    <div class="row pb-2"><div class="col-2">Ime fajla</div> <div class="col-2"><s:input type ="text" path="fileName" /></div></div>
	   	<div class="row pb-2"><div class="col-2">Datum uploada </div> <div class="col-2"><s:input type ="text" path="uploadDate"/></div></div>
	    <div class="row pb-2"><div class="col-2">File </div><div class="col-2"><s:input type ="file" path="file" /></div></div>
	    <div class="row pt-3"><input class="col-2" type ="submit" value="Sačuvaj"/></div>
	  </s:form>
  </c:if>
  </div>
</body>
</html>