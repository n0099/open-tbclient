package d.a.l0.i;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47826a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47826a == null) {
                f47826a = new a();
            }
            aVar = f47826a;
        }
        return aVar;
    }
}
