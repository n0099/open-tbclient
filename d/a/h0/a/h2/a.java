package d.a.h0.a.h2;

import d.a.h0.a.i2.i;
import d.a.h0.a.k;
import d.a.h0.g.i0.f.e;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f42651a;

    static {
        boolean z = k.f43101a;
        f42651a = 0;
    }

    public static int a() {
        return f42651a;
    }

    public static void b(int i2, int i3) {
        d.a.h0.a.l0.f.a.d().e(i2, i3);
        i.j();
        if (i2 == 0) {
            f42651a = 2;
        } else if (i3 > i2) {
            f42651a = 1;
            d.a.h0.g.l.k.c();
            e.a.a();
        }
    }
}
