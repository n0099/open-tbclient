package d.b.h0.a.h2;

import d.b.h0.a.i2.i;
import d.b.h0.a.k;
import d.b.h0.g.i0.f.e;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f45336a;

    static {
        boolean z = k.f45772a;
        f45336a = 0;
    }

    public static int a() {
        return f45336a;
    }

    public static void b(int i, int i2) {
        d.b.h0.a.l0.f.a.d().e(i, i2);
        i.j();
        if (i == 0) {
            f45336a = 2;
        } else if (i2 > i) {
            f45336a = 1;
            d.b.h0.g.l.k.c();
            e.a.a();
        }
    }
}
