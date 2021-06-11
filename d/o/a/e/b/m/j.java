package d.o.a.e.b.m;

import d.o.a.e.b.g.r;
/* loaded from: classes7.dex */
public class j implements r {
    @Override // d.o.a.e.b.g.r
    public long a(int i2, int i3) {
        if (i2 == 1) {
            return 3000L;
        }
        if (i2 == 2) {
            return 15000L;
        }
        if (i2 == 3) {
            return 30000L;
        }
        return i2 > 3 ? 300000L : 0L;
    }
}
