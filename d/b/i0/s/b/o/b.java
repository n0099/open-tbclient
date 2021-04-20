package d.b.i0.s.b.o;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61419a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61419a == null) {
                f61419a = new a();
            }
            aVar = f61419a;
        }
        return aVar;
    }
}
