package d.a.o0.u.b.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f65097a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f65097a == null) {
                f65097a = new a();
            }
            aVar = f65097a;
        }
        return aVar;
    }
}
