package d.e.a.a.b;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicLong f66933a = new AtomicLong(999);

    public static long a() {
        if (0 == f66933a.incrementAndGet()) {
            f66933a.set(999L);
        }
        return f66933a.get();
    }

    public static void b(long j) {
        if (0 == j) {
            j = 999;
        }
        f66933a.set(j);
    }
}
