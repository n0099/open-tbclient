package d.b.i0.s.b.q;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61421a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61421a == null) {
                f61421a = new a();
            }
            aVar = f61421a;
        }
        return aVar;
    }
}
