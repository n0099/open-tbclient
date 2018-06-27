package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long hDj;
    long hDk;
    int hDl;
    String hDn;
    String title;
    String hDm = "08:00-22:00";
    int hDo = 0;
    int hDp = 0;

    public void dh(long j) {
        this.hDj = j;
    }

    public void di(long j) {
        this.hDk = j;
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
        sb.append("messageID:" + this.hDv);
        sb.append(",taskID:" + this.hDw);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hDn);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hDl);
        sb.append(",startTime:" + this.hDj);
        sb.append(",endTime:" + this.hDk);
        sb.append(",balanceTime:" + this.hDl);
        sb.append(",timeRanges:" + this.hDm);
        sb.append(",forcedDelivery:" + this.hDo);
        sb.append(",distinctBycontent:" + this.hDp);
        return sb.toString();
    }

    public void vS(int i) {
        this.hDl = i;
    }

    public void vT(int i) {
        this.hDo = i;
    }

    public void vU(int i) {
        this.hDp = i;
    }

    public void wq(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hDm = str;
    }

    public void wr(String str) {
        this.hDn = str;
    }
}
