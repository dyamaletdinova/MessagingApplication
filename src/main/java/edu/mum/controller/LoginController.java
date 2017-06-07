package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.domain.User;
import edu.mum.domain.UserCredentials;
import edu.mum.service.UserCredentialsService;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	UserCredentialsService credentialsService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
 		return "login";
	}
 
	@RequestMapping(value="/postLogin", method = RequestMethod.POST)
	public String PostLogin(UserCredentials credentials, Model model, RedirectAttributes ra) {
		
		User user = credentialsService.findByUserName(credentials.getUserName());
		
		if (user == null){
			return  "login";
		}
		model.addAttribute("user", user);
 		return "redirect:/welcome";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
 		return "redirect:/welcome";
 	}
}
