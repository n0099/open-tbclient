package com.meizu.cloud.pushsdk.networking.a;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes3.dex */
public class f implements ThreadFactory {
    private final int a;

    public f(int i) {
        this.a = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        return new Thread(new Runnable() { // from class: com.meizu.cloud.pushsdk.networking.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(f.this.a);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        });
    }
}
