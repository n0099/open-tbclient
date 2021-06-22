package d.a.n0.w.w;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f54675b;

    /* renamed from: a  reason: collision with root package name */
    public int f54676a = 0;

    public static a a() {
        if (f54675b == null) {
            synchronized (a.class) {
                if (f54675b == null) {
                    f54675b = new a();
                }
            }
        }
        return f54675b;
    }

    public int b() {
        return this.f54676a;
    }

    public void c(int i2) {
        this.f54676a = i2;
    }
}
