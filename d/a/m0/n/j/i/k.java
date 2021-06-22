package d.a.m0.n.j.i;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: b  reason: collision with root package name */
    public static volatile k f51934b;

    /* renamed from: a  reason: collision with root package name */
    public a f51935a = new a();

    /* loaded from: classes3.dex */
    public static class a extends d.a.m0.t.j {
        public a() {
            super("swan_preload_package");
        }
    }

    public static k a() {
        if (f51934b == null) {
            synchronized (k.class) {
                if (f51934b == null) {
                    f51934b = new k();
                }
            }
        }
        return f51934b;
    }

    public String b() {
        return this.f51935a.getString("version", "0");
    }

    public void c(j jVar) {
        if (jVar != null) {
            this.f51935a.edit().putString("version", jVar.c()).apply();
        }
    }

    public void d(JSONObject jSONObject) {
        j a2;
        if (jSONObject == null || (a2 = j.a(jSONObject)) == null) {
            return;
        }
        d.a.m0.n.c.b().D(a2);
    }
}
