package d.a.i0.h.t.b;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47501a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47501a == null) {
                f47501a = new a();
            }
            aVar = f47501a;
        }
        return aVar;
    }
}
