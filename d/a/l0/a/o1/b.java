package d.a.l0.a.o1;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47607a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47607a == null) {
                f47607a = new a();
            }
            aVar = f47607a;
        }
        return aVar;
    }
}
