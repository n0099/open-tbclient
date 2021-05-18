package d.a.i0.a.n0.j;

import d.a.i0.a.e0.d;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f43443a;

    public static c a() {
        if (f43443a == null) {
            synchronized (c.class) {
                if (f43443a == null) {
                    f43443a = new c();
                }
            }
        }
        return f43443a;
    }

    public int b(int i2) {
        return d.a.i0.a.n0.j.e.a.a(i2);
    }

    public void c() {
        d.h("SwanRecoveryManager", "RecoverPlatform");
        d.a.i0.a.n0.j.f.a aVar = new d.a.i0.a.n0.j.f.a();
        aVar.f43452a = 1;
        a.a(aVar);
    }
}
