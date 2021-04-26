package d.a.c.e.n.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f39872b;

    /* renamed from: a  reason: collision with root package name */
    public long f39873a = 0;

    public static a b() {
        if (f39872b == null) {
            synchronized (a.class) {
                if (f39872b == null) {
                    f39872b = new a();
                }
            }
        }
        return f39872b;
    }

    public synchronized long a() {
        if (this.f39873a > 0) {
            this.f39873a++;
        } else {
            this.f39873a = System.currentTimeMillis();
        }
        return this.f39873a;
    }
}
