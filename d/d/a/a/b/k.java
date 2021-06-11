package d.d.a.a.b;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicLong f69803a = new AtomicLong(999);

    public static long a() {
        if (0 == f69803a.incrementAndGet()) {
            f69803a.set(999L);
        }
        return f69803a.get();
    }

    public static void b(long j) {
        if (0 == j) {
            j = 999;
        }
        f69803a.set(j);
    }
}
