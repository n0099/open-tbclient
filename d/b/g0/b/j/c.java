package d.b.g0.b.j;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f47702a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f47702a == null) {
                f47702a = new b();
            }
            bVar = f47702a;
        }
        return bVar;
    }
}
