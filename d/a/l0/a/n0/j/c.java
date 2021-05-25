package d.a.l0.a.n0.j;

import d.a.l0.a.e0.d;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f43617a;

    public static c a() {
        if (f43617a == null) {
            synchronized (c.class) {
                if (f43617a == null) {
                    f43617a = new c();
                }
            }
        }
        return f43617a;
    }

    public int b(int i2) {
        return d.a.l0.a.n0.j.e.a.a(i2);
    }

    public void c() {
        d.h("SwanRecoveryManager", "RecoverPlatform");
        d.a.l0.a.n0.j.f.a aVar = new d.a.l0.a.n0.j.f.a();
        aVar.f43626a = 1;
        a.a(aVar);
    }
}
