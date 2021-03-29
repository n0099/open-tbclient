package d.b.i0.s.b.n;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f60117a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f60117a == null) {
                f60117a = new b();
            }
            bVar = f60117a;
        }
        return bVar;
    }
}
