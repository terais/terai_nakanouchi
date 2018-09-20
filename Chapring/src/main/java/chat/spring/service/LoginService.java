package chat.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chat.spring.entity.User;
import chat.spring.form.LoginForm;
import chat.spring.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;
    //IDとPASSでユーザーが存在するかチェック
    public Boolean checkUser(LoginForm loginForm) {
    	User user = repository.findByIdEqualsAndPassEquals(loginForm.getId(),loginForm.getPass());
    	if(user != null)return true;
    	return false;
    }
}