package d.a.i0.e.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46351a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46351a == null) {
                f46351a = new a();
            }
            aVar = f46351a;
        }
        return aVar;
    }
}
