package d.a.l0.e.s;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46621a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46621a == null) {
                f46621a = new a();
            }
            aVar = f46621a;
        }
        return aVar;
    }
}
