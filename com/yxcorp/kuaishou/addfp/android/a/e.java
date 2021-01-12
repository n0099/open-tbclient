package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f14385a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f14386b;

    public e(Context context) {
        try {
            this.f14385a = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f14386b = this.f14385a.edit();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a(String str) {
        this.f14386b.putString("kwtk", str);
        this.f14386b.commit();
    }

    public final boolean a() {
        return this.f14385a.getBoolean("xytk", true);
    }

    public final String b() {
        return this.f14385a.getString("kwtk", "");
    }

    public final void b(String str) {
        this.f14386b.putString("oai_ll_sn_d", str);
        this.f14386b.commit();
    }

    public final String c() {
        return this.f14385a.getString("oai_ll_sn_d", "");
    }
}
