package com.coloros.mcssdk.e;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long hWQ;
    long hWR;
    int hWS;
    String hWU;
    String title;
    String hWT = "08:00-22:00";
    int hWV = 0;
    int hWW = 0;

    public void dj(long j) {
        this.hWQ = j;
    }

    public void dk(long j) {
        this.hWR = j;
    }

    @Override // com.coloros.mcssdk.e.c
    public int getType() {
        return 4098;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("messageID:" + this.hXb);
        sb.append(",taskID:" + this.hXc);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hWU);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hWS);
        sb.append(",startTime:" + this.hWQ);
        sb.append(",endTime:" + this.hWR);
        sb.append(",balanceTime:" + this.hWS);
        sb.append(",timeRanges:" + this.hWT);
        sb.append(",forcedDelivery:" + this.hWV);
        sb.append(",distinctBycontent:" + this.hWW);
        return sb.toString();
    }

    public void xp(int i) {
        this.hWS = i;
    }

    public void xq(int i) {
        this.hWV = i;
    }

    public void xr(int i) {
        this.hWW = i;
    }

    public void ym(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hWT = str;
    }

    public void yn(String str) {
        this.hWU = str;
    }
}
