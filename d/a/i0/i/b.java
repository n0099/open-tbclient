package d.a.i0.i;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47650a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47650a == null) {
                f47650a = new a();
            }
            aVar = f47650a;
        }
        return aVar;
    }
}
