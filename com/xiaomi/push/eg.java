package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes6.dex */
public class eg extends ed {
    public eg(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo191a() {
        return 23;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo191a() {
        return ho.Storage;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo191a() {
        StringBuilder sb = new StringBuilder();
        sb.append("ram:").append(i.m417b()).append(",").append("rom:").append(i.m419c()).append("|").append("ramOriginal:").append(i.d()).append(",").append("romOriginal:").append(i.e());
        return sb.toString();
    }
}
