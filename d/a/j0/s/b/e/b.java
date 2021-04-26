package d.a.j0.s.b.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f59945a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f59945a == null) {
                f59945a = new a();
            }
            aVar = f59945a;
        }
        return aVar;
    }
}
