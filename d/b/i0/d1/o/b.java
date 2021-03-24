package d.b.i0.d1.o;

import d.b.b.c.j.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f53954b;

    /* renamed from: a  reason: collision with root package name */
    public e f53955a;

    public b() {
        this.f53955a = null;
        this.f53955a = new e(1000, 1000, 1000);
    }

    public static b a() {
        if (f53954b == null) {
            synchronized (b.class) {
                if (f53954b == null) {
                    f53954b = new b();
                }
            }
        }
        return f53954b;
    }

    public e b() {
        return this.f53955a;
    }
}
