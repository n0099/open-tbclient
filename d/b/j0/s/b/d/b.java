package d.b.j0.s.b.d;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61784a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61784a == null) {
                f61784a = new a();
            }
            aVar = f61784a;
        }
        return aVar;
    }
}
