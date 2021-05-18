package d.o.a.e.b.m;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f67360a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f67361b;

    public static d.o.a.e.b.g.m a(boolean z) {
        if (z) {
            if (f67361b == null) {
                synchronized (l.class) {
                    if (f67361b == null) {
                        f67361b = new n();
                    }
                }
            }
            return f67361b;
        }
        if (f67360a == null) {
            synchronized (l.class) {
                if (f67360a == null) {
                    f67360a = new o();
                }
            }
        }
        return f67360a;
    }
}
