package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long jxZ;
    long jya;
    int jyb;
    String jyd;
    String title;
    String jyc = "08:00-22:00";
    int jye = 0;
    int jyf = 0;

    public void BN(int i) {
        this.jyb = i;
    }

    public void BO(int i) {
        this.jye = i;
    }

    public void BP(int i) {
        this.jyf = i;
    }

    public void Fk(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.jyc = str;
    }

    public void Fl(String str) {
        this.jyd = str;
    }

    public void ea(long j) {
        this.jxZ = j;
    }

    public void eb(long j) {
        this.jya = j;
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
        sb.append("messageID:" + this.jyk);
        sb.append(",taskID:" + this.jyl);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.jyd);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.jyb);
        sb.append(",startTime:" + this.jxZ);
        sb.append(",endTime:" + this.jya);
        sb.append(",balanceTime:" + this.jyb);
        sb.append(",timeRanges:" + this.jyc);
        sb.append(",forcedDelivery:" + this.jye);
        sb.append(",distinctBycontent:" + this.jyf);
        return sb.toString();
    }
}
