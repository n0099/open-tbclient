package d.b.g0.l.m.i;

import d.b.g0.p.i;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public static volatile g f49035b;

    /* renamed from: a  reason: collision with root package name */
    public b f49036a = new b();

    /* loaded from: classes3.dex */
    public static class b extends i {
        public b() {
            super("swan_preload_package");
        }
    }

    public static g a() {
        if (f49035b == null) {
            synchronized (g.class) {
                if (f49035b == null) {
                    f49035b = new g();
                }
            }
        }
        return f49035b;
    }

    public String b() {
        return this.f49036a.getString("version", "0");
    }

    public void c(f fVar) {
        if (fVar != null) {
            this.f49036a.edit().putString("version", fVar.c()).apply();
        }
    }

    public void d(JSONObject jSONObject) {
        f a2;
        if (jSONObject == null || (a2 = f.a(jSONObject)) == null) {
            return;
        }
        d.b.g0.l.f.b().v(a2);
    }
}
