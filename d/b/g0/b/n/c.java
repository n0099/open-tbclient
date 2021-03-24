package d.b.g0.b.n;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f47482a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f47482a == null) {
                f47482a = new b();
            }
            bVar = f47482a;
        }
        return bVar;
    }
}
