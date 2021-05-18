package d.a.i0.e.p;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46400a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46400a == null) {
                f46400a = new a();
            }
            aVar = f46400a;
        }
        return aVar;
    }
}
