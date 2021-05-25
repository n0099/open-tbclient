package d.a.l0.b.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f46272a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f46272a == null) {
                f46272a = new b();
            }
            bVar = f46272a;
        }
        return bVar;
    }
}
