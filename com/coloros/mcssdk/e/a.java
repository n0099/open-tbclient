package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long hMl;
    long hMm;
    int hMn;
    String hMp;
    String title;
    String hMo = "08:00-22:00";
    int hMq = 0;
    int hMr = 0;

    public void dg(long j) {
        this.hMl = j;
    }

    public void dh(long j) {
        this.hMm = j;
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
        sb.append("messageID:" + this.hMw);
        sb.append(",taskID:" + this.hMx);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hMp);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hMn);
        sb.append(",startTime:" + this.hMl);
        sb.append(",endTime:" + this.hMm);
        sb.append(",balanceTime:" + this.hMn);
        sb.append(",timeRanges:" + this.hMo);
        sb.append(",forcedDelivery:" + this.hMq);
        sb.append(",distinctBycontent:" + this.hMr);
        return sb.toString();
    }

    public void wp(int i) {
        this.hMn = i;
    }

    public void wq(int i) {
        this.hMq = i;
    }

    public void wr(int i) {
        this.hMr = i;
    }

    public void xh(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hMo = str;
    }

    public void xi(String str) {
        this.hMp = str;
    }
}
