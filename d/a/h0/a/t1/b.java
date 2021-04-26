package d.a.h0.a.t1;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f44353a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f44353a == null) {
                f44353a = new a();
            }
            aVar = f44353a;
        }
        return aVar;
    }
}
