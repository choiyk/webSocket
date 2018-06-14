package com.kyung.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyung.dto.Meeting;
import com.kyung.repository.MeetingRepository;

@Controller
public class ListController {

	@Autowired MeetingRepository meetingRepository;

	@RequestMapping("list")
	public String list(Model model){
		List<Meeting> meetings = meetingRepository.findAll();
		model.addAttribute("meetings", meetings);
		return "list";
	}

	/*@RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(@RequestParam("id") int id, Model model) {
		Meeting meeting = meetingRepository.findOneById(id);
        model.addAttribute("meeting", meeting);
        System.out.println("id: "+meeting.getId());
        return "edit";
    }*/

	/*@RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(Meeting meeting, Model model) {
		Meeting meeting = meetingRepository.findOneById(id);
        model.addAttribute("meeting", meeting);
        System.out.println("id: "+meeting.getId());
        return "edit";
    }*/

	/*@Transactional
	@RequestMapping(value="edit/{id}/{name}")
	public String editName(@PathVariable("id") int id, @PathVariable("name") String name){
		meetingRepository.updateName(id, name);
		return "list";
	}*/

	/*@Transactional
	@RequestMapping(value="edit/{id}/{name}")
	@SendTo("/topic/greetings")
	public Greeting editName(@PathVariable("id") int id, @PathVariable("name") String name){
		meetingRepository.updateName(id, name);
		return new Greeting("수정되었습니다.");
	}
*/
   /* @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(HttpServletRequest request, Model model) {
    	System.out.println("id: "+meeting.getId());
    	System.out.println("name: "+meeting.getName());
    	System.out.println("Explain: "+meeting.getExplain());
    	System.out.println("date: "+meeting.getDate());
        meetingRepository.save(meeting);
    	String name = (String) request.getAttribute("name");
        model.addAttribute("message", "저장했습니다.");
        return "edit";
    }*/

	/*@GetMapping("edit")
	public String editForm(Model model){
		model.addAttribute("meeting", new Meeting());
		return "edit";
	}

	@PostMapping("edit")
	public String editSubmit(@ModelAttribute Meeting meeting){
		return "list";
	}*/

	@RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(@RequestParam("id") int id, Model model) {
		Meeting meeting = meetingRepository.findOneById(id);
        model.addAttribute("meeting", meeting);
        System.out.println("id: "+meeting.getId());
        return "edit";
    }

	@Transactional
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public String edit(Meeting meeting, Model model){
		meetingRepository.save(meeting);
		return "redirect:list";
	}


}
