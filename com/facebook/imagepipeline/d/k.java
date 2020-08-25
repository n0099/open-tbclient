package com.facebook.imagepipeline.d;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class k implements ThreadFactory {
    private final String mPrefix;
    private final int nvL;
    private final boolean nvM;
    private final AtomicInteger nvN = new AtomicInteger(1);

    public k(int i, String str, boolean z) {
        this.nvL = i;
        this.mPrefix = str;
        this.nvM = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.d.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.nvL);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.nvM) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.nvN.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
