/**
 * 
 */
package com.tong.cms.dao;

import java.util.List;

import com.tong.cms.bean.Slide;
import org.apache.ibatis.annotations.Param;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月27日 下午2:56:07
 */
public interface SlideMapper {

	public void insert(Slide slide);
	
	public void updateByKey(Slide slide);

	public void deleteById(int id);

	public Slide selectById(int id);
	
	public List<Slide> selectTop(@Param("size") int size);

	public List<Slide> selectAll();
	
}
