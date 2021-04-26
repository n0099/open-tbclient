package d.a.j0.e1.o;

import d.a.c.c.j.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f53763b;

    /* renamed from: a  reason: collision with root package name */
    public e f53764a;

    public b() {
        this.f53764a = null;
        this.f53764a = new e(1000, 1000, 1000);
    }

    public static b a() {
        if (f53763b == null) {
            synchronized (b.class) {
                if (f53763b == null) {
                    f53763b = new b();
                }
            }
        }
        return f53763b;
    }

    public e b() {
        return this.f53764a;
    }
}
