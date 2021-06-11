package d.a.l0.b.n.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50080a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50080a == null) {
                f50080a = new a();
            }
            aVar = f50080a;
        }
        return aVar;
    }
}
