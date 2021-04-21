package d.b.h0.b.n;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f48204a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f48204a == null) {
                f48204a = new b();
            }
            bVar = f48204a;
        }
        return bVar;
    }
}
