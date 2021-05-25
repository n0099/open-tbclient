package d.a.l0.e.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46527a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46527a == null) {
                f46527a = new a();
            }
            aVar = f46527a;
        }
        return aVar;
    }
}
