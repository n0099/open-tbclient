package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes5.dex */
public class eg extends ed {
    public eg(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo170a() {
        return 23;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo170a() {
        return ho.Storage;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo170a() {
        StringBuilder sb = new StringBuilder();
        sb.append("ram:").append(i.m396b()).append(",").append("rom:").append(i.m398c()).append("|").append("ramOriginal:").append(i.d()).append(",").append("romOriginal:").append(i.e());
        return sb.toString();
    }
}
