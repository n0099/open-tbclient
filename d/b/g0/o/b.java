package d.b.g0.o;

import d.b.g0.p.i;
/* loaded from: classes3.dex */
public final class b extends i {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f49332d;

    public b() {
        super("aiapp_open_stat");
    }

    public static b f() {
        if (f49332d == null) {
            synchronized (b.class) {
                if (f49332d == null) {
                    f49332d = new b();
                }
            }
        }
        return f49332d;
    }
}
