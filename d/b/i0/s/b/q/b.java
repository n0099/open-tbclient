package d.b.i0.s.b.q;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60119a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60119a == null) {
                f60119a = new a();
            }
            aVar = f60119a;
        }
        return aVar;
    }
}
