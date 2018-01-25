package com.demo.utils;

public class CommonPage {

    private Integer pageNum;

    private Integer pageSize;

    private Integer totalPage;

    private Integer total;

    private String sortType;

    private String sortName;

    public CommonPage() {
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    @Override
    public String toString() {
        return "CommonPage{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", total=" + total +
                ", sortType='" + sortType + '\'' +
                ", sortName='" + sortName + '\'' +
                '}';
    }

    /*
    * 判断是否存在分页
    * */
    public CommonPage isNull(CommonPage commonPage) {

        if (commonPage.getPageNum() == null || commonPage.getPageNum().equals("")) {
            commonPage.setPageNum(1);
        }

        if (commonPage.getPageSize() == null || commonPage.getPageSize().equals("")) {
            commonPage.setPageSize(10);
        }

        if (commonPage.getSortType() == null || commonPage.getSortType().equals("")) {
            commonPage.setSortType("DESC");
        }

        if (commonPage.getSortName() == null || commonPage.getSortName().equals("")) {
            commonPage.setSortName("id");
        }

        return commonPage;
    }
}
