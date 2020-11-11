package com.facebook.imagepipeline.d;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes12.dex */
public class k implements ThreadFactory {
    private final AtomicInteger caB = new AtomicInteger(1);
    private final int caD;
    private final String mPrefix;
    private final boolean oWe;

    public k(int i, String str, boolean z) {
        this.caD = i;
        this.mPrefix = str;
        this.oWe = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.d.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.caD);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.oWe) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.caB.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
