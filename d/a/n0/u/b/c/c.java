package d.a.n0.u.b.c;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f64968a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f64968a == null) {
                f64968a = new b();
            }
            bVar = f64968a;
        }
        return bVar;
    }
}
