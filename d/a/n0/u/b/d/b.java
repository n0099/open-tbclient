package d.a.n0.u.b.d;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61260a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61260a == null) {
                f61260a = new a();
            }
            aVar = f61260a;
        }
        return aVar;
    }
}
