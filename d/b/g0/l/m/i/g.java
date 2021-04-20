package d.b.g0.l.m.i;

import d.b.g0.p.i;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public static volatile g f49427b;

    /* renamed from: a  reason: collision with root package name */
    public b f49428a = new b();

    /* loaded from: classes3.dex */
    public static class b extends i {
        public b() {
            super("swan_preload_package");
        }
    }

    public static g a() {
        if (f49427b == null) {
            synchronized (g.class) {
                if (f49427b == null) {
                    f49427b = new g();
                }
            }
        }
        return f49427b;
    }

    public String b() {
        return this.f49428a.getString("version", "0");
    }

    public void c(f fVar) {
        if (fVar != null) {
            this.f49428a.edit().putString("version", fVar.c()).apply();
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
