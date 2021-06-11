package d.a.l0.e.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50201a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50201a == null) {
                f50201a = new a();
            }
            aVar = f50201a;
        }
        return aVar;
    }
}
