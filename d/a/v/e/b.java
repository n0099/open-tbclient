package d.a.v.e;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile int f64714b;

    /* renamed from: a  reason: collision with root package name */
    public int f64715a = 0;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f64714b < 1000000) {
                f64714b = 1000000;
            }
            bVar = new b();
            bVar.f64715a = f64714b;
            f64714b++;
        }
        return bVar;
    }

    public int b() {
        return this.f64715a;
    }
}
