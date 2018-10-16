package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long hVf;
    long hVg;
    int hVh;
    String hVj;
    String title;
    String hVi = "08:00-22:00";
    int hVk = 0;
    int hVl = 0;

    /* renamed from: do  reason: not valid java name */
    public void m24do(long j) {
        this.hVf = j;
    }

    public void dp(long j) {
        this.hVg = j;
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
        sb.append("messageID:" + this.hVq);
        sb.append(",taskID:" + this.hVr);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hVj);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hVh);
        sb.append(",startTime:" + this.hVf);
        sb.append(",endTime:" + this.hVg);
        sb.append(",balanceTime:" + this.hVh);
        sb.append(",timeRanges:" + this.hVi);
        sb.append(",forcedDelivery:" + this.hVk);
        sb.append(",distinctBycontent:" + this.hVl);
        return sb.toString();
    }

    public void wW(int i) {
        this.hVh = i;
    }

    public void wX(int i) {
        this.hVk = i;
    }

    public void wY(int i) {
        this.hVl = i;
    }

    public void yh(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hVi = str;
    }

    public void yi(String str) {
        this.hVj = str;
    }
}
