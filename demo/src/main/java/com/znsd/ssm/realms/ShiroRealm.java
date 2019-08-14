package com.znsd.ssm.realms;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.znsd.ssm.entities.User;
import com.znsd.ssm.service.UserService;


public class ShiroRealm extends AuthorizingRealm  {
	@Autowired
	private UserService userServiceIm;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //①、把AuthenticationToken转换为UsernamePasswordToken。
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//②、从UsernamePasswordToken中获取username

		String username = upToken.getUsername();
		//③、调用数据库的方法，从数据库中查询username对应的记录。
		User user = userServiceIm.file5(username);
		//④、若用户不存在，则可以跑出UnknownAccountException异常。
		if(user == null) {
			System.out.println("用户不存在.");
		}
		//⑤、根据用户信息的情况，决定是否需要抛出其它AuthenticationException异常。
		ByteSource salt = ByteSource.Util.bytes("www.znsd.com");
		//⑥、根据用户的情况，来构建AuthenticationInfo对象并返回。
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUser_mailsta(),salt ,this.getName());
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("用于授权");
		// 授权方法的步骤：
		// 1、从PrincipalCollection中来获取登录用户的信息。
		User user = (User) principals.getPrimaryPrincipal();
		// 2、利用登录用户的信息来验证当前用户的角色或者权限。
		Set<String> roles = new HashSet<>();
		roles.add("user");
		if ("admin".equals(user.getUser_name())) {
		    roles.add("admin");
		}else if ("sta".equals(user.getUser_name())) {
			roles.add("sta");
		}
		// 3、创建SimpleAuthorizationInfo，并设置其roles属性。
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		// 4、返回SimpleAuthorizationInfo对象
		return null;
	}
	


}
