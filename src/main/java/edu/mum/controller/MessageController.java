/**
 * 
 */
package edu.mum.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.amqp.MessageService;
import edu.mum.domain.Message;
import edu.mum.domain.Messages;
import edu.mum.domain.User;
import edu.mum.service.UserService;

/**
 * @author Diana Yamaletdinova May 22, 2017
 */
@Controller
public class MessageController {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageService msgService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {

		List<User> users = new ArrayList<>();
		users = userService.findAll();
		model.addAttribute("users", users);
		
		return "welcome";
	}

	@RequestMapping(value = "/sendMsgMq", method = RequestMethod.POST)
	public String processSendMessageFormMq(@Valid @ModelAttribute("newMessage") Messages msgToBeAdded,
			BindingResult result, Model model, RedirectAttributes ra) {

		if (result.hasErrors()) {
			System.out.println("error msg");
			return "welcome";
		}
		
		Message message = new Message();
		message.setMessage(msgToBeAdded.getMessage());
		
		String sender = System.getProperties().getProperty("sender");
		String receiver  = System.getProperties().getProperty("receiver");
		
		message.setSender(sender);
		message.setReceiver(receiver);
		msgService.publish(message);

		ra.addFlashAttribute("msgToBeAdded", message);
		return "redirect:/welcome";
	}
}
