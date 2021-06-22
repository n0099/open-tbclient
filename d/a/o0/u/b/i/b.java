package d.a.o0.u.b.i;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f65118a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f65118a == null) {
                f65118a = new a();
            }
            aVar = f65118a;
        }
        return aVar;
    }
}
