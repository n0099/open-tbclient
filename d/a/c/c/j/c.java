package d.a.c.c.j;
/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: c  reason: collision with root package name */
    public static c f38746c;

    public c() {
        this.f38747a = new e(20000, 10000, 5000);
        this.f38748b = 3;
    }

    public static c c() {
        if (f38746c == null) {
            synchronized (c.class) {
                if (f38746c == null) {
                    f38746c = new c();
                }
            }
        }
        return f38746c;
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
        this.f38747a = new e(i2, i3, i4);
    }
}
