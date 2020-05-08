package com.facebook.imagepipeline.d;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes13.dex */
public class k implements ThreadFactory {
    private final AtomicInteger bjX = new AtomicInteger(1);
    private final int bjZ;
    private final String mPrefix;
    private final boolean mcJ;

    public k(int i, String str, boolean z) {
        this.bjZ = i;
        this.mPrefix = str;
        this.mcJ = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.d.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.bjZ);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.mcJ) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.bjX.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
