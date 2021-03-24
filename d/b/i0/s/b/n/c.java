package d.b.i0.s.b.n;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f60116a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f60116a == null) {
                f60116a = new b();
            }
            bVar = f60116a;
        }
        return bVar;
    }
}
