package d.b.g0.a.h1;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f44614a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f44614a == null) {
                f44614a = new a();
            }
            aVar = f44614a;
        }
        return aVar;
    }
}
