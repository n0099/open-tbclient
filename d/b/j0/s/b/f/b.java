package d.b.j0.s.b.f;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61800a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61800a == null) {
                f61800a = new a();
            }
            aVar = f61800a;
        }
        return aVar;
    }
}
