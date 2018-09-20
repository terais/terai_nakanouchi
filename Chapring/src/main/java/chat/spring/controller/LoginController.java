package chat.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import chat.spring.entity.Message;
import chat.spring.form.LoginForm;
import chat.spring.form.MessageForm;
import chat.spring.service.LoginService;
import chat.spring.service.MessageService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/", method = { RequestMethod.GET })
    public String messages(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @RequestMapping(value = "/login", method = { RequestMethod.POST })
    public String loginPost(Model model, @Valid LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {
    	//バリデーションエラーがあればログイン画面に遷移
    	if (bindingResult.hasErrors()) {
            return "login";
        }
        boolean checkUser = loginService.checkUser(loginForm);
        
        //IDとPASSでHITがあればmessage画面に遷移
        if(checkUser) {
        model.addAttribute("loginForm", loginForm);
        model.addAttribute("messageForm", new MessageForm());
        List<Message> messages = messageService.getRecentMessages(100);
        model.addAttribute("messages", messages);

        return "messages";
        }
        return "login";
    }
}