package d.b.g0.b.m.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47443a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47443a == null) {
                f47443a = new a();
            }
            aVar = f47443a;
        }
        return aVar;
    }
}
