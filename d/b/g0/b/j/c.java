package d.b.g0.b.j;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f47310a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f47310a == null) {
                f47310a = new b();
            }
            bVar = f47310a;
        }
        return bVar;
    }
}
