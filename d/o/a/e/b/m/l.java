package d.o.a.e.b.m;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f68154a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f68155b;

    public static d.o.a.e.b.g.m a(boolean z) {
        if (z) {
            if (f68155b == null) {
                synchronized (l.class) {
                    if (f68155b == null) {
                        f68155b = new n();
                    }
                }
            }
            return f68155b;
        }
        if (f68154a == null) {
            synchronized (l.class) {
                if (f68154a == null) {
                    f68154a = new o();
                }
            }
        }
        return f68154a;
    }
}
