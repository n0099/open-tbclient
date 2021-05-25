package d.b.d.b.h;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<Long> f65941a = new AtomicReference<>(0L);

    public static void a(long j) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 5) {
                return;
            }
            long longValue = f65941a.get().longValue();
            if (f65941a.compareAndSet(Long.valueOf(longValue), Long.valueOf(longValue | j))) {
                return;
            }
            i2 = i3;
        }
    }
}
