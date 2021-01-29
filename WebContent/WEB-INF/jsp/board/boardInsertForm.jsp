<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
	body{background-image:url("/20210129/image/front.jpg");}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 80%;
  bgcolor:white;
}
th {
  border: 1px solid #000000;
  text-align: center;
  padding: 5px;
}
</style>
<jsp:include page = "../main/menu.jsp" />
<div class="w3-content" style="max-width:2000px; margin-top:46px"  align="center">	
	<span style="color: white;">
	<div><h1>게시글 작성</h1></div>
	</span>
		<div>
			<form id="frm" name="frm" action="boardInsert.do" method="post">
			<div><br />
				<table border="1" bgcolor="white">
					<tr>
						<th width="150">글번호</th>
						<td align="center" width="50">${vo.bId }</td>
						<th width="100">작성자</th>
						<td align="center" width="50"><input type="text" id="bName" name="bName" required="required"></td>
						<th width="100">작성일자</th>
						<td align="center" width="50"><input type="date" id="bDate" name="bDate" required="required"></td>
					</tr>
					<tr>
						<th width="60">제목</th>
						<td colspan="5"><input type="text" id="bTitle" name="bTitle"
							size="100" required="required"></td>
					</tr>
					<tr>
						<th width="50">내용</th>
						<td colspan="5"><textarea id="bContent" name="bContent" rows="30" cols="100" required="required"></textarea></td>
					</tr>
				</table>
		</div><br />
			<button type="submit">등록</button>
			<button type="reset" >취소</button>
	</form>
	</div>
</div>
</div>