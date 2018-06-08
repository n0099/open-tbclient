package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long hzc;
    long hzd;
    int hze;
    String hzg;
    String title;
    String hzf = "08:00-22:00";
    int hzh = 0;
    int hzi = 0;

    public void dj(long j) {
        this.hzc = j;
    }

    public void dk(long j) {
        this.hzd = j;
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
        sb.append("messageID:" + this.hzo);
        sb.append(",taskID:" + this.hzp);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hzg);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hze);
        sb.append(",startTime:" + this.hzc);
        sb.append(",endTime:" + this.hzd);
        sb.append(",balanceTime:" + this.hze);
        sb.append(",timeRanges:" + this.hzf);
        sb.append(",forcedDelivery:" + this.hzh);
        sb.append(",distinctBycontent:" + this.hzi);
        return sb.toString();
    }

    public void vJ(int i) {
        this.hze = i;
    }

    public void vK(int i) {
        this.hzh = i;
    }

    public void vL(int i) {
        this.hzi = i;
    }

    public void wu(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hzf = str;
    }

    public void wv(String str) {
        this.hzg = str;
    }
}
