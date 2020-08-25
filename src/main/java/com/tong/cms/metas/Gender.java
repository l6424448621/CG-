/**
 * 
 */
package com.tong.cms.metas;

/**
 * 说明:性别
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月16日 上午8:05:23
 */
public enum Gender {

	FEMALE("女士"),
	MALE("先生");
	
	private String description;
	
	Gender(String description){
		this.description = description;
	}
	
	public String getName(){
		return name();
	}
	
	public String getDescription() {
		return description;
	}

	public int getOrdinal(){
		return this.ordinal();
	}
	
}
