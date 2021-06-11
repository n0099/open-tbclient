package d.a.n0.f1.o;

import d.a.c.c.j.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f58349b;

    /* renamed from: a  reason: collision with root package name */
    public e f58350a;

    public b() {
        this.f58350a = null;
        this.f58350a = new e(1000, 1000, 1000);
    }

    public static b a() {
        if (f58349b == null) {
            synchronized (b.class) {
                if (f58349b == null) {
                    f58349b = new b();
                }
            }
        }
        return f58349b;
    }

    public e b() {
        return this.f58350a;
    }
}
