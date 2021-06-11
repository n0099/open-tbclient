package d.a.l0.a.n0.j;

import d.a.l0.a.e0.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f47293a;

    public static c a() {
        if (f47293a == null) {
            synchronized (c.class) {
                if (f47293a == null) {
                    f47293a = new c();
                }
            }
        }
        return f47293a;
    }

    public int b(int i2) {
        return d.a.l0.a.n0.j.e.a.a(i2);
    }

    public void c() {
        d.h("SwanRecoveryManager", "RecoverPlatform");
        d.a.l0.a.n0.j.f.a aVar = new d.a.l0.a.n0.j.f.a();
        aVar.f47302a = 1;
        a.a(aVar);
    }
}
