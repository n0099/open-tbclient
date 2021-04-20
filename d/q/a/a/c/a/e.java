package d.q.a.a.c.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f68372a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f68373b;

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f68372a = sharedPreferences;
            this.f68373b = sharedPreferences.edit();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final void a(String str) {
        this.f68373b.putString("kwtk", str);
        this.f68373b.commit();
    }

    public final boolean b() {
        return this.f68372a.getBoolean("xytk", true);
    }

    public final String c() {
        return this.f68372a.getString("kwtk", "");
    }

    public final void d(String str) {
        this.f68373b.putString("oai_ll_sn_d", str);
        this.f68373b.commit();
    }

    public final String e() {
        return this.f68372a.getString("oai_ll_sn_d", "");
    }
}
