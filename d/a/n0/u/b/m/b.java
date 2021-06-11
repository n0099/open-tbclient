package d.a.n0.u.b.m;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f65014a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f65014a == null) {
                f65014a = new a();
            }
            aVar = f65014a;
        }
        return aVar;
    }
}
