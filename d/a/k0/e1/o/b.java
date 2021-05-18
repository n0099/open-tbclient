package d.a.k0.e1.o;

import d.a.c.c.j.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f54470b;

    /* renamed from: a  reason: collision with root package name */
    public e f54471a;

    public b() {
        this.f54471a = null;
        this.f54471a = new e(1000, 1000, 1000);
    }

    public static b a() {
        if (f54470b == null) {
            synchronized (b.class) {
                if (f54470b == null) {
                    f54470b = new b();
                }
            }
        }
        return f54470b;
    }

    public e b() {
        return this.f54471a;
    }
}
