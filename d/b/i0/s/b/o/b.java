package d.b.i0.s.b.o;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60117a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60117a == null) {
                f60117a = new a();
            }
            aVar = f60117a;
        }
        return aVar;
    }
}
