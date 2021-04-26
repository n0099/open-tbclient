package d.a.h0.o;

import d.a.h0.p.i;
/* loaded from: classes3.dex */
public final class b extends i {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f47585d;

    public b() {
        super("aiapp_open_stat");
    }

    public static b f() {
        if (f47585d == null) {
            synchronized (b.class) {
                if (f47585d == null) {
                    f47585d = new b();
                }
            }
        }
        return f47585d;
    }
}
