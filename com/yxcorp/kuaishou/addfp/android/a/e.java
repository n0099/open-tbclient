package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f8623a;
    private SharedPreferences.Editor b;

    public e(Context context) {
        try {
            this.f8623a = context.getSharedPreferences("kscfg_outdfp", 0);
            this.b = this.f8623a.edit();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a(String str) {
        this.b.putString("kwtk", str);
        this.b.commit();
    }

    public final boolean a() {
        return this.f8623a.getBoolean("xytk", true);
    }

    public final String b() {
        return this.f8623a.getString("kwtk", "");
    }

    public final void b(String str) {
        this.b.putString("oai_ll_sn_d", str);
        this.b.commit();
    }

    public final String c() {
        return this.f8623a.getString("oai_ll_sn_d", "");
    }
}
