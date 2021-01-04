package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f14684a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f14685b;

    public e(Context context) {
        try {
            this.f14684a = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f14685b = this.f14684a.edit();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a(String str) {
        this.f14685b.putString("kwtk", str);
        this.f14685b.commit();
    }

    public final boolean a() {
        return this.f14684a.getBoolean("xytk", true);
    }

    public final String b() {
        return this.f14684a.getString("kwtk", "");
    }

    public final void b(String str) {
        this.f14685b.putString("oai_ll_sn_d", str);
        this.f14685b.commit();
    }

    public final String c() {
        return this.f14684a.getString("oai_ll_sn_d", "");
    }
}
