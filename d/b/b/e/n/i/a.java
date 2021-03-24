package d.b.b.e.n.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f41928b;

    /* renamed from: a  reason: collision with root package name */
    public long f41929a = 0;

    public static a b() {
        if (f41928b == null) {
            synchronized (a.class) {
                if (f41928b == null) {
                    f41928b = new a();
                }
            }
        }
        return f41928b;
    }

    public synchronized long a() {
        if (this.f41929a > 0) {
            this.f41929a++;
        } else {
            this.f41929a = System.currentTimeMillis();
        }
        return this.f41929a;
    }
}
