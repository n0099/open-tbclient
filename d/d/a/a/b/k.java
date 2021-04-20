package d.d.a.a.b;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicLong f66786a = new AtomicLong(999);

    public static long a() {
        if (0 == f66786a.incrementAndGet()) {
            f66786a.set(999L);
        }
        return f66786a.get();
    }

    public static void b(long j) {
        if (0 == j) {
            j = 999;
        }
        f66786a.set(j);
    }
}
