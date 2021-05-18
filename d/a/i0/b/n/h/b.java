package d.a.i0.b.n.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46230a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46230a == null) {
                f46230a = new a();
            }
            aVar = f46230a;
        }
        return aVar;
    }
}
