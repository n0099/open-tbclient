package d.b.i0.s.b.f;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60077a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60077a == null) {
                f60077a = new a();
            }
            aVar = f60077a;
        }
        return aVar;
    }
}
