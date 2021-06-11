package d.a.v.e;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile int f68432b;

    /* renamed from: a  reason: collision with root package name */
    public int f68433a = 0;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f68432b < 1000000) {
                f68432b = 1000000;
            }
            bVar = new b();
            bVar.f68433a = f68432b;
            f68432b++;
        }
        return bVar;
    }

    public int b() {
        return this.f68433a;
    }
}
