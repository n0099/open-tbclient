package d.b.c.e.n.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f42426b;

    /* renamed from: a  reason: collision with root package name */
    public long f42427a = 0;

    public static a b() {
        if (f42426b == null) {
            synchronized (a.class) {
                if (f42426b == null) {
                    f42426b = new a();
                }
            }
        }
        return f42426b;
    }

    public synchronized long a() {
        if (this.f42427a > 0) {
            this.f42427a++;
        } else {
            this.f42427a = System.currentTimeMillis();
        }
        return this.f42427a;
    }
}
