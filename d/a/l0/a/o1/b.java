package d.a.l0.a.o1;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f43931a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f43931a == null) {
                f43931a = new a();
            }
            aVar = f43931a;
        }
        return aVar;
    }
}
