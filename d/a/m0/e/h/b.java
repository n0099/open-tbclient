package d.a.m0.e.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50318a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50318a == null) {
                f50318a = new a();
            }
            aVar = f50318a;
        }
        return aVar;
    }
}
