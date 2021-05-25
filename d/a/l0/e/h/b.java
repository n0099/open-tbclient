package d.a.l0.e.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46536a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46536a == null) {
                f46536a = new a();
            }
            aVar = f46536a;
        }
        return aVar;
    }
}
