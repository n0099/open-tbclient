package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long hmc;
    long hmd;
    int hme;
    String hmg;
    String title;
    String hmf = "08:00-22:00";
    int hmh = 0;
    int hmi = 0;

    public void dc(long j) {
        this.hmc = j;
    }

    public void dd(long j) {
        this.hmd = j;
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
        sb.append("messageID:" + this.hmo);
        sb.append(",taskID:" + this.hmp);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hmg);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hme);
        sb.append(",startTime:" + this.hmc);
        sb.append(",endTime:" + this.hmd);
        sb.append(",balanceTime:" + this.hme);
        sb.append(",timeRanges:" + this.hmf);
        sb.append(",forcedDelivery:" + this.hmh);
        sb.append(",distinctBycontent:" + this.hmi);
        return sb.toString();
    }

    public void vs(int i) {
        this.hme = i;
    }

    public void vt(int i) {
        this.hmh = i;
    }

    public void vu(int i) {
        this.hmi = i;
    }

    public void vx(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hmf = str;
    }

    public void vy(String str) {
        this.hmg = str;
    }
}
