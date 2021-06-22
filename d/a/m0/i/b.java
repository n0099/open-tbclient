package d.a.m0.i;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f51608a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f51608a == null) {
                f51608a = new a();
            }
            aVar = f51608a;
        }
        return aVar;
    }
}
