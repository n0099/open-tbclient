package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a extends c {
    String content;
    long hMY;
    long hMZ;
    int hNa;
    String hNc;
    String title;
    String hNb = "08:00-22:00";
    int hNd = 0;
    int hNe = 0;

    public void cZ(long j) {
        this.hMY = j;
    }

    public void da(long j) {
        this.hMZ = j;
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
        sb.append("messageID:" + this.hNk);
        sb.append(",taskID:" + this.hNl);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hNc);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hNa);
        sb.append(",startTime:" + this.hMY);
        sb.append(",endTime:" + this.hMZ);
        sb.append(",balanceTime:" + this.hNa);
        sb.append(",timeRanges:" + this.hNb);
        sb.append(",forcedDelivery:" + this.hNd);
        sb.append(",distinctBycontent:" + this.hNe);
        return sb.toString();
    }

    public void uP(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hNb = str;
    }

    public void uQ(String str) {
        this.hNc = str;
    }

    public void xS(int i) {
        this.hNa = i;
    }

    public void xT(int i) {
        this.hNd = i;
    }

    public void xU(int i) {
        this.hNe = i;
    }
}
