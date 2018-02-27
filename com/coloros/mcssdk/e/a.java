package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a extends c {
    String content;
    long hOj;
    long hOk;
    int hOl;
    String hOn;
    String title;
    String hOm = "08:00-22:00";
    int hOo = 0;
    int hOp = 0;

    public void cW(long j) {
        this.hOj = j;
    }

    public void cX(long j) {
        this.hOk = j;
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
        sb.append("messageID:" + this.hOv);
        sb.append(",taskID:" + this.hOw);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hOn);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hOl);
        sb.append(",startTime:" + this.hOj);
        sb.append(",endTime:" + this.hOk);
        sb.append(",balanceTime:" + this.hOl);
        sb.append(",timeRanges:" + this.hOm);
        sb.append(",forcedDelivery:" + this.hOo);
        sb.append(",distinctBycontent:" + this.hOp);
        return sb.toString();
    }

    public void uU(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hOm = str;
    }

    public void uV(String str) {
        this.hOn = str;
    }

    public void xS(int i) {
        this.hOl = i;
    }

    public void xT(int i) {
        this.hOo = i;
    }

    public void xU(int i) {
        this.hOp = i;
    }
}
