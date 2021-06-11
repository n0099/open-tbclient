package d.a.n0.u.b.k;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f65012a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f65012a == null) {
                f65012a = new b();
            }
            bVar = f65012a;
        }
        return bVar;
    }
}
