package d.a.o0.u.b.m;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f65139a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f65139a == null) {
                f65139a = new a();
            }
            aVar = f65139a;
        }
        return aVar;
    }
}
