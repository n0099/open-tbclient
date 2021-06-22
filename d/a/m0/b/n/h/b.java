package d.a.m0.b.n.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50188a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50188a == null) {
                f50188a = new a();
            }
            aVar = f50188a;
        }
        return aVar;
    }
}
