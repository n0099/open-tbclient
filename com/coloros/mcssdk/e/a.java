package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a extends c {
    String content;
    long hOH;
    long hOI;
    int hOJ;
    String hOL;
    String title;
    String hOK = "08:00-22:00";
    int hOM = 0;
    int hON = 0;

    public void cW(long j) {
        this.hOH = j;
    }

    public void cX(long j) {
        this.hOI = j;
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
        sb.append("messageID:" + this.hOT);
        sb.append(",taskID:" + this.hOU);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.hOL);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.hOJ);
        sb.append(",startTime:" + this.hOH);
        sb.append(",endTime:" + this.hOI);
        sb.append(",balanceTime:" + this.hOJ);
        sb.append(",timeRanges:" + this.hOK);
        sb.append(",forcedDelivery:" + this.hOM);
        sb.append(",distinctBycontent:" + this.hON);
        return sb.toString();
    }

    public void uU(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hOK = str;
    }

    public void uV(String str) {
        this.hOL = str;
    }

    public void xS(int i) {
        this.hOJ = i;
    }

    public void xT(int i) {
        this.hOM = i;
    }

    public void xU(int i) {
        this.hON = i;
    }
}
