package d.a.l0.e.s;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50295a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50295a == null) {
                f50295a = new a();
            }
            aVar = f50295a;
        }
        return aVar;
    }
}
