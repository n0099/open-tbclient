package d.o.a.e.b.m;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f67403a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f67404b;

    public static d.o.a.e.b.g.m a(boolean z) {
        if (z) {
            if (f67404b == null) {
                synchronized (l.class) {
                    if (f67404b == null) {
                        f67404b = new n();
                    }
                }
            }
            return f67404b;
        }
        if (f67403a == null) {
            synchronized (l.class) {
                if (f67403a == null) {
                    f67403a = new o();
                }
            }
        }
        return f67403a;
    }
}
