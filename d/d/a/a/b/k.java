package d.d.a.a.b;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicLong f65940a = new AtomicLong(999);

    public static long a() {
        if (0 == f65940a.incrementAndGet()) {
            f65940a.set(999L);
        }
        return f65940a.get();
    }

    public static void b(long j) {
        if (0 == j) {
            j = 999;
        }
        f65940a.set(j);
    }
}
