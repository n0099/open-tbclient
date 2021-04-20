package d.b.g0.a.h2;

import d.b.g0.a.i2.i;
import d.b.g0.a.k;
import d.b.g0.g.i0.f.e;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f45007a;

    static {
        boolean z = k.f45443a;
        f45007a = 0;
    }

    public static int a() {
        return f45007a;
    }

    public static void b(int i, int i2) {
        d.b.g0.a.l0.f.a.d().e(i, i2);
        i.j();
        if (i == 0) {
            f45007a = 2;
        } else if (i2 > i) {
            f45007a = 1;
            d.b.g0.g.l.k.c();
            e.a.a();
        }
    }
}
