package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class eb extends dx {
    private SharedPreferences a;

    public eb(Context context, int i) {
        super(context, i);
        this.a = context.getSharedPreferences("mipush_extra", 0);
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo140a() {
        return 9;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public hi mo140a() {
        return hi.TopApp;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo140a() {
        return null;
    }
}
