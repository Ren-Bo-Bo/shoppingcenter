package com.qf.shoppingcenter.dto;

import com.qf.shoppingcenter.entity.TGoodsType;
import javassist.SerialVersionUID;

import java.io.Serializable;
import java.util.List;

/**
 * 商品大类型的模板类
 */

public class TGoodsTypeDto implements Serializable {

    private Integer id;

    private String gtypeName;

    private Integer gtypeParentid;

    private String gtypePic;

    private Boolean isvalid;

    List<TGoodsType> childtypeList;

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

    public List<TGoodsType> getChildtypeList() {
        return childtypeList;
    }

    public void setChildtypeList(List<TGoodsType> childtypeList) {
        this.childtypeList = childtypeList;
    }
}