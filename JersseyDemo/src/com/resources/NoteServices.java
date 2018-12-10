package com.resources;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.noteDao;
import com.model.Note;
 
@Path("/note")
public class NoteServices {
 
	private noteDao ndao=new noteDao();
	
	@GET
	@Path("/getNote")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getNotes() throws SQLException {
		
			return ndao.getNotes();
	}
	
	@POST
	@Path("/updateStatus")
	@Produces(MediaType.APPLICATION_JSON)
	public Note updateStatus(Note note) throws SQLException {
		System.out.println(note.toString());
		int result=0;
		result=ndao.updateStatus(note);
		if(result==1) {
			
			return note;
		}
		return note;
	}
	
	@POST
	@Path("/addNote")
	@Produces(MediaType.APPLICATION_JSON)
	public Note addNote(Note note) throws SQLException {
		boolean result=false;
		result=ndao.addNote(note);
		if(result) {
			return note;
		}
		return note;
	}
	
	@POST
	@Path("/updateNote")
	@Produces(MediaType.APPLICATION_JSON)
	public Note updateNote(Note note) throws SQLException {
		int result=0;
		result=ndao.updateNote(note);
		if(result==1) {
			
			return note;
		}
		return note;
	}
	
	@DELETE
	@Path("/delNote/{noteid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delNote(@PathParam("noteid") int noteid) throws SQLException {
		
		ndao.delNote(noteid);
		
	}
	
	
}
	
