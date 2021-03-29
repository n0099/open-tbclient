package d.b.h0.w.w;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f51572b;

    /* renamed from: a  reason: collision with root package name */
    public int f51573a = 0;

    public static a a() {
        if (f51572b == null) {
            synchronized (a.class) {
                if (f51572b == null) {
                    f51572b = new a();
                }
            }
        }
        return f51572b;
    }

    public int b() {
        return this.f51573a;
    }

    public void c(int i) {
        this.f51573a = i;
    }
}
