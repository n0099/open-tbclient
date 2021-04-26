package d.a.h0.d.j.a.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f45694a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f45694a == null) {
                f45694a = new a();
            }
            aVar = f45694a;
        }
        return aVar;
    }
}
