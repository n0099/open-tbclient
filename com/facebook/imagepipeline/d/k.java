package com.facebook.imagepipeline.d;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes12.dex */
public class k implements ThreadFactory {
    private final AtomicInteger bMu = new AtomicInteger(1);
    private final int bMw;
    private final String mPrefix;
    private final boolean nVt;

    public k(int i, String str, boolean z) {
        this.bMw = i;
        this.mPrefix = str;
        this.nVt = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.d.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.bMw);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.nVt) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.bMu.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
