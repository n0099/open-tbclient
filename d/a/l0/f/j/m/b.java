package d.a.l0.f.j.m;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46873a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46873a == null) {
                f46873a = new a();
            }
            aVar = f46873a;
        }
        return aVar;
    }
}
