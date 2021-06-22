package d.a.m0.h.o;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f51289a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f51289a == null) {
                f51289a = new a();
            }
            aVar = f51289a;
        }
        return aVar;
    }
}
