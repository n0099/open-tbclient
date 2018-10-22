package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long hVg;
    long hVh;
    int hVi;
    String hVk;
    String title;
    String hVj = "08:00-22:00";
    int hVl = 0;
    int hVm = 0;

    /* renamed from: do  reason: not valid java name */
    public void m24do(long j) {
        this.hVg = j;
    }

    public void dp(long j) {
        this.hVh = j;
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
        sb.append("messageID:" + this.hVr);
        sb.append(",taskID:" + this.hVs);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hVk);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hVi);
        sb.append(",startTime:" + this.hVg);
        sb.append(",endTime:" + this.hVh);
        sb.append(",balanceTime:" + this.hVi);
        sb.append(",timeRanges:" + this.hVj);
        sb.append(",forcedDelivery:" + this.hVl);
        sb.append(",distinctBycontent:" + this.hVm);
        return sb.toString();
    }

    public void wW(int i) {
        this.hVi = i;
    }

    public void wX(int i) {
        this.hVl = i;
    }

    public void wY(int i) {
        this.hVm = i;
    }

    public void yh(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hVj = str;
    }

    public void yi(String str) {
        this.hVk = str;
    }
}
