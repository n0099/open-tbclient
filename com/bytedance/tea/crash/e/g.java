package com.bytedance.tea.crash.e;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<Long> f7948a = new AtomicReference<>(0L);

    public static void a(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i < 5) {
                long longValue = f7948a.get().longValue();
                if (f7948a.compareAndSet(Long.valueOf(longValue), Long.valueOf(longValue | j))) {
                    return;
                }
                i = i2;
            } else {
                return;
            }
        }
    }
}
