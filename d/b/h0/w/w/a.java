package d.b.h0.w.w;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f51990b;

    /* renamed from: a  reason: collision with root package name */
    public int f51991a = 0;

    public static a a() {
        if (f51990b == null) {
            synchronized (a.class) {
                if (f51990b == null) {
                    f51990b = new a();
                }
            }
        }
        return f51990b;
    }

    public int b() {
        return this.f51991a;
    }

    public void c(int i) {
        this.f51991a = i;
    }
}
