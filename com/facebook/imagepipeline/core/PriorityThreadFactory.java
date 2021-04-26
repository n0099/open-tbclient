package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class PriorityThreadFactory implements ThreadFactory {
    public final boolean mAddThreadNumber;
    public final String mPrefix;
    public final AtomicInteger mThreadNumber;
    public final int mThreadPriority;

    public PriorityThreadFactory(int i2) {
        this(i2, "PriorityThreadFactory", true);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.core.PriorityThreadFactory.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(PriorityThreadFactory.this.mThreadPriority);
                } catch (Throwable unused) {
                }
                runnable.run();
            }
        };
        if (this.mAddThreadNumber) {
            str = this.mPrefix + "-" + this.mThreadNumber.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }

    public PriorityThreadFactory(int i2, String str, boolean z) {
        this.mThreadNumber = new AtomicInteger(1);
        this.mThreadPriority = i2;
        this.mPrefix = str;
        this.mAddThreadNumber = z;
    }
}
