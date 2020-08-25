package com.tong.cms.service;

import com.tong.cms.bean.User;


/**
 * 说明: 用户服务
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月27日 下午1:12:48
 */
public interface UserService {

	User get(int id);

	User get(String username);

	int count(User user);
}