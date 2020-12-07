package com.facebook.imagepipeline.c;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class k implements ThreadFactory {
    private final AtomicInteger cfq = new AtomicInteger(1);
    private final int cfs;
    private final String mPrefix;
    private final boolean pmw;

    public k(int i, String str, boolean z) {
        this.cfs = i;
        this.mPrefix = str;
        this.pmw = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.c.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.cfs);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.pmw) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.cfq.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
