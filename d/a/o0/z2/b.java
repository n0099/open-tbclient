package d.a.o0.z2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f67636a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f67636a == null) {
                f67636a = new a();
            }
            aVar = f67636a;
        }
        return aVar;
    }
}
