package d.a.t.e;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile int f63974b;

    /* renamed from: a  reason: collision with root package name */
    public int f63975a = 0;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f63974b < 1000000) {
                f63974b = 1000000;
            }
            bVar = new b();
            bVar.f63975a = f63974b;
            f63974b++;
        }
        return bVar;
    }

    public int b() {
        return this.f63975a;
    }
}
