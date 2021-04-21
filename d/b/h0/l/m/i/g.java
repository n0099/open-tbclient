package d.b.h0.l.m.i;

import d.b.h0.p.i;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public static volatile g f49756b;

    /* renamed from: a  reason: collision with root package name */
    public b f49757a = new b();

    /* loaded from: classes3.dex */
    public static class b extends i {
        public b() {
            super("swan_preload_package");
        }
    }

    public static g a() {
        if (f49756b == null) {
            synchronized (g.class) {
                if (f49756b == null) {
                    f49756b = new g();
                }
            }
        }
        return f49756b;
    }

    public String b() {
        return this.f49757a.getString("version", "0");
    }

    public void c(f fVar) {
        if (fVar != null) {
            this.f49757a.edit().putString("version", fVar.c()).apply();
        }
    }

    public void d(JSONObject jSONObject) {
        f a2;
        if (jSONObject == null || (a2 = f.a(jSONObject)) == null) {
            return;
        }
        d.b.h0.l.f.b().v(a2);
    }
}
