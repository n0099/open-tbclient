package d.a.c.c.j;
/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: c  reason: collision with root package name */
    public static c f42063c;

    public c() {
        this.f42064a = new e(20000, 10000, 5000);
        this.f42065b = 3;
    }

    public static c c() {
        if (f42063c == null) {
            synchronized (c.class) {
                if (f42063c == null) {
                    f42063c = new c();
                }
            }
        }
        return f42063c;
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
        this.f42064a = new e(i2, i3, i4);
    }
}
