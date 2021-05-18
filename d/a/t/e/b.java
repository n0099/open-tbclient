package d.a.t.e;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile int f64661b;

    /* renamed from: a  reason: collision with root package name */
    public int f64662a = 0;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f64661b < 1000000) {
                f64661b = 1000000;
            }
            bVar = new b();
            bVar.f64662a = f64661b;
            f64661b++;
        }
        return bVar;
    }

    public int b() {
        return this.f64662a;
    }
}
