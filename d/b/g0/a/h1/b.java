package d.b.g0.a.h1;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f45006a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f45006a == null) {
                f45006a = new a();
            }
            aVar = f45006a;
        }
        return aVar;
    }
}
