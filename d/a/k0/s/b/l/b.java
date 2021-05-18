package d.a.k0.s.b.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60731a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60731a == null) {
                f60731a = new a();
            }
            aVar = f60731a;
        }
        return aVar;
    }
}
