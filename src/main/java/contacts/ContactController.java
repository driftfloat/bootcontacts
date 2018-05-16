package contacts;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ContactController {
	private ContactRepository contackRepo;
	
	@Autowired
	public ContactController(ContactRepository contackRepo) {
		this.contackRepo = contackRepo ;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Map<String, Object> model) {
		List<Contact> contacts = contackRepo.findAll();
		model.put("contacts", contacts);
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(Contact contact) {
		contackRepo.save(contact);
		return "redirect:/";
	}
	
}




























