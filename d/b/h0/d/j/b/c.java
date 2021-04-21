package d.b.h0.d.j.b;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f48248a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f48248a == null) {
                f48248a = new b();
            }
            bVar = f48248a;
        }
        return bVar;
    }
}
