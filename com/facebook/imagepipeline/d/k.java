package com.facebook.imagepipeline.d;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes13.dex */
public class k implements ThreadFactory {
    private final int lTm;
    private final boolean lTn;
    private final AtomicInteger lTo = new AtomicInteger(1);
    private final String mPrefix;

    public k(int i, String str, boolean z) {
        this.lTm = i;
        this.mPrefix = str;
        this.lTn = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.d.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.lTm);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.lTn) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.lTo.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
