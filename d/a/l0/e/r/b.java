package d.a.l0.e.r;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46620a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46620a == null) {
                f46620a = new a();
            }
            aVar = f46620a;
        }
        return aVar;
    }
}
