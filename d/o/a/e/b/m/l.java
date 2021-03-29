package d.o.a.e.b.m;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f67161a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f67162b;

    public static d.o.a.e.b.g.m a(boolean z) {
        if (z) {
            if (f67162b == null) {
                synchronized (l.class) {
                    if (f67162b == null) {
                        f67162b = new n();
                    }
                }
            }
            return f67162b;
        }
        if (f67161a == null) {
            synchronized (l.class) {
                if (f67161a == null) {
                    f67161a = new o();
                }
            }
        }
        return f67161a;
    }
}
