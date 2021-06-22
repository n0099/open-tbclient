package d.a.v.e;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile int f68536b;

    /* renamed from: a  reason: collision with root package name */
    public int f68537a = 0;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f68536b < 1000000) {
                f68536b = 1000000;
            }
            bVar = new b();
            bVar.f68537a = f68536b;
            f68536b++;
        }
        return bVar;
    }

    public int b() {
        return this.f68537a;
    }
}
