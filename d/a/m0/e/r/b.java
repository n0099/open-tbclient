package d.a.m0.e.r;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50402a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50402a == null) {
                f50402a = new a();
            }
            aVar = f50402a;
        }
        return aVar;
    }
}
