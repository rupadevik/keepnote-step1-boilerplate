package com.stackroute.keepnote.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.stackroute.keepnote.model.Note;

/*
 * This class contains the code for data storage interactions and methods 
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */
@Repository
public class NoteRepository {

	
	List<Note> noteList=null;

	public NoteRepository() {

		noteList =new ArrayList<Note>();
	}

	public List<Note> getList() {
		return noteList;
	}

	public void setList(List<Note> list) {
		noteList=list;
	}

	/*
	 * This method should Note object as argument and add the new note object into
	 * list
	 */

	public void addNote(Note note) {
		noteList.add(note);

	}

	/* This method should deleted a specified note from the list */

	public boolean deleteNote(int noteId) {
		Note note = new Note();
		Iterator<Note> itr = noteList.iterator();
		while(itr.hasNext())
		{
			note=(Note)itr.next();
			if(note.getNoteId()==noteId)
			{
				boolean b= noteList.remove(note);
				return b;
			}
		}
		
		return false;
		
		
	}

	/* This method should return the list of notes */

	public List<Note> getAllNotes() {
		return noteList;
	}

	/*
	 * This method should check if the matching note id present in the list or not.
	 * Return true if note id exists in the list or return false if note id does not
	 * exists in the list
	 */

	public boolean exists(int noteId) {
		Note note = new Note();
		boolean flag=false;
		Iterator<Note> itr = noteList.iterator();
		while(itr.hasNext())
		{
			note=(Note)itr.next();
			if(note.getNoteId()==noteId)
			{
				flag=true;
			}
		}
		
		return flag;
	}
}