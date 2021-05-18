package d.a.i0.f.j.m;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46697a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46697a == null) {
                f46697a = new a();
            }
            aVar = f46697a;
        }
        return aVar;
    }
}
