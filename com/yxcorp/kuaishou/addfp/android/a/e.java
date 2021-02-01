package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f14387a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f14388b;

    public e(Context context) {
        try {
            this.f14387a = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f14388b = this.f14387a.edit();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a(String str) {
        this.f14388b.putString("kwtk", str);
        this.f14388b.commit();
    }

    public final boolean a() {
        return this.f14387a.getBoolean("xytk", true);
    }

    public final String b() {
        return this.f14387a.getString("kwtk", "");
    }

    public final void b(String str) {
        this.f14388b.putString("oai_ll_sn_d", str);
        this.f14388b.commit();
    }

    public final String c() {
        return this.f14387a.getString("oai_ll_sn_d", "");
    }
}
