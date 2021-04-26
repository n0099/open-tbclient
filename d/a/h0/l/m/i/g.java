package d.a.h0.l.m.i;

import d.a.h0.p.i;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public static volatile g f47270b;

    /* renamed from: a  reason: collision with root package name */
    public b f47271a = new b();

    /* loaded from: classes3.dex */
    public static class b extends i {
        public b() {
            super("swan_preload_package");
        }
    }

    public static g a() {
        if (f47270b == null) {
            synchronized (g.class) {
                if (f47270b == null) {
                    f47270b = new g();
                }
            }
        }
        return f47270b;
    }

    public String b() {
        return this.f47271a.getString("version", "0");
    }

    public void c(f fVar) {
        if (fVar != null) {
            this.f47271a.edit().putString("version", fVar.c()).apply();
        }
    }

    public void d(JSONObject jSONObject) {
        f a2;
        if (jSONObject == null || (a2 = f.a(jSONObject)) == null) {
            return;
        }
        d.a.h0.l.f.b().A(a2);
    }
}
