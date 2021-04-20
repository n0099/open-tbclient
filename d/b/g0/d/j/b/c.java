package d.b.g0.d.j.b;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f47919a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f47919a == null) {
                f47919a = new b();
            }
            bVar = f47919a;
        }
        return bVar;
    }
}
