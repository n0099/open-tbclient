package d.a.i0.b.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f46096a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f46096a == null) {
                f46096a = new b();
            }
            bVar = f46096a;
        }
        return bVar;
    }
}
