package d.a.l0.e.m.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50224a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50224a == null) {
                f50224a = new a();
            }
            aVar = f50224a;
        }
        return aVar;
    }
}
