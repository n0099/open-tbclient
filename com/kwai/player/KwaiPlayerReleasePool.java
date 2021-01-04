package com.kwai.player;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class KwaiPlayerReleasePool {
    private static final Executor mExecutor = new ThreadPoolExecutor(2, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwai.player.KwaiPlayerReleasePool.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "KwaiPlayerReleasePool");
        }
    });

    public static void submit(Runnable runnable) {
        mExecutor.execute(runnable);
    }
}
