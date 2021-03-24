package d.b.h0.w.w;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f51571b;

    /* renamed from: a  reason: collision with root package name */
    public int f51572a = 0;

    public static a a() {
        if (f51571b == null) {
            synchronized (a.class) {
                if (f51571b == null) {
                    f51571b = new a();
                }
            }
        }
        return f51571b;
    }

    public int b() {
        return this.f51572a;
    }

    public void c(int i) {
        this.f51572a = i;
    }
}
