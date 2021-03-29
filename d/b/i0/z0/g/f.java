package d.b.i0.z0.g;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile List<Long> f63103a = new ArrayList();

    public static void a(long j) {
        if (f63103a.size() > 300) {
            f63103a.remove(0);
        }
        f63103a.add(Long.valueOf(j));
    }

    public static boolean b(long j) {
        return f63103a.contains(Long.valueOf(j));
    }
}
