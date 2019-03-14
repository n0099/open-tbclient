package com.coloros.mcssdk.e;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long jyk;
    long jyl;
    int jym;
    String jyo;
    String title;
    String jyn = "08:00-22:00";
    int jyp = 0;
    int jyq = 0;

    public void BO(int i) {
        this.jym = i;
    }

    public void BP(int i) {
        this.jyp = i;
    }

    public void BQ(int i) {
        this.jyq = i;
    }

    public void Fl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.jyn = str;
    }

    public void Fm(String str) {
        this.jyo = str;
    }

    public void ea(long j) {
        this.jyk = j;
    }

    public void eb(long j) {
        this.jyl = j;
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
        sb.append("messageID:" + this.jyv);
        sb.append(",taskID:" + this.jyw);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.jyo);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.jym);
        sb.append(",startTime:" + this.jyk);
        sb.append(",endTime:" + this.jyl);
        sb.append(",balanceTime:" + this.jym);
        sb.append(",timeRanges:" + this.jyn);
        sb.append(",forcedDelivery:" + this.jyp);
        sb.append(",distinctBycontent:" + this.jyq);
        return sb.toString();
    }
}
