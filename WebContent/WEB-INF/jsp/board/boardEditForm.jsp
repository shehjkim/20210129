<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
	body{background-image:url("/20210129/image/front.jpg");}
</style>

<jsp:include page = "../main/menu.jsp" />
<div class="w3-content" style="max-width:2000px; margin-top:46px"  align="center">
	<span style="color: white;">
	<div><h1>게시글 수정</h1></div>
	</span>
		<div>
			<form id="frm" name="frm" action="boardEditSave.do" method="post">
				<input type="hidden" id="bId" name="bId" value="${vo.bId }">
			<div><br />
				<table border="1" bgcolor="white">
					<tr>
						<th width="150">글번호</th>
						<td align="center" id="bId" name="bId" width="50">${vo.bId }</td>
						<th width="100">작성자</th>
						<td align="center" d="bName" name="bName" width="50">${vo.bName }</td>
						<th width="100">작성일자</th>
						<td align="center" d="bDate" name="bDate" width="50">${vo.bDate }</td>
						<th width="100">조회수</th>
						<td align="center" d="bHit" name="bHit" width="50">${vo.bHit }</td>
					</tr>
					<tr>
						<th width="60">제목</th>
						<td colspan="7" id="bTitle" name="bTitle">${vo.bTitle }</td>
					</tr>
					<tr>
						<th width="50">내용</th>
						<td colspan="7"><textarea id="bContent" name="bContent" rows="30" cols="100" >${vo.bContent }</textarea></td>
					</tr>
					
				</table>
		</div><br />
			<input type="submit" value="등록">
			<button type="reset" >취소</button>
	</form>
	</div>
</div>
