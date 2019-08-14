package com.znsd.ssm.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.ssm.entities.Clazz;
import com.znsd.ssm.entities.User;
import com.znsd.ssm.service.ClazzService;
import com.znsd.ssm.service.UserService;

@Controller
public class Demo {
	@Autowired
	private UserService userServiceIm;
	@Autowired
	private ClazzService clazzServiceIm;
	
	
	@RequestMapping("/login")
	public String login(HttpSession session) {
		session.setAttribute("http", "session");

		return "login";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login2(User user) {
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();

		// 测试当前用户是否已经被认证，即是否已经登录。
		if (!currentUser.isAuthenticated()) {
			// 把用户名和密码封装为UsernamePasswordToken对象
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUser_name(), user.getUser_mailsta());
			// 记住密码
			token.setRememberMe(true);
			try {
				// 执行登录
				currentUser.login(token); // 实际上调用Realm中的doGetAuthenticationInfo方法
				return "redirect:file";
			} catch (AuthenticationException e) { // 其他异常，是其他异常的父类
				e.printStackTrace();
			}
		}
		return "login";
	}
	
	
	
	@RequestMapping("/file")
	public String sta(Map<String,Object> map) {
		List<User> list=userServiceIm.file();
		
		map.put("list", list);
		
		return "find";
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String add(Map<String,Object> map) {
		
		init(map);
		
		return "add";
	}	
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String add2( User user,Map<String,Object> map) {
		
		userServiceIm.insert(user);
		
		return "redirect:file";
	}	
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		
		userServiceIm.delete(id);
		
		return "redirect:/file";
	}	
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
	public String update(@PathVariable("id") Integer id,Map<String, Object> map) {
		
		User user=userServiceIm.file1(id);
		
		init(map);
		map.put("user", user);
		
		return "update";
	}	
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public String update1(User user) {
		
		System.out.println(user);
		userServiceIm.update(user);
		
		return "redirect:/file";
	}	
	
	@ResponseBody
	@RequestMapping("/file2")
	public List<Clazz> sta2() {
		List<Clazz> list=clazzServiceIm.file();
		return list;
	}	
	
	private Map init(Map<String, Object> map) {
		Map<String, Object> sex = new HashMap<String, Object>();
		sex.put("男", "男");
		sex.put("女", "女");
		map.put("sex", sex);
		User user = new User();
		user.setUser_sex("女");;
		map.put("user", user);
		
		 List<Clazz> list = clazzServiceIm.file(); 
		 map.put("list", list);
		return map;

	}	
	
}
