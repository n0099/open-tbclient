package com.facebook.imagepipeline.d;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class k implements ThreadFactory {
    private final String mPrefix;
    private final int nwd;
    private final boolean nwe;
    private final AtomicInteger nwf = new AtomicInteger(1);

    public k(int i, String str, boolean z) {
        this.nwd = i;
        this.mPrefix = str;
        this.nwe = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.d.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.nwd);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.nwe) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.nwf.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
