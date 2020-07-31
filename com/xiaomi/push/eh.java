package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes9.dex */
public class eh extends ed {
    private SharedPreferences a;

    public eh(Context context, int i) {
        super(context, i);
        this.a = context.getSharedPreferences("mipush_extra", 0);
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo161a() {
        return 9;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo161a() {
        return ho.TopApp;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo161a() {
        return null;
    }
}
