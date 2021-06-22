package d.a.m0.a.n0.j;

import d.a.m0.a.e0.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f47401a;

    public static c a() {
        if (f47401a == null) {
            synchronized (c.class) {
                if (f47401a == null) {
                    f47401a = new c();
                }
            }
        }
        return f47401a;
    }

    public int b(int i2) {
        return d.a.m0.a.n0.j.e.a.a(i2);
    }

    public void c() {
        d.h("SwanRecoveryManager", "RecoverPlatform");
        d.a.m0.a.n0.j.f.a aVar = new d.a.m0.a.n0.j.f.a();
        aVar.f47410a = 1;
        a.a(aVar);
    }
}
