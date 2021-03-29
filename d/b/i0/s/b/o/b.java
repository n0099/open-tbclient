package d.b.i0.s.b.o;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60118a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60118a == null) {
                f60118a = new a();
            }
            aVar = f60118a;
        }
        return aVar;
    }
}
