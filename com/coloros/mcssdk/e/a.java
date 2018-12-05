package com.coloros.mcssdk.e;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long ied;
    long iee;
    int ief;
    String ieh;
    String title;
    String ieg = "08:00-22:00";
    int iei = 0;
    int iej = 0;

    public void dq(long j) {
        this.ied = j;
    }

    public void dr(long j) {
        this.iee = j;
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
        sb.append("messageID:" + this.ieo);
        sb.append(",taskID:" + this.iep);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.ieh);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.ief);
        sb.append(",startTime:" + this.ied);
        sb.append(",endTime:" + this.iee);
        sb.append(",balanceTime:" + this.ief);
        sb.append(",timeRanges:" + this.ieg);
        sb.append(",forcedDelivery:" + this.iei);
        sb.append(",distinctBycontent:" + this.iej);
        return sb.toString();
    }

    public void xM(int i) {
        this.ief = i;
    }

    public void xN(int i) {
        this.iei = i;
    }

    public void xO(int i) {
        this.iej = i;
    }

    public void yP(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ieg = str;
    }

    public void yQ(String str) {
        this.ieh = str;
    }
}
