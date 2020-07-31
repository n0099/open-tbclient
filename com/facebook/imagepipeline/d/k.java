package com.facebook.imagepipeline.d;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class k implements ThreadFactory {
    private final String mPrefix;
    private final int nbT;
    private final boolean nbU;
    private final AtomicInteger nbV = new AtomicInteger(1);

    public k(int i, String str, boolean z) {
        this.nbT = i;
        this.mPrefix = str;
        this.nbU = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.d.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.nbT);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.nbU) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.nbV.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
