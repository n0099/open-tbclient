package d.b.i0.s.b.i;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f61393a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f61393a == null) {
                f61393a = new b();
            }
            bVar = f61393a;
        }
        return bVar;
    }
}
