package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a extends c {
    String content;
    long hME;
    long hMF;
    int hMG;
    String hMI;
    String title;
    String hMH = "08:00-22:00";
    int hMJ = 0;
    int hMK = 0;

    public void cX(long j) {
        this.hME = j;
    }

    public void cY(long j) {
        this.hMF = j;
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
        sb.append("messageID:" + this.hMQ);
        sb.append(",taskID:" + this.hMR);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hMI);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hMG);
        sb.append(",startTime:" + this.hME);
        sb.append(",endTime:" + this.hMF);
        sb.append(",balanceTime:" + this.hMG);
        sb.append(",timeRanges:" + this.hMH);
        sb.append(",forcedDelivery:" + this.hMJ);
        sb.append(",distinctBycontent:" + this.hMK);
        return sb.toString();
    }

    public void uH(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hMH = str;
    }

    public void uI(String str) {
        this.hMI = str;
    }

    public void xS(int i) {
        this.hMG = i;
    }

    public void xT(int i) {
        this.hMJ = i;
    }

    public void xU(int i) {
        this.hMK = i;
    }
}
