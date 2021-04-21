package d.b.c.e.n.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f42666b;

    /* renamed from: a  reason: collision with root package name */
    public long f42667a = 0;

    public static a b() {
        if (f42666b == null) {
            synchronized (a.class) {
                if (f42666b == null) {
                    f42666b = new a();
                }
            }
        }
        return f42666b;
    }

    public synchronized long a() {
        if (this.f42667a > 0) {
            this.f42667a++;
        } else {
            this.f42667a = System.currentTimeMillis();
        }
        return this.f42667a;
    }
}
