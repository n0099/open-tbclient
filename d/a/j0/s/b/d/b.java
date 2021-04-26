package d.a.j0.s.b.d;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f59942a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f59942a == null) {
                f59942a = new a();
            }
            aVar = f59942a;
        }
        return aVar;
    }
}
