package d.a.o0.u.b.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f65138a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f65138a == null) {
                f65138a = new a();
            }
            aVar = f65138a;
        }
        return aVar;
    }
}
