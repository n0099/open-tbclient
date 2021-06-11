package d.a.l0.f.j.m;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50547a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50547a == null) {
                f50547a = new a();
            }
            aVar = f50547a;
        }
        return aVar;
    }
}
