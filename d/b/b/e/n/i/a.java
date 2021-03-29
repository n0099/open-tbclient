package d.b.b.e.n.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f41929b;

    /* renamed from: a  reason: collision with root package name */
    public long f41930a = 0;

    public static a b() {
        if (f41929b == null) {
            synchronized (a.class) {
                if (f41929b == null) {
                    f41929b = new a();
                }
            }
        }
        return f41929b;
    }

    public synchronized long a() {
        if (this.f41930a > 0) {
            this.f41930a++;
        } else {
            this.f41930a = System.currentTimeMillis();
        }
        return this.f41930a;
    }
}
