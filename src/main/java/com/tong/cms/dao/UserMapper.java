/**
 * 
 */
package com.tong.cms.dao;

import com.tong.cms.bean.User;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午1:37:59
 */
public interface UserMapper {

	void insert(User user);
	
	void deleteById(int id);

	User selectById(int id);

	User selectByUsername(String username);

	int count(User user);
	
}
