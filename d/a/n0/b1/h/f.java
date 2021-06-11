package d.a.n0.b1.h;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile List<Long> f55404a = new ArrayList();

    public static void a(long j) {
        if (f55404a.size() > 300) {
            f55404a.remove(0);
        }
        f55404a.add(Long.valueOf(j));
    }

    public static boolean b(long j) {
        return f55404a.contains(Long.valueOf(j));
    }
}
