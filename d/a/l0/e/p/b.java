package d.a.l0.e.p;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46576a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46576a == null) {
                f46576a = new a();
            }
            aVar = f46576a;
        }
        return aVar;
    }
}
