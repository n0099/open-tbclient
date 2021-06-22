package d.a.o0.f1.o;

import d.a.c.c.j.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f58474b;

    /* renamed from: a  reason: collision with root package name */
    public e f58475a;

    public b() {
        this.f58475a = null;
        this.f58475a = new e(1000, 1000, 1000);
    }

    public static b a() {
        if (f58474b == null) {
            synchronized (b.class) {
                if (f58474b == null) {
                    f58474b = new b();
                }
            }
        }
        return f58474b;
    }

    public e b() {
        return this.f58475a;
    }
}
