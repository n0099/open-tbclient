package d.o.a.e.b.m;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f71189a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f71190b;

    public static d.o.a.e.b.g.m a(boolean z) {
        if (z) {
            if (f71190b == null) {
                synchronized (l.class) {
                    if (f71190b == null) {
                        f71190b = new n();
                    }
                }
            }
            return f71190b;
        }
        if (f71189a == null) {
            synchronized (l.class) {
                if (f71189a == null) {
                    f71189a = new o();
                }
            }
        }
        return f71189a;
    }
}
