package d.a.c.e.n.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f42537b;

    /* renamed from: a  reason: collision with root package name */
    public long f42538a = 0;

    public static a b() {
        if (f42537b == null) {
            synchronized (a.class) {
                if (f42537b == null) {
                    f42537b = new a();
                }
            }
        }
        return f42537b;
    }

    public synchronized long a() {
        if (this.f42538a > 0) {
            this.f42538a++;
        } else {
            this.f42538a = System.currentTimeMillis();
        }
        return this.f42538a;
    }
}
