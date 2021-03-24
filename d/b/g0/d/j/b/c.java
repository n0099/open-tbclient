package d.b.g0.d.j.b;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f47526a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f47526a == null) {
                f47526a = new b();
            }
            bVar = f47526a;
        }
        return bVar;
    }
}
