package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a extends c {
    String content;
    long hWU;
    long hWV;
    int hWW;
    String hWY;
    String title;
    String hWX = "08:00-22:00";
    int hWZ = 0;
    int hXa = 0;

    public void df(long j) {
        this.hWU = j;
    }

    public void dg(long j) {
        this.hWV = j;
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
        sb.append("messageID:" + this.hXg);
        sb.append(",taskID:" + this.hXh);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hWY);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hWW);
        sb.append(",startTime:" + this.hWU);
        sb.append(",endTime:" + this.hWV);
        sb.append(",balanceTime:" + this.hWW);
        sb.append(",timeRanges:" + this.hWX);
        sb.append(",forcedDelivery:" + this.hWZ);
        sb.append(",distinctBycontent:" + this.hXa);
        return sb.toString();
    }

    public void vm(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hWX = str;
    }

    public void vn(String str) {
        this.hWY = str;
    }

    public void zp(int i) {
        this.hWW = i;
    }

    public void zq(int i) {
        this.hWZ = i;
    }

    public void zr(int i) {
        this.hXa = i;
    }
}
