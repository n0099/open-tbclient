package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long hDQ;
    long hDR;
    int hDS;
    String hDU;
    String title;
    String hDT = "08:00-22:00";
    int hDV = 0;
    int hDW = 0;

    public void de(long j) {
        this.hDQ = j;
    }

    public void df(long j) {
        this.hDR = j;
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
        sb.append("messageID:" + this.hEc);
        sb.append(",taskID:" + this.hEd);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hDU);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hDS);
        sb.append(",startTime:" + this.hDQ);
        sb.append(",endTime:" + this.hDR);
        sb.append(",balanceTime:" + this.hDS);
        sb.append(",timeRanges:" + this.hDT);
        sb.append(",forcedDelivery:" + this.hDV);
        sb.append(",distinctBycontent:" + this.hDW);
        return sb.toString();
    }

    public void vP(int i) {
        this.hDS = i;
    }

    public void vQ(int i) {
        this.hDV = i;
    }

    public void vR(int i) {
        this.hDW = i;
    }

    public void ww(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hDT = str;
    }

    public void wx(String str) {
        this.hDU = str;
    }
}
