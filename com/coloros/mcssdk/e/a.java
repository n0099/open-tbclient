package com.coloros.mcssdk.e;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long iiv;
    long iiw;
    int iix;
    String iiz;
    String title;
    String iiy = "08:00-22:00";
    int iiA = 0;
    int iiB = 0;

    public void dv(long j) {
        this.iiv = j;
    }

    public void dw(long j) {
        this.iiw = j;
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
        sb.append("messageID:" + this.iiG);
        sb.append(",taskID:" + this.iiH);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.iiz);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.iix);
        sb.append(",startTime:" + this.iiv);
        sb.append(",endTime:" + this.iiw);
        sb.append(",balanceTime:" + this.iix);
        sb.append(",timeRanges:" + this.iiy);
        sb.append(",forcedDelivery:" + this.iiA);
        sb.append(",distinctBycontent:" + this.iiB);
        return sb.toString();
    }

    public void yb(int i) {
        this.iix = i;
    }

    public void yc(int i) {
        this.iiA = i;
    }

    public void yd(int i) {
        this.iiB = i;
    }

    public void zi(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.iiy = str;
    }

    public void zj(String str) {
        this.iiz = str;
    }
}
