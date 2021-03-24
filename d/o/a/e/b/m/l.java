package d.o.a.e.b.m;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f67156a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f67157b;

    public static d.o.a.e.b.g.m a(boolean z) {
        if (z) {
            if (f67157b == null) {
                synchronized (l.class) {
                    if (f67157b == null) {
                        f67157b = new n();
                    }
                }
            }
            return f67157b;
        }
        if (f67156a == null) {
            synchronized (l.class) {
                if (f67156a == null) {
                    f67156a = new o();
                }
            }
        }
        return f67156a;
    }
}
