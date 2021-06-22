package d.a.o0.b1.h;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile List<Long> f55529a = new ArrayList();

    public static void a(long j) {
        if (f55529a.size() > 300) {
            f55529a.remove(0);
        }
        f55529a.add(Long.valueOf(j));
    }

    public static boolean b(long j) {
        return f55529a.contains(Long.valueOf(j));
    }
}
