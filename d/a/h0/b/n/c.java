package d.a.h0.b.n;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f45653a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f45653a == null) {
                f45653a = new b();
            }
            bVar = f45653a;
        }
        return bVar;
    }
}
