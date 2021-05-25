package d.a.l0.e.o.a;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f46561a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f46561a == null) {
                f46561a = new b();
            }
            bVar = f46561a;
        }
        return bVar;
    }
}
