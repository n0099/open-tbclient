package d.b.h0.b.m.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f48165a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f48165a == null) {
                f48165a = new a();
            }
            aVar = f48165a;
        }
        return aVar;
    }
}
