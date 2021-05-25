package d.a.c.c.j;
/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: c  reason: collision with root package name */
    public static c f38410c;

    public c() {
        this.f38411a = new e(20000, 10000, 5000);
        this.f38412b = 3;
    }

    public static c c() {
        if (f38410c == null) {
            synchronized (c.class) {
                if (f38410c == null) {
                    f38410c = new c();
                }
            }
        }
        return f38410c;
    }

    public void d(int i2, int i3, int i4) {
        if (i2 < 3000) {
            i2 = 3000;
        }
        if (i3 < 3000) {
            i3 = 3000;
        }
        if (i4 < 3000) {
            i4 = 3000;
        }
        this.f38411a = new e(i2, i3, i4);
    }
}
