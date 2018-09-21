package chat.spring.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chat.spring.Common;
import chat.spring.entity.Message;
import chat.spring.form.MessageForm;
import chat.spring.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	HttpSession session;
    @Autowired
    private MessageService service;

    @RequestMapping(value = "/messages", method = { RequestMethod.GET })
    public String messages(Model model) {
    	Common common = new Common();
    	if(!common.isCheckId(session))return "redirect:http://chapring.tk/";
    	
        model.addAttribute("messageForm", new MessageForm());
        List<Message> messages = service.getRecentMessages(100);
        model.addAttribute("messages", messages);
        return "messages";
    }

    @RequestMapping(value = "/messages", method = { RequestMethod.POST })
    public String messagesPost(Model model, @Valid MessageForm messageForm, BindingResult bindingResult, HttpServletRequest request) {
    	
    	if (bindingResult.hasErrors()) {
    	       List<Message> messages = service.getRecentMessages(100);
    	       model.addAttribute("messages", messages);
    	       return "messages";
        }
        service.save(new Message(messageForm.getName(), messageForm.getText(), request.getRemoteAddr()));
        model.addAttribute("messageForm", new MessageForm());
        List<Message> messages = service.getRecentMessages(100);
        model.addAttribute("messages", messages);
        return "messages";
    }

}