package contacts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ContactController {
	private ContactRepository contackRepo;

	@Autowired
	public ContactController(ContactRepository contackRepo) {
		this.contackRepo = contackRepo;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String home(Map<String, Object> model) {
		List<Contact> contacts = contackRepo.findAll();
		model.put("contacts", contacts);
		return "home";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Contact contact) {
		contackRepo.save(contact);
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping(value = "/handle42/{imageId}")
	public byte[] handle42(@PathVariable("imageId") String imageId) throws IOException {
		System.out.println("load image of " + imageId);
		Resource res = new ClassPathResource("/image.jpg");
		byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
		return fileData;
	}

}
