package d.b.i0.s.b.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61366a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61366a == null) {
                f61366a = new a();
            }
            aVar = f61366a;
        }
        return aVar;
    }
}
