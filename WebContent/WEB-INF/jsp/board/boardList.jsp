<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    


<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">
<style type="text/css">
	tr.bId:hover {background-color : lightyellow;}
	body{background-image:url("/20210129/image/front.jpg");}

	tr.bId:hover {background-color : lightyellow;}
	body{background-image:url("/20210129/image/front.jpg");}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 70%;
  bgcolor:white;
}

td, th {
  border: 1px solid #000000;
  text-align: center;
  padding: 5px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>


<!--스트립트 작업 영역--> 
<script type="text/javascript">
function formSubmit(str) {
	frm.bId.value=str;
	frm.submit();
}
</script>

<jsp:include page = "../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px; margin-top:46px"  align="center">
		<span style="color: white;">
		<h1>게시글 목록</h1>
				</span>
		<div>
		
			<form id="frm" name="frm" action="boardView.do" method="post">
				<input type="hidden" id="bId" name="bId">
			</form>
			<table border="1" id="tableMenu" bgcolor="white">
				<tr>
					<th width="100">글번호</th>
					<th width="200">제 목</th>
					<th width="100">작성자</th>
					<th width="100">작성일</th>
					<th width="200">글내용</th>
					<th width="100">조회수</th>
				</tr>
				<c:choose>
					<c:when test="${not empty list}" >
						<c:forEach var="vo" items="${list }">
						<tr class="bId" onclick="formSubmit(${vo.bId })">
								<td align="center">${vo.bId }</td>
								<td>&nbsp;${vo.bTitle }</td>
								<td align="center">${vo.bName }</td>
								<td align="center">${vo.bDate }</td>
								<td align="center">${vo.bContent }</td>
								<td align="center">${vo.bHit }</td>
							</tr>
						</c:forEach>						
					</c:when>
				</c:choose>
			</table>
		</div><br />

		<div>
		<button type="button" size="10" onclick="location.href='boardInsertForm.do'">새글쓰기</button>
		</div>
	</div>
	
</div>
