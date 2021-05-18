package d.a.i0.e.m.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46374a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46374a == null) {
                f46374a = new a();
            }
            aVar = f46374a;
        }
        return aVar;
    }
}
