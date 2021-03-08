package com.win.opensdk.bridge.async;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes14.dex */
public class AsyncTaskThreadFactory implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread thread = new Thread(new Runnable(this) { // from class: com.win.opensdk.bridge.async.AsyncTaskThreadFactory.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                runnable.run();
            }
        }, "JsBridge AsyncTaskExecutor");
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
