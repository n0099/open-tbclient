package d.a.l0.b.n.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46406a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46406a == null) {
                f46406a = new a();
            }
            aVar = f46406a;
        }
        return aVar;
    }
}
