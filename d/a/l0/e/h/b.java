package d.a.l0.e.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50210a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50210a == null) {
                f50210a = new a();
            }
            aVar = f50210a;
        }
        return aVar;
    }
}
