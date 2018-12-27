package com.coloros.mcssdk.e;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long ihn;
    long iho;
    int ihp;
    String ihr;
    String title;
    String ihq = "08:00-22:00";
    int ihs = 0;
    int iht = 0;

    public void dv(long j) {
        this.ihn = j;
    }

    public void dw(long j) {
        this.iho = j;
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
        sb.append("messageID:" + this.ihy);
        sb.append(",taskID:" + this.ihz);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.ihr);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.ihp);
        sb.append(",startTime:" + this.ihn);
        sb.append(",endTime:" + this.iho);
        sb.append(",balanceTime:" + this.ihp);
        sb.append(",timeRanges:" + this.ihq);
        sb.append(",forcedDelivery:" + this.ihs);
        sb.append(",distinctBycontent:" + this.iht);
        return sb.toString();
    }

    public void xZ(int i) {
        this.ihp = i;
    }

    public void yS(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ihq = str;
    }

    public void yT(String str) {
        this.ihr = str;
    }

    public void ya(int i) {
        this.ihs = i;
    }

    public void yb(int i) {
        this.iht = i;
    }
}
