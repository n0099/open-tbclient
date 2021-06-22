package d.a.o0.u.b.d;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f65094a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f65094a == null) {
                f65094a = new a();
            }
            aVar = f65094a;
        }
        return aVar;
    }
}
