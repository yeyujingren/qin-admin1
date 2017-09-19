package com.qgzx.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qgzx.dto.BackPage;
import com.qgzx.dto.BringInfoPage;
import com.qgzx.dto.Result;
import com.qgzx.entity.BringInfo;
import com.qgzx.entity.User;
import com.qgzx.service.BringInfoService;
import com.qgzx.util.Page;

@Controller
public class BringInfoController {
	@Resource
	private BringInfoService bringInfoService;

	
	
	@ResponseBody
	@RequestMapping(value = "/insertBringInfo", method = RequestMethod.POST)
	public Result<String> insertBringInfo(@RequestBody BringInfo bringInfo, HttpSession session) {
		User user = (User) session.getAttribute("user");

		if (user == null) {
			return new Result<String>(false, "您还没有登陆", null);
		}
		System.out.println(bringInfo.toString());

		if (bringInfo == null) {
			return new Result<String>(false, "参数有误", null);
		}
       System.out.println(bringInfo.toString());
		// 单位地址长度检验
		if (bringInfo.getLocation().length() > 50 ||bringInfo.getLocation().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 职位参数长度检验
		if (bringInfo.getName().length() > 20 ||bringInfo.getName().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 需求描述参数长度检验
		if (bringInfo.getNeed().length() > 200 ||bringInfo.getNeed().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 薪资参数长度检验
		if (bringInfo.getPay().length() > 8 || bringInfo.getPay().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 招聘人数参数长度检验
		if (bringInfo.getPeople().length() > 8) {
			return new Result<String>(false, "参数有误", null);
		}

		// 性别参数长度检验
		if (bringInfo.getSex().length() > 2||bringInfo.getSex().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 校区参数长度检验
		if (bringInfo.getPlace().length() > 10 ||bringInfo.getPlace().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 单位名称参数长度检验
		if (bringInfo.getTitle().length() > 30 ||bringInfo.getTitle().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 单位类型参数长度检验
		if (bringInfo.getType().length() > 10 ||bringInfo.getType().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 工作地点参数长度检验
		if (bringInfo.getWorkplace().length() > 50 ||bringInfo.getWorkplace().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}


		Boolean bool = false;

		try {
			bool = bringInfoService.addBringInfo(bringInfo);
			System.out.println(bool);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new Result<String>(false, "未知错误!", null);
		}

		if (bool == false) {

			return new Result<String>(false, "添加失败", null);
		}

		return new Result<String>(true, "添加成功", null);
	}

	@ResponseBody
	@RequestMapping(value = "/getBringInfo", method = RequestMethod.POST)
	public Result<List<BringInfo>> getBringInfo(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return new Result<List<BringInfo>>(false, "您还没有登陆", null);
		}

		List<BringInfo> list = bringInfoService.getBringInfo(0, 100);

		
		return new Result<List<BringInfo>>(true, "success", list);
	}

	@ResponseBody
	@RequestMapping(value = "/bringInfoList", method = RequestMethod.POST)
	public Result<BringInfoPage> bringInfoList() {
		BringInfoPage bringInfoPage = new BringInfoPage();
		BackPage backPage = new BackPage();
		Page page = new Page();

		int count = bringInfoService.getCount();
		page.setTotalCount(count);
		backPage.setPageNow(page.getPageNow());
		backPage.setTotalPageCount(page.getTotalPageCount());
		List<BringInfo> list = bringInfoService.getBringInfoList(0, page.getPageSize());

		bringInfoPage.setBackPage(backPage);
		bringInfoPage.setList(list);
     
		return new Result<BringInfoPage>(true, "success", bringInfoPage);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteBringInfo", method = RequestMethod.POST)
	public Result<String> deleteBringInfo(@RequestBody BringInfo bringInfo, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null) {
			return new Result<String>(false, "您还没有登陆", null);
		}

		if (bringInfo.getId() == 0) {
			return new Result<String>(false, "参数有误", null);
		}

		Boolean bool = false;

		bool = bringInfoService.deleteBringInfo(bringInfo.getId());

		if (bool == false) {
			return new Result<String>(false, "删除失败", null);
		}

		return new Result<String>(true, "删除成功", null);
	}

	@ResponseBody
	@RequestMapping(value = "/updateBringInfo", method = RequestMethod.POST)
	public Result<String> updateBringInfo(@RequestBody BringInfo bringInfo, HttpSession session) {

		User user = (User) session.getAttribute("user");

		if (user == null) {
			return new Result<String>(false, "您还没有登陆", null);
		}
		System.out.println(bringInfo.toString());

		if (bringInfo == null) {
			return new Result<String>(false, "参数有误", null);
		}

		// 单位地址长度检验
		if (bringInfo.getLocation().length() > 50 ||bringInfo.getLocation().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 职位参数长度检验
		if (bringInfo.getName().length() > 20 ||bringInfo.getName().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 需求描述参数长度检验
		if (bringInfo.getNeed().length() > 200 ||bringInfo.getNeed().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 薪资参数长度检验
		if (bringInfo.getPay().length() > 8 || bringInfo.getPay().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 招聘人数参数长度检验
		if (bringInfo.getPeople().length() > 8) {
			return new Result<String>(false, "参数有误", null);
		}

		// 性别参数长度检验
		if (bringInfo.getSex().length() > 2||bringInfo.getSex().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 校区参数长度检验
		if (bringInfo.getPlace().length() > 10 ||bringInfo.getPlace().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 单位名称参数长度检验
		if (bringInfo.getTitle().length() > 30 ||bringInfo.getTitle().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 单位类型参数长度检验
		if (bringInfo.getType().length() > 10 ||bringInfo.getType().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}

		// 工作地点参数长度检验
		if (bringInfo.getWorkplace().length() > 50 ||bringInfo.getWorkplace().length()==0) {
			return new Result<String>(false, "参数有误", null);
		}


		Boolean bool = false;

		try {
			bool = bringInfoService.updateBringInfo(bringInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new Result<String>(false, "未知错误!", null);
		}
		;

		if (bool == false) {
			return new Result<String>(false, "更新失败", null);
		}

		return new Result<String>(true, "更新成功", null);
	}

	@ResponseBody
	@RequestMapping(value = "/getBringInfoById", method = RequestMethod.POST)
	public Result<List<BringInfo>> getBringInfoById(@RequestBody BringInfo bringInfo) {

		if (bringInfo.getId() <= 0) {
			return new Result<List<BringInfo>>(false, "参数有误", null);
		}

		BringInfo findedBringInfo = null;

		findedBringInfo = bringInfoService.getBringInfoById(bringInfo.getId());

		if (findedBringInfo == null) {
			return new Result<List<BringInfo>>(false, "查询失败", null);
		}
		List<BringInfo> list = new ArrayList<BringInfo>();
		list.add(findedBringInfo);
		return new Result<List<BringInfo>>(true, "success", list);
	}

	@ResponseBody
	@RequestMapping(value = "/nextOrBeforePage", method = RequestMethod.POST)
	public Result<BringInfoPage> nextOrBeforePage(@RequestBody BackPage backPage) {
		System.out.println(backPage.toString());
		if (backPage.getPageNow() < 0) {
			return new Result<BringInfoPage>(false, "false", null);
		}

		Page page = new Page();

		int count = bringInfoService.getCount();
		page.setPageNow(backPage.getPageNow());
		page.setTotalCount(count);
		List<BringInfo> list = bringInfoService.getBringInfoList(page.getPageNow(), page.getPageSize());

		BackPage returnPage = new BackPage();
		returnPage.setPageNow(backPage.getPageNow() + 1);
		returnPage.setTotalPageCount(page.getTotalPageCount());

		BringInfoPage bringInfoPage = new BringInfoPage();
		bringInfoPage.setList(list);
		bringInfoPage.setBackPage(returnPage);
		System.out.println(returnPage.toString());
		return new Result<BringInfoPage>(true, "success", bringInfoPage);
	}
}
