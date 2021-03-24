package d.b.g0.d.j.a.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47522a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47522a == null) {
                f47522a = new a();
            }
            aVar = f47522a;
        }
        return aVar;
    }
}
