package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a extends c {
    String content;
    String hOA;
    long hOw;
    long hOx;
    int hOy;
    String title;
    String hOz = "08:00-22:00";
    int hOB = 0;
    int hOC = 0;

    public void cW(long j) {
        this.hOw = j;
    }

    public void cX(long j) {
        this.hOx = j;
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
        sb.append("messageID:" + this.hOI);
        sb.append(",taskID:" + this.hOJ);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hOA);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hOy);
        sb.append(",startTime:" + this.hOw);
        sb.append(",endTime:" + this.hOx);
        sb.append(",balanceTime:" + this.hOy);
        sb.append(",timeRanges:" + this.hOz);
        sb.append(",forcedDelivery:" + this.hOB);
        sb.append(",distinctBycontent:" + this.hOC);
        return sb.toString();
    }

    public void uU(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hOz = str;
    }

    public void uV(String str) {
        this.hOA = str;
    }

    public void xR(int i) {
        this.hOy = i;
    }

    public void xS(int i) {
        this.hOB = i;
    }

    public void xT(int i) {
        this.hOC = i;
    }
}
