package d.b.i0.e1.o;

import d.b.c.c.j.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f55477b;

    /* renamed from: a  reason: collision with root package name */
    public e f55478a;

    public b() {
        this.f55478a = null;
        this.f55478a = new e(1000, 1000, 1000);
    }

    public static b a() {
        if (f55477b == null) {
            synchronized (b.class) {
                if (f55477b == null) {
                    f55477b = new b();
                }
            }
        }
        return f55477b;
    }

    public e b() {
        return this.f55478a;
    }
}
