/**
 * 
 */
package com.tong.cms.dao;

import java.util.List;

import com.tong.cms.bean.Category;
import org.apache.ibatis.annotations.Param;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月27日 下午2:56:07
 */
public interface CategoryMapper {

	void insert(Category category);

	void deleteById(int id);

	Category selectById(int id);
	
	List<Category> selectAll();
	
	List<Category> selectByChannel(@Param("channel_id") int channelId);
	
	
}
