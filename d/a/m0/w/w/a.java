package d.a.m0.w.w;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f50891b;

    /* renamed from: a  reason: collision with root package name */
    public int f50892a = 0;

    public static a a() {
        if (f50891b == null) {
            synchronized (a.class) {
                if (f50891b == null) {
                    f50891b = new a();
                }
            }
        }
        return f50891b;
    }

    public int b() {
        return this.f50892a;
    }

    public void c(int i2) {
        this.f50892a = i2;
    }
}
