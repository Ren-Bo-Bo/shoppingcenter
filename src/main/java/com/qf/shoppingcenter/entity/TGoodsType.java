package com.qf.shoppingcenter.entity;

import java.util.List;

public class TGoodsType {
    private Integer id;

    private String gtypeName;

    private Integer gtypeParentid;

    private String gtypePic;

    private Boolean isvalid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGtypeName() {
        return gtypeName;
    }

    public void setGtypeName(String gtypeName) {
        this.gtypeName = gtypeName;
    }

    public Integer getGtypeParentid() {
        return gtypeParentid;
    }

    public void setGtypeParentid(Integer gtypeParentid) {
        this.gtypeParentid = gtypeParentid;
    }

    public String getGtypePic() {
        return gtypePic;
    }

    public void setGtypePic(String gtypePic) {
        this.gtypePic = gtypePic;
    }

    public Boolean getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Boolean isvalid) {
        this.isvalid = isvalid;
    }
}