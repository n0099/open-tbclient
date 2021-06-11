package d.a.c.e.n.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f42434b;

    /* renamed from: a  reason: collision with root package name */
    public long f42435a = 0;

    public static a b() {
        if (f42434b == null) {
            synchronized (a.class) {
                if (f42434b == null) {
                    f42434b = new a();
                }
            }
        }
        return f42434b;
    }

    public synchronized long a() {
        if (this.f42435a > 0) {
            this.f42435a++;
        } else {
            this.f42435a = System.currentTimeMillis();
        }
        return this.f42435a;
    }
}
