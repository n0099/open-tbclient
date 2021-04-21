package d.b.h0.a.h1;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f45335a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f45335a == null) {
                f45335a = new a();
            }
            aVar = f45335a;
        }
        return aVar;
    }
}
