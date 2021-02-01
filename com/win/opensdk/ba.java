package com.win.opensdk;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class ba {
    private static final BlockingQueue<Runnable> qki = new LinkedBlockingQueue(210);
    private static final ThreadFactory qku = new ThreadFactory() { // from class: com.win.opensdk.ba.1
        private final AtomicInteger qjZ = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "T#" + this.qjZ.getAndIncrement());
        }
    };
    private static ba qkv;
    private ThreadPoolExecutor qkn = new ThreadPoolExecutor(5, 60, 1, TimeUnit.SECONDS, qki, qku);

    private ba() {
    }

    private static synchronized ba eJj() {
        ba baVar;
        synchronized (ba.class) {
            if (qkv == null) {
                qkv = new ba();
            }
            baVar = qkv;
        }
        return baVar;
    }

    public static void C(Runnable runnable) {
        eJj().qkn.execute(runnable);
    }
}
