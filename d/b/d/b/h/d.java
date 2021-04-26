package d.b.d.b.h;

import d.b.d.b.h.j;
import d.b.d.b.l;
/* loaded from: classes5.dex */
public class d {
    public static long a(int i2) {
        String[] k = l.e.k("/proc/self/task/" + i2 + "/stat");
        if (k == null) {
            return -1L;
        }
        return (Long.parseLong(k[11]) * j.a.a()) + (Long.parseLong(k[12]) * j.a.a());
    }
}
