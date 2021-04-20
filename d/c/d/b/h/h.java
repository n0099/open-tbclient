package d.c.d.b.h;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<Long> f66711a = new AtomicReference<>(0L);

    public static void a(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 5) {
                return;
            }
            long longValue = f66711a.get().longValue();
            if (f66711a.compareAndSet(Long.valueOf(longValue), Long.valueOf(longValue | j))) {
                return;
            }
            i = i2;
        }
    }
}
