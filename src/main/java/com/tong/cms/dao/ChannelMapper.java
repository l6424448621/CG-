/**
 * 
 */
package com.tong.cms.dao;

import java.util.List;

import com.tong.cms.bean.Channel;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月27日 下午2:56:07
 */
public interface ChannelMapper {

	void insert(Channel channel);

	void deleteById(int id);

	Channel selectById(int id);
	
	List<Channel> selectAll();
	
}
