package d.q.a.a.c.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f71414a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f71415b;

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f71414a = sharedPreferences;
            this.f71415b = sharedPreferences.edit();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final void a(String str) {
        this.f71415b.putString("kwtk", str);
        this.f71415b.commit();
    }

    public final boolean b() {
        return this.f71414a.getBoolean("xytk", true);
    }

    public final String c() {
        return this.f71414a.getString("kwtk", "");
    }

    public final void d(String str) {
        this.f71415b.putString("oai_ll_sn_d", str);
        this.f71415b.commit();
    }

    public final String e() {
        return this.f71414a.getString("oai_ll_sn_d", "");
    }
}
