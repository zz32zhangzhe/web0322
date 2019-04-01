package com.util;

/**
 * Created by ld on 2019/3/28.
 */
public class Page {
    private Integer pageNumber=1;
    private Integer pageSize=10;
    /* 该值如果为1分页 如果为0分页*/
    private Integer withPage=1;

    public Integer getWithPage() {
        return withPage;
    }

    public void setWithPage(Integer withPage) {
        this.withPage = withPage;
    }

    private int getPageStart(){
        return (pageNumber-1)*pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
