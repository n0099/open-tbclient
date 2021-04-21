package d.b.c.c.j;
/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: c  reason: collision with root package name */
    public static c f42308c;

    public c() {
        this.f42309a = new e(20000, 10000, 5000);
        this.f42310b = 3;
    }

    public static c c() {
        if (f42308c == null) {
            synchronized (c.class) {
                if (f42308c == null) {
                    f42308c = new c();
                }
            }
        }
        return f42308c;
    }

    public void d(int i, int i2, int i3) {
        if (i < 3000) {
            i = 3000;
        }
        if (i2 < 3000) {
            i2 = 3000;
        }
        if (i3 < 3000) {
            i3 = 3000;
        }
        this.f42309a = new e(i, i2, i3);
    }
}
