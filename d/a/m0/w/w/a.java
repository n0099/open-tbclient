package d.a.m0.w.w;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f54568b;

    /* renamed from: a  reason: collision with root package name */
    public int f54569a = 0;

    public static a a() {
        if (f54568b == null) {
            synchronized (a.class) {
                if (f54568b == null) {
                    f54568b = new a();
                }
            }
        }
        return f54568b;
    }

    public int b() {
        return this.f54569a;
    }

    public void c(int i2) {
        this.f54569a = i2;
    }
}
