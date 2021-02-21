package com.facebook.imagepipeline.c;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class k implements ThreadFactory {
    private final AtomicInteger clU = new AtomicInteger(1);
    private final String mPrefix;
    private final int mThreadPriority;
    private final boolean pJQ;

    public k(int i, String str, boolean z) {
        this.mThreadPriority = i;
        this.mPrefix = str;
        this.pJQ = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.c.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.mThreadPriority);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.pJQ) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.clU.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
