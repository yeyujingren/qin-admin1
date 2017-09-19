package com.qgzx.dto;

import java.util.List;

import com.qgzx.entity.BringInfo;

public class BringInfoPage {
	private List<BringInfo> list;
	private BackPage backPage;

	public List<BringInfo> getList() {
		return list;
	}

	public void setList(List<BringInfo> list) {
		this.list = list;
	}

	public BackPage getBackPage() {
		return backPage;
	}

	public void setBackPage(BackPage backPage) {
		this.backPage = backPage;
	}
    
}
