package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long hmf;
    long hmg;
    int hmh;
    String hmj;
    String title;
    String hmi = "08:00-22:00";
    int hmk = 0;
    int hml = 0;

    public void dc(long j) {
        this.hmf = j;
    }

    public void dd(long j) {
        this.hmg = j;
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
        sb.append("messageID:" + this.hmr);
        sb.append(",taskID:" + this.hms);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hmj);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hmh);
        sb.append(",startTime:" + this.hmf);
        sb.append(",endTime:" + this.hmg);
        sb.append(",balanceTime:" + this.hmh);
        sb.append(",timeRanges:" + this.hmi);
        sb.append(",forcedDelivery:" + this.hmk);
        sb.append(",distinctBycontent:" + this.hml);
        return sb.toString();
    }

    public void vs(int i) {
        this.hmh = i;
    }

    public void vt(int i) {
        this.hmk = i;
    }

    public void vu(int i) {
        this.hml = i;
    }

    public void vx(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hmi = str;
    }

    public void vy(String str) {
        this.hmj = str;
    }
}
