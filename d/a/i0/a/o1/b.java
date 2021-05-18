package d.a.i0.a.o1;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f43757a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f43757a == null) {
                f43757a = new a();
            }
            aVar = f43757a;
        }
        return aVar;
    }
}
