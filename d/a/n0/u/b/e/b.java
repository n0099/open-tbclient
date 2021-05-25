package d.a.n0.u.b.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61263a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61263a == null) {
                f61263a = new a();
            }
            aVar = f61263a;
        }
        return aVar;
    }
}
