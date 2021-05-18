package d.a.i0.e.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46360a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46360a == null) {
                f46360a = new a();
            }
            aVar = f46360a;
        }
        return aVar;
    }
}
