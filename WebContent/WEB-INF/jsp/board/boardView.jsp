<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style type="text/css">
	tr.bId:hover {background-color : lightyellow;}
	body{background-image:url("/20210129/image/front.jpg");}
</style>

<script type="text/javascript"> 
	function deleteAlert(){
		var yn = confirm("정말 삭제할까요?");
		if(yn) {
			frm.action="boardDelete.do";
			frm.submit();
		}else{
			return false;
		}
		
	}
</script>
<jsp:include page = "../main/menu.jsp" />
<div class="w3-content" style="max-width:2000px; margin-top:46px"  align="center">
	<span style="color: white;">
	<div><h1>게시글 상세보기</h1></div>
	</span>
		<form id="frm" name="frm" method="post">
				<div>
					<table border="1" bgcolor="white">
						<tr>
							<th width="150">글번호</th>
							<td align="center" width="50">
							<input type="text"id="bId" name="bId" value="${vo.bId }"></td>
							<th width="100">작성자</th>
							<td align="center" width="50">${vo.bName }</td>
							<th width="100">작성일자</th>
							<td align="center" width="100">${vo.bDate }</td>
							<th width="100">조회수</th>
							<td align="center" width="50">${vo.bHit }</td>
						</tr>
						<tr>
							<th width="60">제 목</th>
							<td colspan="7">${vo.bTitle }</td>
						</tr>
						<tr>
							<th width="50">내 용</th>
							<td colspan="7" height="300">${vo.bContent }</td>
						</tr>
					</table>
				</div>
				<br />
				<div>
					<button type="button" onclick="location.href='boardList.do'">목록보기</button>
					<button type="button" onclick="deleteAlert()">삭 제</button>
					<button type="button" onclick="location.href='boardEditForm.do?bId='+${vo.bId }">수 정</button>
				</div>
		</form>
	</div>