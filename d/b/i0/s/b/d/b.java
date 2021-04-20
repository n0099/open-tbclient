package d.b.i0.s.b.d;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61363a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61363a == null) {
                f61363a = new a();
            }
            aVar = f61363a;
        }
        return aVar;
    }
}
