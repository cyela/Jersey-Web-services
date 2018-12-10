package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.model.Note;
public class noteDao {

	private Connection con;
	public List<Note> getNotes() throws SQLException{
		List<Note> noteList=null;
		try {
			con=DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement("select * from note");
			ResultSet rs=stmt.executeQuery();
			noteList=new ArrayList<>();
			Note note;
			while(rs.next()) {
				note=new Note();
				note.setId(rs.getInt(1));
				note.setTitle(rs.getString(2));
				note.setDescription(rs.getString(3));
				note.setAddedOn(rs.getString(4));
				note.setStatus(rs.getString(5));
				noteList.add(note);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		} 
		return noteList;
	}
	
	public Note getNoteById(int noteId) throws SQLException {
		Note note=null;
		try {
			con=DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement("select * from note where id="+noteId);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				note=new Note();
				note.setId(rs.getInt(1));
				note.setTitle(rs.getString(2));
				note.setDescription(rs.getString(3));
				note.setAddedOn(rs.getString(4));
				note.setStatus(rs.getString(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		} 
		return note;
	}
	
	public boolean addNote(Note note) throws SQLException {
		boolean result=false;
		try {
			con=DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement(
					"insert into note values(note_sequence.nextval,?,?,?,?)");
			
			stmt.setString(1,note.getTitle());  
			stmt.setString(2,note.getDescription());
			stmt.setString(3, note.getAddedOn());
			stmt.setString(4, note.getStatus());
			result= stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		} 
		return result;
	}
	
	public int updateNote(Note note) throws SQLException {
		System.out.println(note.toString());
		int result=0;
		try {
			con=DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement(
					"update note set title=?,description=?,addedon=?,status=? where id=?");
			
			stmt.setString(1,note.getTitle());  
			stmt.setString(2,note.getDescription());
			stmt.setString(3, note.getAddedOn());
			stmt.setString(4, note.getStatus());
			stmt.setInt(5, note.getId());
			System.out.println(stmt.toString());
			result= stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		} 
		return result;
	}
	
	public int updateStatus(Note note) throws SQLException {
		int result=0;
		try {
			con=DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement(
					"update note set status=? where id=?");
			
			stmt.setString(1,note.getStatus());  
			stmt.setInt(2, note.getId());
			result= stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		} 
		return result;
	}
	
	public int delNote(int noteid) throws SQLException {
		int result=0;
		try {
			con=DBUtil.getConnection();
			PreparedStatement stmt=con.prepareStatement(
					"delete from note where id=?");
			stmt.setInt(1, noteid);
			result= stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		} 
		return result;
	}
}
