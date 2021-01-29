package co.hj.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.hj.board.common.DAO;
import co.hj.board.vo.BoardVO;

public class BoardDAO extends DAO {

	private PreparedStatement psmt;
	private ResultSet rs;

//전체조회
	public ArrayList<BoardVO> selectList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		String sql = "SELECT * FROM board";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setbId(rs.getInt("bId"));
				vo.setbName(rs.getString("bName"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));
				vo.setbGroup(rs.getInt("bGroup"));
				vo.setbStep(rs.getInt("bStep"));
				vo.setbIndent(rs.getInt("bIndent"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

//한건조회
	public BoardVO select(BoardVO vo) {
		String sql = "SELECT * FROM board WHERE bid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setbId(rs.getInt("bId"));
				vo.setbName(rs.getString("bName"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));
				vo.setbGroup(rs.getInt("bGroup"));
				vo.setbStep(rs.getInt("bStep"));
				vo.setbIndent(rs.getInt("bIndent"));
				hitCount(vo.getbId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

//추가
	public int insert(BoardVO vo) {
		String sql = "INSERT INTO board (bid,bname,btitle,bcontent,bdate) VALUES (bidseq.nextval,?,?,?,?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbName());
			psmt.setString(2, vo.getbTitle());
			psmt.setString(3, vo.getbContent());
			psmt.setDate(4, vo.getbDate());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 등록되었습니다. ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

//수정	
	public int update(BoardVO vo) {
		String sql = "UPDATE board SET bContent = ? WHERE bId=?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbContent());
			psmt.setInt(2, vo.getbId());
			n = psmt.executeUpdate();
			System.out.println(n + "건 수정되었습니다. ");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return n;
	}

//삭제	
	public int delete(BoardVO vo) {
		String sql = "DELETE FROM board WHERE bid=?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			n = psmt.executeUpdate();
			System.out.println(n + " 건이 삭제되었습니다. ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	private void close() { // close 객체
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close(); //순서중요!!
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//조회수	
	private void hitCount(int hit) { // 조회수 증가 메소드
		String sql = "update board set bhit = bhit + 1 where bid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hit);
			int n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

}
