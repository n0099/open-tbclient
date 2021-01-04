package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public class eh extends ed {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f14266a;

    public eh(Context context, int i) {
        super(context, i);
        this.f14266a = context.getSharedPreferences("mipush_extra", 0);
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo185a() {
        return 9;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo185a() {
        return ho.TopApp;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo185a() {
        return null;
    }
}
