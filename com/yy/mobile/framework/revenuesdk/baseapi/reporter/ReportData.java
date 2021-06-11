package com.yy.mobile.framework.revenuesdk.baseapi.reporter;
/* loaded from: classes7.dex */
public class ReportData {
    public int code;
    public String desc;
    public String interName;

    public ReportData() {
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getInterName() {
        return this.interName;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setInterName(String str) {
        this.interName = str;
    }

    public String toString() {
        return "ReportData{interName='" + this.interName + "', desc='" + this.desc + "', code=" + this.code + '}';
    }

    public ReportData(String str, String str2, int i2) {
        this.interName = str;
        this.desc = str2;
        this.code = i2;
    }
}
