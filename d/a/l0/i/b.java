package d.a.l0.i;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f51500a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f51500a == null) {
                f51500a = new a();
            }
            aVar = f51500a;
        }
        return aVar;
    }
}
