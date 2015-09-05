package com.nyu.util.page;

/**
 * 这里是�?鉴网上的例子，具体出处忘了�?对原作�?表示抱歉�?
 * 这个类主要是封转有关分页的相关操作，比如下一页，上一页，�?���?��，首�?
 * 在此demo中，只用到改类中的计算页数的相关操作，至于下�?��、上�?��等操作，MyPagination已经帮我们封转好了啊�?
 * @author Administrator
 *
 */


public class Page {
	private int totalRow;	//总共记录�?
	private int totalPage;	//总共页数
	private int currentPage = 1; //当前页，默认�?
	private int pageSize = 25;   //页的大小
	private boolean hasPrevious; //是否有上�?��
	private boolean hasNext; //是否有下�?��
	private boolean bof;  //是否是首�?
	private boolean eof;  //是否是尾�?
	
    public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public int getCurrentPage() {

		return this.currentPage;
	}
	
	public boolean isHasPrevious() {
		return hasPrevious;
	}
	public boolean isHasNext() {
		return hasNext;
	}
	public boolean isBof() {
		return bof;
	}
	public boolean isEof() {
		return eof;
	}
	public boolean hasNext() {
		return currentPage < this.totalPage;
	}
	public boolean hasPrevious() {
		return currentPage > 1;
	}
	public boolean isFirst() {
		return currentPage == 1;
	}
	public boolean isLast() {
		return currentPage >= this.totalPage;
	}
	
	// 获取分页大小
	public int getPageSize() {
		return pageSize;
	}
	// 设置分页大小
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	/*
	 * 构�?方法
     */
	public Page(){
		
	}
	
	
	
	/*
	 * 构�?方法
	   @param totalRow 总记录数
	   @param pageSize 页的大小
	   @param page 页码
     */
	public Page(int totalRow, int pageSize, int page) {
		this.totalRow = totalRow;
		this.pageSize = pageSize;
		// 根据页大小和总记录数计算出�?页数
		this.totalPage = countTotalPage(this.pageSize, this.totalRow);
		// 修正当前�?
		setCurrentPage(page);
		init();
	}
	
	// 初始化信�?
	private void init() {

		this.hasNext = hasNext();

		this.hasPrevious = hasPrevious();

		this.bof = isFirst();

		this.eof = isLast();

	}
	
	// 修正计算当前�?
	public void setCurrentPage(int currentPage) {
        if(currentPage>this.totalPage){
        	this.currentPage=this.totalPage;        	
        }else if (currentPage<1){
        	this.currentPage=1;
        }
        else{
        	this.currentPage=currentPage;
        }
	}
	
	// 获取当前页记录的�?��索引
	public int getBeginIndex() {
		int beginIndex = (currentPage - 1) * pageSize; // 索引下标�?�?��
		return beginIndex;
	}
	
	// 计算总页�?
	public int countTotalPage(int pageSize, int totalRow) {
		int totalPage = totalRow % pageSize == 0 ? totalRow / pageSize : totalRow / pageSize + 1;
		return totalPage;
	}
	
	// 返回下一页的页码
	public int getNextPage() {
		if (currentPage + 1 >= this.totalPage) { // 如果当前页已经是�?���?则返回最大页
			return this.totalPage;
		}
		return currentPage + 1; 
	}
	
	
	// 返回前一页的页码
	public int getPreviousPage() {
		if (currentPage - 1 <= 1) {
			return 1;
		} else {
			return currentPage - 1;
		}
	}
}
