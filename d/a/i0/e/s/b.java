package d.a.i0.e.s;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46445a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46445a == null) {
                f46445a = new a();
            }
            aVar = f46445a;
        }
        return aVar;
    }
}
