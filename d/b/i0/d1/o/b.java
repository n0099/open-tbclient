package d.b.i0.d1.o;

import d.b.b.c.j.e;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f53955b;

    /* renamed from: a  reason: collision with root package name */
    public e f53956a;

    public b() {
        this.f53956a = null;
        this.f53956a = new e(1000, 1000, 1000);
    }

    public static b a() {
        if (f53955b == null) {
            synchronized (b.class) {
                if (f53955b == null) {
                    f53955b = new b();
                }
            }
        }
        return f53955b;
    }

    public e b() {
        return this.f53956a;
    }
}
