package com.coloros.mcssdk.e;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long iiu;
    long iiv;
    int iiw;
    String iiy;
    String title;
    String iix = "08:00-22:00";
    int iiz = 0;
    int iiA = 0;

    public void dv(long j) {
        this.iiu = j;
    }

    public void dw(long j) {
        this.iiv = j;
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
        sb.append("messageID:" + this.iiF);
        sb.append(",taskID:" + this.iiG);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.iiy);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.iiw);
        sb.append(",startTime:" + this.iiu);
        sb.append(",endTime:" + this.iiv);
        sb.append(",balanceTime:" + this.iiw);
        sb.append(",timeRanges:" + this.iix);
        sb.append(",forcedDelivery:" + this.iiz);
        sb.append(",distinctBycontent:" + this.iiA);
        return sb.toString();
    }

    public void yb(int i) {
        this.iiw = i;
    }

    public void yc(int i) {
        this.iiz = i;
    }

    public void yd(int i) {
        this.iiA = i;
    }

    public void zi(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.iix = str;
    }

    public void zj(String str) {
        this.iiy = str;
    }
}
