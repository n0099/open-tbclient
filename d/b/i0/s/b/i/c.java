package d.b.i0.s.b.i;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f60091a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f60091a == null) {
                f60091a = new b();
            }
            bVar = f60091a;
        }
        return bVar;
    }
}
