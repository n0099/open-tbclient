package com.sdk.base.framework.bean;

import com.sdk.base.framework.f.c.a;
/* loaded from: classes7.dex */
public class SmsInfo {
    public String content;
    public Long ctime;
    public Long ftime;
    public String mobile;
    public int opt;
    public String result;

    public SmsInfo() {
    }

    public SmsInfo(String str, String str2, int i2, Long l, Long l2, String str3) {
        this.content = str;
        this.mobile = str2;
        this.opt = i2;
        this.ctime = l;
        this.ftime = l2;
        this.result = str3;
    }

    public String getContent() {
        return this.content;
    }

    public Long getCtime() {
        return this.ctime;
    }

    public Long getFtime() {
        return this.ftime;
    }

    public String getMobile() {
        return this.mobile;
    }

    public int getOpt() {
        return this.opt;
    }

    public String getResult() {
        return this.result;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCtime(Long l) {
        this.ctime = l;
    }

    public void setFtime(Long l) {
        this.ftime = l;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setOpt(int i2) {
        this.opt = i2;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public String toJsonString() {
        return a.a(this);
    }

    public String toString() {
        return "{'content':'" + this.content + "', 'mobile':'" + this.mobile + "', 'opt':'" + this.opt + "', 'ctime':'" + this.ctime + "', 'ftime':'" + this.ftime + "', 'result':'" + this.result + "'}";
    }
}
