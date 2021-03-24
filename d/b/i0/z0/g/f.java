package d.b.i0.z0.g;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile List<Long> f63102a = new ArrayList();

    public static void a(long j) {
        if (f63102a.size() > 300) {
            f63102a.remove(0);
        }
        f63102a.add(Long.valueOf(j));
    }

    public static boolean b(long j) {
        return f63102a.contains(Long.valueOf(j));
    }
}
