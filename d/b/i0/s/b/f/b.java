package d.b.i0.s.b.f;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61379a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61379a == null) {
                f61379a = new a();
            }
            aVar = f61379a;
        }
        return aVar;
    }
}
