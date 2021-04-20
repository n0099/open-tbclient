package d.b.i0.s.b.g.a;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61384a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61384a == null) {
                f61384a = new a();
            }
            aVar = f61384a;
        }
        return aVar;
    }
}
