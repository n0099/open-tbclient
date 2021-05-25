package d.a.c.e.n.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f38781b;

    /* renamed from: a  reason: collision with root package name */
    public long f38782a = 0;

    public static a b() {
        if (f38781b == null) {
            synchronized (a.class) {
                if (f38781b == null) {
                    f38781b = new a();
                }
            }
        }
        return f38781b;
    }

    public synchronized long a() {
        if (this.f38782a > 0) {
            this.f38782a++;
        } else {
            this.f38782a = System.currentTimeMillis();
        }
        return this.f38782a;
    }
}
