package d.c.d.b.h;

import d.c.d.b.h.j;
import d.c.d.b.l;
/* loaded from: classes5.dex */
public class d {
    public static long a(int i) {
        String[] k = l.e.k("/proc/self/task/" + i + "/stat");
        if (k == null) {
            return -1L;
        }
        return (Long.parseLong(k[11]) * j.a.a()) + (Long.parseLong(k[12]) * j.a.a());
    }
}
