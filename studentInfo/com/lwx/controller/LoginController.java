package com.lwx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lwx.pojo.Student;
import com.lwx.pojo.User;
import com.lwx.service.LoginService;

@Controller
@RequestMapping("/login" )
public class LoginController {

	@Autowired
	private LoginService loginService;

	
	@RequestMapping("/1")
	public String Login(Model model,User user,HttpServletRequest request,HttpServletResponse response) {	
		if(user.getName().length()== 10) {
			boolean flag = loginService.studentlogin(user.getName(), user.getPassword());
			//ModelAndView modelAndView = new ModelAndView();
			if (flag) {
				HttpSession session = request.getSession();
	            session.setAttribute("name",user.getName());
	            session.setMaxInactiveInterval(6000);
				//modelAndView.setViewName("main1");
				System.out.println("µÇÂ¼³É¹¦");
				return "main1";
			} else {
				//modelAndView.setViewName("login");
				System.out.println("µÇÂ¼Ê§°Ü");
				model.addAttribute("msg","µÇÂ¼Ê§°Ü£¡");
				return "login";
			}
			//return modelAndView;
		}
		else  {
			boolean flag = loginService.login(user.getName(), user.getPassword());
			//ModelAndView modelAndView = new ModelAndView();
			if (flag) {
				HttpSession session = request.getSession();
	            session.setAttribute("name",user.getName());
	            session.setMaxInactiveInterval(6000);
				//modelAndView.setViewName("main");
				System.out.println("µÇÂ¼³É¹¦");
				return "main";
			} else {
				//modelAndView.setViewName("login");
				System.out.println("µÇÂ¼Ê§°Ü");
				model.addAttribute("msg","µÇÂ¼Ê§°Ü£¡");
				return "login";
			}
			//return modelAndView;
		}
	}
	
	@RequestMapping("/userlogin")	
	public ModelAndView UserLogin(User user ,HttpServletRequest request,HttpServletResponse response) {
		
		boolean flag = loginService.login(user.getName(), user.getPassword());
		ModelAndView modelAndView = new ModelAndView();
		if (flag) {
			HttpSession session = request.getSession();
            session.setAttribute("name",user.getName());
            session.setMaxInactiveInterval(6000);
			modelAndView.setViewName("main");
			System.out.println("µÇÂ¼³É¹¦");
		} else {
			modelAndView.setViewName("login");
			System.out.println("µÇÂ¼Ê§°Ü");
		}
		return modelAndView;
	}

	@RequestMapping("/userexit")
	public String UserExit(User user ,HttpServletRequest request,HttpServletResponse response) {
			
		HttpSession session = request.getSession();
        session.setAttribute("name",user.getName());
        if(user != null){
            session.removeAttribute("userName");
            request.setAttribute("info",null);
        }
		
		return "logoff";
	}
	
	@RequestMapping("/updatepad")
	public String updatePassword(Model model,HttpServletRequest request) {
     
		HttpSession session = request.getSession();
		String loginedUser = (String)session.getAttribute("name");
		System.out.println(loginedUser);
        String oldPwd = request.getParameter("oldpass");
        System.out.println(oldPwd);
        String newPwd = request.getParameter("newpass");
        System.out.println(newPwd);
        
        
        Student student = loginService.queryStudentById(loginedUser);
        System.out.println(student);
        if(student.getStudentPad().equals(oldPwd)) {
        	int r = loginService.updateStudentPad(student.getStudentId(), newPwd);
            if(r > 0) {
            	model.addAttribute("msg","¸üÐÂ³É¹¦£¡");
            	System.out.println("¸üÐÂ³É¹¦£¡");
            }else {
            	model.addAttribute("msg","¸üÐÂÊ§°Ü£¡");
            	System.out.println("¸üÐÂÊ§°Ü2£¡");
            }
        }else {
        	model.addAttribute("msg","ÃÜÂë´íÎó£¡");
        	System.out.println("¸üÐÂÊ§°Ü£¡");
        }

        return "updatepad";
    }
}
