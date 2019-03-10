package com.coloros.mcssdk.e;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a extends c {
    String content;
    long jys;
    long jyt;
    int jyu;
    String jyw;
    String title;
    String jyv = "08:00-22:00";
    int jyx = 0;
    int jyy = 0;

    public void BO(int i) {
        this.jyu = i;
    }

    public void BP(int i) {
        this.jyx = i;
    }

    public void BQ(int i) {
        this.jyy = i;
    }

    public void Fn(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.jyv = str;
    }

    public void Fo(String str) {
        this.jyw = str;
    }

    public void ea(long j) {
        this.jys = j;
    }

    public void eb(long j) {
        this.jyt = j;
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
        sb.append("messageID:" + this.jyD);
        sb.append(",taskID:" + this.jyE);
        sb.append(",appPackage:" + this.appPackage);
        sb.append(",title:" + this.title);
        sb.append(",rule:" + this.jyw);
        sb.append(",content:" + this.content);
        sb.append(",balanceTime:" + this.jyu);
        sb.append(",startTime:" + this.jys);
        sb.append(",endTime:" + this.jyt);
        sb.append(",balanceTime:" + this.jyu);
        sb.append(",timeRanges:" + this.jyv);
        sb.append(",forcedDelivery:" + this.jyx);
        sb.append(",distinctBycontent:" + this.jyy);
        return sb.toString();
    }
}
