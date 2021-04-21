package d.b.h0.o;

import d.b.h0.p.i;
/* loaded from: classes3.dex */
public final class b extends i {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f50053d;

    public b() {
        super("aiapp_open_stat");
    }

    public static b f() {
        if (f50053d == null) {
            synchronized (b.class) {
                if (f50053d == null) {
                    f50053d = new b();
                }
            }
        }
        return f50053d;
    }
}
