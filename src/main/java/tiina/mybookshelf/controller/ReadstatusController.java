package tiina.mybookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tiina.mybookshelf.domain.Readstatus;
import tiina.mybookshelf.domain.ReadstatusRepository;

@Controller
public class ReadstatusController {
	@Autowired
	private ReadstatusRepository readstatusRepository;

	// Show all read statuses
	@RequestMapping(value = "/readstatus")
	public String readstatus(Model model) {
		model.addAttribute("readstatuses", readstatusRepository.findAll());
		return "readstatus";
	}

	// Add a status
	@RequestMapping(value = "/addstat")
	public String addCategory(Model model) {
		model.addAttribute("readstatus", new Readstatus());
		return "addstatus";
	}

	// Save new category to the read status list
	@RequestMapping(value = "/statussave", method = RequestMethod.POST)
	public String save(Readstatus readstatus) {
		readstatusRepository.save(readstatus);
		return "redirect:statuslist";
	}

}
