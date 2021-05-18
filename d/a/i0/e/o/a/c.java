package d.a.i0.e.o.a;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f46385a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f46385a == null) {
                f46385a = new b();
            }
            bVar = f46385a;
        }
        return bVar;
    }
}
