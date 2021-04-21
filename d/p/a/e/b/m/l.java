package d.p.a.e.b.m;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d.p.a.e.b.g.m f68301a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.p.a.e.b.g.m f68302b;

    public static d.p.a.e.b.g.m a(boolean z) {
        if (z) {
            if (f68302b == null) {
                synchronized (l.class) {
                    if (f68302b == null) {
                        f68302b = new n();
                    }
                }
            }
            return f68302b;
        }
        if (f68301a == null) {
            synchronized (l.class) {
                if (f68301a == null) {
                    f68301a = new o();
                }
            }
        }
        return f68301a;
    }
}
