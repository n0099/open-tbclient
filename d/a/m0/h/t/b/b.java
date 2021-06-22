package d.a.m0.h.t.b;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f51459a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f51459a == null) {
                f51459a = new a();
            }
            aVar = f51459a;
        }
        return aVar;
    }
}
