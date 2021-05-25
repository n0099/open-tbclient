package d.a.n0.f1.o;

import d.a.c.c.j.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f54660b;

    /* renamed from: a  reason: collision with root package name */
    public e f54661a;

    public b() {
        this.f54661a = null;
        this.f54661a = new e(1000, 1000, 1000);
    }

    public static b a() {
        if (f54660b == null) {
            synchronized (b.class) {
                if (f54660b == null) {
                    f54660b = new b();
                }
            }
        }
        return f54660b;
    }

    public e b() {
        return this.f54661a;
    }
}
