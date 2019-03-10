package com.facebook.imagepipeline.d;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes2.dex */
public class k implements ThreadFactory {
    private final int jIm;

    public k(int i) {
        this.jIm = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        return new Thread(new Runnable() { // from class: com.facebook.imagepipeline.d.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(k.this.jIm);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        });
    }
}
