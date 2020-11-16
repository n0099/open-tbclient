package com.facebook.imagepipeline.d;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes17.dex */
public class k implements ThreadFactory {
    private final AtomicInteger bYQ = new AtomicInteger(1);
    private final int bYS;
    private final String mPrefix;
    private final boolean oXH;

    public k(int i, String str, boolean z) {
        this.bYS = i;
        this.mPrefix = str;
        this.oXH = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.d.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.bYS);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.oXH) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.bYQ.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
