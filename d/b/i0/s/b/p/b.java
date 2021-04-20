package d.b.i0.s.b.p;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61420a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61420a == null) {
                f61420a = new a();
            }
            aVar = f61420a;
        }
        return aVar;
    }
}
