package d.a.n0.u.b.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f65013a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f65013a == null) {
                f65013a = new a();
            }
            aVar = f65013a;
        }
        return aVar;
    }
}
