package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long hng;
    long hnh;
    int hni;
    String hnk;
    String title;
    String hnj = "08:00-22:00";
    int hnl = 0;
    int hnm = 0;

    public void dc(long j) {
        this.hng = j;
    }

    public void dd(long j) {
        this.hnh = j;
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
        sb.append("messageID:" + this.hns);
        sb.append(",taskID:" + this.hnt);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hnk);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hni);
        sb.append(",startTime:" + this.hng);
        sb.append(",endTime:" + this.hnh);
        sb.append(",balanceTime:" + this.hni);
        sb.append(",timeRanges:" + this.hnj);
        sb.append(",forcedDelivery:" + this.hnl);
        sb.append(",distinctBycontent:" + this.hnm);
        return sb.toString();
    }

    public void vA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hnj = str;
    }

    public void vB(String str) {
        this.hnk = str;
    }

    public void vr(int i) {
        this.hni = i;
    }

    public void vs(int i) {
        this.hnl = i;
    }

    public void vt(int i) {
        this.hnm = i;
    }
}
