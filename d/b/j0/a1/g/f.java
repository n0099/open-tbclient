package d.b.j0.a1.g;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile List<Long> f53143a = new ArrayList();

    public static void a(long j) {
        if (f53143a.size() > 300) {
            f53143a.remove(0);
        }
        f53143a.add(Long.valueOf(j));
    }

    public static boolean b(long j) {
        return f53143a.contains(Long.valueOf(j));
    }
}
