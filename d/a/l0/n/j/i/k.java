package d.a.l0.n.j.i;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: b  reason: collision with root package name */
    public static volatile k f48152b;

    /* renamed from: a  reason: collision with root package name */
    public a f48153a = new a();

    /* loaded from: classes3.dex */
    public static class a extends d.a.l0.t.j {
        public a() {
            super("swan_preload_package");
        }
    }

    public static k a() {
        if (f48152b == null) {
            synchronized (k.class) {
                if (f48152b == null) {
                    f48152b = new k();
                }
            }
        }
        return f48152b;
    }

    public String b() {
        return this.f48153a.getString("version", "0");
    }

    public void c(j jVar) {
        if (jVar != null) {
            this.f48153a.edit().putString("version", jVar.c()).apply();
        }
    }

    public void d(JSONObject jSONObject) {
        j a2;
        if (jSONObject == null || (a2 = j.a(jSONObject)) == null) {
            return;
        }
        d.a.l0.n.c.b().D(a2);
    }
}
