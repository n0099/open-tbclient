package d.d.a.a.b;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicLong f65343a = new AtomicLong(999);

    public static long a() {
        if (0 == f65343a.incrementAndGet()) {
            f65343a.set(999L);
        }
        return f65343a.get();
    }

    public static void b(long j) {
        if (0 == j) {
            j = 999;
        }
        f65343a.set(j);
    }
}
