package d.b.g0.d.j.b;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f47527a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f47527a == null) {
                f47527a = new b();
            }
            bVar = f47527a;
        }
        return bVar;
    }
}
