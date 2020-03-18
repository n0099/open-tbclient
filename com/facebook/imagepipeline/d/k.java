package com.facebook.imagepipeline.d;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes13.dex */
public class k implements ThreadFactory {
    private final int lUS;
    private final boolean lUT;
    private final AtomicInteger lUU = new AtomicInteger(1);
    private final String mPrefix;

    public k(int i, String str, boolean z) {
        this.lUS = i;
        this.mPrefix = str;
        this.lUT = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.d.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.lUS);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.lUT) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.lUU.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
