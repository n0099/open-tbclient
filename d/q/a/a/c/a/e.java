package d.q.a.a.c.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f66898a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f66899b;

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f66898a = sharedPreferences;
            this.f66899b = sharedPreferences.edit();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final void a(String str) {
        this.f66899b.putString("kwtk", str);
        this.f66899b.commit();
    }

    public final boolean b() {
        return this.f66898a.getBoolean("xytk", true);
    }

    public final String c() {
        return this.f66898a.getString("kwtk", "");
    }

    public final void d(String str) {
        this.f66899b.putString("oai_ll_sn_d", str);
        this.f66899b.commit();
    }

    public final String e() {
        return this.f66898a.getString("oai_ll_sn_d", "");
    }
}
