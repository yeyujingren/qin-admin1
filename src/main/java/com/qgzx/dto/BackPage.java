package com.qgzx.dto;

public class BackPage {
	private int pageNow;
	private int totalPageCount;

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	@Override
	public String toString() {
		return "BackPage [pageNow=" + pageNow + ", totalPageCount=" + totalPageCount + "]";
	}

}
