package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes18.dex */
public class eg extends ed {
    public eg(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo169a() {
        return 23;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo169a() {
        return ho.Storage;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo169a() {
        StringBuilder sb = new StringBuilder();
        sb.append("ram:").append(i.m395b()).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append("rom:").append(i.m397c()).append("|").append("ramOriginal:").append(i.d()).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append("romOriginal:").append(i.e());
        return sb.toString();
    }
}
