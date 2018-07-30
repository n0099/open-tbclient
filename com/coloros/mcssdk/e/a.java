package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long hDO;
    long hDP;
    int hDQ;
    String hDS;
    String title;
    String hDR = "08:00-22:00";
    int hDT = 0;
    int hDU = 0;

    public void de(long j) {
        this.hDO = j;
    }

    public void df(long j) {
        this.hDP = j;
    }

    @Override // com.coloros.mcssdk.e.c
    public int getType() {
        return InputDeviceCompat.SOURCE_TOUCHSCREEN;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("messageID:" + this.hEa);
        sb.append(",taskID:" + this.hEb);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hDS);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hDQ);
        sb.append(",startTime:" + this.hDO);
        sb.append(",endTime:" + this.hDP);
        sb.append(",balanceTime:" + this.hDQ);
        sb.append(",timeRanges:" + this.hDR);
        sb.append(",forcedDelivery:" + this.hDT);
        sb.append(",distinctBycontent:" + this.hDU);
        return sb.toString();
    }

    public void vP(int i) {
        this.hDQ = i;
    }

    public void vQ(int i) {
        this.hDT = i;
    }

    public void vR(int i) {
        this.hDU = i;
    }

    public void ws(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hDR = str;
    }

    public void wt(String str) {
        this.hDS = str;
    }
}
