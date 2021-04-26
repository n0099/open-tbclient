package d.a.c.c.j;
/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: c  reason: collision with root package name */
    public static c f39501c;

    public c() {
        this.f39502a = new e(20000, 10000, 5000);
        this.f39503b = 3;
    }

    public static c c() {
        if (f39501c == null) {
            synchronized (c.class) {
                if (f39501c == null) {
                    f39501c = new c();
                }
            }
        }
        return f39501c;
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
        this.f39502a = new e(i2, i3, i4);
    }
}
