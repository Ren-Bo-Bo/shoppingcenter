package com.qf.shoppingcenter.entity;

import java.util.Date;

public class TOrder {
    private Integer id;

    private String oSendtype;

    private String oPaytype;

    private Double oPaycount;

    private Date oOrderdate;

    private Integer oCheckstate;

    private Date oCheckdate;

    private String oCheckperson;

    private Integer userid;

    private String oShperson;

    private String oShphone;

    private String oShaddress;

    private Boolean isvalid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getoSendtype() {
        return oSendtype;
    }

    public void setoSendtype(String oSendtype) {
        this.oSendtype = oSendtype;
    }

    public String getoPaytype() {
        return oPaytype;
    }

    public void setoPaytype(String oPaytype) {
        this.oPaytype = oPaytype;
    }

    public Double getoPaycount() {
        return oPaycount;
    }

    public void setoPaycount(Double oPaycount) {
        this.oPaycount = oPaycount;
    }

    public Date getoOrderdate() {
        return oOrderdate;
    }

    public void setoOrderdate(Date oOrderdate) {
        this.oOrderdate = oOrderdate;
    }

    public Integer getoCheckstate() {
        return oCheckstate;
    }

    public void setoCheckstate(Integer oCheckstate) {
        this.oCheckstate = oCheckstate;
    }

    public Date getoCheckdate() {
        return oCheckdate;
    }

    public void setoCheckdate(Date oCheckdate) {
        this.oCheckdate = oCheckdate;
    }

    public String getoCheckperson() {
        return oCheckperson;
    }

    public void setoCheckperson(String oCheckperson) {
        this.oCheckperson = oCheckperson;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getoShperson() {
        return oShperson;
    }

    public void setoShperson(String oShperson) {
        this.oShperson = oShperson;
    }

    public String getoShphone() {
        return oShphone;
    }

    public void setoShphone(String oShphone) {
        this.oShphone = oShphone;
    }

    public String getoShaddress() {
        return oShaddress;
    }

    public void setoShaddress(String oShaddress) {
        this.oShaddress = oShaddress;
    }

    public Boolean getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Boolean isvalid) {
        this.isvalid = isvalid;
    }
}