package d.b.j0.e1.o;

import d.b.c.c.j.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f55898b;

    /* renamed from: a  reason: collision with root package name */
    public e f55899a;

    public b() {
        this.f55899a = null;
        this.f55899a = new e(1000, 1000, 1000);
    }

    public static b a() {
        if (f55898b == null) {
            synchronized (b.class) {
                if (f55898b == null) {
                    f55898b = new b();
                }
            }
        }
        return f55898b;
    }

    public e b() {
        return this.f55899a;
    }
}
