package d.a.c.e.n.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f39117b;

    /* renamed from: a  reason: collision with root package name */
    public long f39118a = 0;

    public static a b() {
        if (f39117b == null) {
            synchronized (a.class) {
                if (f39117b == null) {
                    f39117b = new a();
                }
            }
        }
        return f39117b;
    }

    public synchronized long a() {
        if (this.f39118a > 0) {
            this.f39118a++;
        } else {
            this.f39118a = System.currentTimeMillis();
        }
        return this.f39118a;
    }
}
