package d.b.i0.s.b.n;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f61418a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f61418a == null) {
                f61418a = new b();
            }
            bVar = f61418a;
        }
        return bVar;
    }
}
