package d.a.i0.w.w;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f49999b;

    /* renamed from: a  reason: collision with root package name */
    public int f50000a = 0;

    public static a a() {
        if (f49999b == null) {
            synchronized (a.class) {
                if (f49999b == null) {
                    f49999b = new a();
                }
            }
        }
        return f49999b;
    }

    public int b() {
        return this.f50000a;
    }

    public void c(int i2) {
        this.f50000a = i2;
    }
}
