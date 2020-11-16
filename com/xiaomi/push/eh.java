package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes18.dex */
public class eh extends ed {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f4875a;

    public eh(Context context, int i) {
        super(context, i);
        this.f4875a = context.getSharedPreferences("mipush_extra", 0);
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo169a() {
        return 9;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo169a() {
        return ho.TopApp;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo169a() {
        return null;
    }
}
