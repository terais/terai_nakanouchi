package chat.spring;

import javax.servlet.http.HttpSession;

public class Common {
	
	public void setIdSession(HttpSession session, int id) {
		session.setAttribute("id", id);
	}
	
	public boolean isCheckId(HttpSession session) {
		if(session.getAttribute("id") != null)return true;
		return false;
	}

}
