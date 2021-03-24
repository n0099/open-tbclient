package d.q.a.a.c.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f67374a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f67375b;

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f67374a = sharedPreferences;
            this.f67375b = sharedPreferences.edit();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final void a(String str) {
        this.f67375b.putString("kwtk", str);
        this.f67375b.commit();
    }

    public final boolean b() {
        return this.f67374a.getBoolean("xytk", true);
    }

    public final String c() {
        return this.f67374a.getString("kwtk", "");
    }

    public final void d(String str) {
        this.f67375b.putString("oai_ll_sn_d", str);
        this.f67375b.commit();
    }

    public final String e() {
        return this.f67374a.getString("oai_ll_sn_d", "");
    }
}
