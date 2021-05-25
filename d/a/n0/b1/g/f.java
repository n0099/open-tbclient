package d.a.n0.b1.g;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile List<Long> f51721a = new ArrayList();

    public static void a(long j) {
        if (f51721a.size() > 300) {
            f51721a.remove(0);
        }
        f51721a.add(Long.valueOf(j));
    }

    public static boolean b(long j) {
        return f51721a.contains(Long.valueOf(j));
    }
}
