package com.stackroute.keepnote.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.stackroute.keepnote.model.Note;
import com.stackroute.keepnote.repository.NoteRepository;

/*Annotate the class with @Controller annotation. @Controller annotation is used to mark 
 * any POJO class as a controller so that Spring can recognize this class as a Controller
 * */
@Controller
public class NoteController {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	Note noteObj=(Note)ctx.getBean("note");
	NoteRepository noteRepObj=(NoteRepository)ctx.getBean("noteRepository");

	@RequestMapping(value="/")
	public String getNotes(ModelMap map)
	{
		List<Note> list=(List) noteRepObj.getAllNotes();
 		map.put("noteList",list);
		return "index";
	}
	@RequestMapping(value="/saveNote",method=RequestMethod.POST)
	public String addNewNote(@Validated @ModelAttribute("Note")Note note,ModelMap map)
	{

		LocalDateTime dt=LocalDateTime.now();
		note.setCreatedAt(dt);
		noteRepObj.addNote(note);
		List list=(List) noteRepObj.getAllNotes();
		map.put("noteList",list);
		return "index";	
	}
	
	
		@GetMapping
		public String deleteNote(@RequestParam("noteId") String noteId)
		{
			int id =Integer.parseInt(noteId);
			noteRepObj.deleteNote(id);
			return "redirect:/";
		}	
}