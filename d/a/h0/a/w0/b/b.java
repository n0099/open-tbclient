package d.a.h0.a.w0.b;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f45005a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f45005a == null) {
                f45005a = new a();
            }
            aVar = f45005a;
        }
        return aVar;
    }
}
