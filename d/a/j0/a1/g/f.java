package d.a.j0.a1.g;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile List<Long> f50857a = new ArrayList();

    public static void a(long j) {
        if (f50857a.size() > 300) {
            f50857a.remove(0);
        }
        f50857a.add(Long.valueOf(j));
    }

    public static boolean b(long j) {
        return f50857a.contains(Long.valueOf(j));
    }
}
