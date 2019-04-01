package com.util;

import java.util.List;

/**
 * Created by ld on 2019/3/28.
 */
public class Result {
    private List<?> list;
    private Integer pageNo;
    private Integer count;
    private Integer maxSize;

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Result(List<?> list, Integer pageNo, Integer count, Integer pageSize) {
        this.list = list;
        this.pageNo = pageNo;
        this.count = count;
        this.maxSize=count%pageSize>0?(count/pageSize+1):(count/pageSize);

    }
}
