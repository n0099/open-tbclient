package d.a.i0.n.j.i;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: b  reason: collision with root package name */
    public static volatile k f47976b;

    /* renamed from: a  reason: collision with root package name */
    public a f47977a = new a();

    /* loaded from: classes3.dex */
    public static class a extends d.a.i0.t.j {
        public a() {
            super("swan_preload_package");
        }
    }

    public static k a() {
        if (f47976b == null) {
            synchronized (k.class) {
                if (f47976b == null) {
                    f47976b = new k();
                }
            }
        }
        return f47976b;
    }

    public String b() {
        return this.f47977a.getString("version", "0");
    }

    public void c(j jVar) {
        if (jVar != null) {
            this.f47977a.edit().putString("version", jVar.c()).apply();
        }
    }

    public void d(JSONObject jSONObject) {
        j a2;
        if (jSONObject == null || (a2 = j.a(jSONObject)) == null) {
            return;
        }
        d.a.i0.n.c.b().D(a2);
    }
}
