package com.tong.cms.service;

import com.tong.cms.bean.User;
import com.tong.cms.metas.Gender;
import com.tong.cms.util.Codings;


/**
 * 说明:用户认证接口
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午3:38:12
 */
public interface PassportService extends UserService{

	/**密码加密盐值**/
	String SALT = "la3h5G8l!9N0vo";

	
	/**
	 * 功能说明：用户注册<br>
	 * @param username
	 * @param password
	 * @param nickname
	 * @param gender
	 * @return
	 * User
	 */
	User reg(String username, String password, String nickname, Gender gender);

	
	/**
	 * 功能说明：<br>
	 * @param username
	 * @param password
	 * @return
	 * User
	 */
	User login(String username, String password);
	
	/**
	 * 功能说明：加密<br>
	 * @param username
	 * @param password
	 * @return
	 * String
	 */
	static String encrypt(String username, String password){
		password = Codings.MD5Encoding(password + PassportService.SALT + username);
		return password;
	}
}