package com.qgzx.service;

import java.util.List;

import com.qgzx.entity.BringInfo;


public interface BringInfoService {
	/**
	 * @author zhangzhengan 
	 * @param id 
	 * @since JDK 1.7
	 */
	public void queryById(int id) throws Exception;
	
	/**
	 * 
	 * @author zhangzhengan 
	 * @param bringInfo
	 * @return 
	 * @throws Exception 
	 * @since JDK 1.7
	 */
	public Boolean addBringInfo(BringInfo bringInfo) throws Exception;
	
	
	
	/**
	 * 
	 * @author zhangzhengan 
	 * @param id 
	 * @since JDK 1.7
	 */
	public void deleteStudent(Integer id) throws Exception;
	
	/**
	 * 更新学生信息
	 * 
	 * @author zhangzhengan 
	 * @param bringInfo 
	 * @return 
	 * @since JDK 1.7
	 */
	public Boolean updateBringInfo(BringInfo bringInfo) throws Exception;

	public List<BringInfo> getBringInfo(int startPos,int pageSize);

	public Boolean deleteBringInfo(int id);

	public BringInfo getBringInfoById(int id);

	public int getCount();

	public List<BringInfo> getBringInfoList(int startPos, int pageSize);


}
