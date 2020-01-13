package com.facebook.imagepipeline.d;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes12.dex */
public class k implements ThreadFactory {
    private final int lSn;
    private final boolean lSo;
    private final AtomicInteger lSp = new AtomicInteger(1);
    private final String mPrefix;

    public k(int i, String str, boolean z) {
        this.lSn = i;
        this.mPrefix = str;
        this.lSo = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.d.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.lSn);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        };
        if (this.lSo) {
            str = this.mPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.lSp.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }
}
