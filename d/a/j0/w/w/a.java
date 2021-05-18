package d.a.j0.w.w;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f50818b;

    /* renamed from: a  reason: collision with root package name */
    public int f50819a = 0;

    public static a a() {
        if (f50818b == null) {
            synchronized (a.class) {
                if (f50818b == null) {
                    f50818b = new a();
                }
            }
        }
        return f50818b;
    }

    public int b() {
        return this.f50819a;
    }

    public void c(int i2) {
        this.f50819a = i2;
    }
}
