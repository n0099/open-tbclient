package d.a.l0.b.o;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f50122a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f50122a == null) {
                f50122a = new b();
            }
            bVar = f50122a;
        }
        return bVar;
    }
}
