package d.a.m0.a.o1;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47715a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47715a == null) {
                f47715a = new a();
            }
            aVar = f47715a;
        }
        return aVar;
    }
}
