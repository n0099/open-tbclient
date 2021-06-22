package d.o.a.e.b.m;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f71293a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.o.a.e.b.g.m f71294b;

    public static d.o.a.e.b.g.m a(boolean z) {
        if (z) {
            if (f71294b == null) {
                synchronized (l.class) {
                    if (f71294b == null) {
                        f71294b = new n();
                    }
                }
            }
            return f71294b;
        }
        if (f71293a == null) {
            synchronized (l.class) {
                if (f71293a == null) {
                    f71293a = new o();
                }
            }
        }
        return f71293a;
    }
}
