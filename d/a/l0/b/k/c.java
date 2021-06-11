package d.a.l0.b.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f49946a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f49946a == null) {
                f49946a = new b();
            }
            bVar = f49946a;
        }
        return bVar;
    }
}
