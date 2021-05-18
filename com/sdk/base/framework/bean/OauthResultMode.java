package com.sdk.base.framework.bean;

import java.io.Serializable;
/* loaded from: classes7.dex */
public class OauthResultMode implements Serializable {
    public int code;
    public String msg;
    public Object object;
    public String seq;
    public int status;

    public OauthResultMode() {
    }

    public OauthResultMode(int i2, String str, int i3) {
        this.code = i2;
        this.msg = str;
        this.status = i3;
    }

    public OauthResultMode(int i2, String str, int i3, Object obj, String str2) {
        this.code = i2;
        this.msg = str;
        this.status = i3;
        this.object = obj;
        this.seq = str2;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Object getObject() {
        return this.object;
    }

    public String getSeq() {
        return this.seq;
    }

    public int getStatus() {
        return this.status;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setObject(Object obj) {
        this.object = obj;
    }

    public void setSeq(String str) {
        this.seq = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public String toString() {
        return "OauthResultMode{code=" + this.code + ", msg='" + this.msg + "', status=" + this.status + ", object=" + this.object + ", seq='" + this.seq + "'}";
    }
}
