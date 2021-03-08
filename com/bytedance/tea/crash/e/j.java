package com.bytedance.tea.crash.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f5181a;

    public j(Context context) {
        this.f5181a = context.getSharedPreferences("npth", 0);
    }

    public void a(String str) {
        this.f5181a.edit().putString("device_id", str).apply();
    }

    public String a() {
        String e = com.bytedance.tea.crash.h.erv().e();
        if (TextUtils.isEmpty(e) || "0".equals(e)) {
            return this.f5181a.getString("device_id", "0");
        }
        return e;
    }
}
