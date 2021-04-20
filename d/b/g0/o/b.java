package d.b.g0.o;

import d.b.g0.p.i;
/* loaded from: classes3.dex */
public final class b extends i {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f49724d;

    public b() {
        super("aiapp_open_stat");
    }

    public static b f() {
        if (f49724d == null) {
            synchronized (b.class) {
                if (f49724d == null) {
                    f49724d = new b();
                }
            }
        }
        return f49724d;
    }
}
