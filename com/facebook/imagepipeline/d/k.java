package com.facebook.imagepipeline.d;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes13.dex */
public class k implements ThreadFactory {
    private final AtomicInteger bjS = new AtomicInteger(1);
    private final int bjU;
    private final String mPrefix;
    private final boolean mcF;

    public k(int i, String str, boolean z) {
        this.bjU = i;
        this.mPrefix = str;
        this.mcF = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.d.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.bjU);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.mcF) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.bjS.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
