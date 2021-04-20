package d.b.i0.a1.g;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile List<Long> f52722a = new ArrayList();

    public static void a(long j) {
        if (f52722a.size() > 300) {
            f52722a.remove(0);
        }
        f52722a.add(Long.valueOf(j));
    }

    public static boolean b(long j) {
        return f52722a.contains(Long.valueOf(j));
    }
}
