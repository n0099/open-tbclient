package d.a.l0.h.m0;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47463a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47463a == null) {
                f47463a = new a();
            }
            aVar = f47463a;
        }
        return aVar;
    }
}
