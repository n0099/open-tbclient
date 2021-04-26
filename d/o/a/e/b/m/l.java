package d.o.a.e.b.m;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f66674a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f66675b;

    public static d.o.a.e.b.g.m a(boolean z) {
        if (z) {
            if (f66675b == null) {
                synchronized (l.class) {
                    if (f66675b == null) {
                        f66675b = new n();
                    }
                }
            }
            return f66675b;
        }
        if (f66674a == null) {
            synchronized (l.class) {
                if (f66674a == null) {
                    f66674a = new o();
                }
            }
        }
        return f66674a;
    }
}
