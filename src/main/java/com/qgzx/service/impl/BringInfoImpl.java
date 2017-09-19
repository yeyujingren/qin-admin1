package com.qgzx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgzx.dao.BringInfoDao;
import com.qgzx.entity.BringInfo;
import com.qgzx.service.BringInfoService;

@Service
public class BringInfoImpl implements BringInfoService {

	@Resource
	private BringInfoDao bringInfoDao;
	@Override
	public void queryById(int id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean addBringInfo(BringInfo bringInfo) throws Exception {
		// TODO Auto-generated method stub
		    int count = bringInfoDao.add(bringInfo);
		    
		    System.out.println(count);
		     if(count!=1) {
		    	 return false;
		     }
         return true;
	}

	@Override
	public void deleteStudent(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean updateBringInfo(BringInfo bringInfo) throws Exception {
		// TODO Auto-generated method stub

      int count = bringInfoDao.update(bringInfo);
        if(count!=1) {
        	return false;
        }   
        return true;
	}

	@Override
	public List<BringInfo> getBringInfo(int startPos, int pageSize) {
		return bringInfoDao.getBringInfo(startPos, pageSize);
	}

	@Override
	public Boolean deleteBringInfo(int id) {
		// TODO Auto-generated method stub
		
		int count = bringInfoDao.deleteById(id);
		if(1!=count) {
			return false;
		}
		return true;
	}

	@Override
	public BringInfo getBringInfoById(int id) {
		// TODO Auto-generated method stub
		return bringInfoDao.queryById(id);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return bringInfoDao.getCount();
	}

	@Override
	public List<BringInfo> getBringInfoList(int startPos, int pageSize) {
		// TODO Auto-generated method stub
		return bringInfoDao.getBringInfoList(startPos,pageSize);
	}

}
