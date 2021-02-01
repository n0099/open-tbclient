package com.bytedance.tea.crash.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f7656a;

    public j(Context context) {
        this.f7656a = context.getSharedPreferences("npth", 0);
    }

    public void a(String str) {
        this.f7656a.edit().putString("device_id", str).apply();
    }

    public String a() {
        String e = com.bytedance.tea.crash.h.erd().e();
        if (TextUtils.isEmpty(e) || "0".equals(e)) {
            return this.f7656a.getString("device_id", "0");
        }
        return e;
    }
}
