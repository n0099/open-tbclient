package d.a.n0.u.b.n;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f65015a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f65015a == null) {
                f65015a = new b();
            }
            bVar = f65015a;
        }
        return bVar;
    }
}
