package d.a.m0.e.s;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50403a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50403a == null) {
                f50403a = new a();
            }
            aVar = f50403a;
        }
        return aVar;
    }
}
