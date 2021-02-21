package com.win.opensdk;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class ba {
    private static final BlockingQueue<Runnable> qkI = new LinkedBlockingQueue(210);
    private static final ThreadFactory qkU = new ThreadFactory() { // from class: com.win.opensdk.ba.1
        private final AtomicInteger qkz = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "T#" + this.qkz.getAndIncrement());
        }
    };
    private static ba qkV;
    private ThreadPoolExecutor qkN = new ThreadPoolExecutor(5, 60, 1, TimeUnit.SECONDS, qkI, qkU);

    private ba() {
    }

    private static synchronized ba eJr() {
        ba baVar;
        synchronized (ba.class) {
            if (qkV == null) {
                qkV = new ba();
            }
            baVar = qkV;
        }
        return baVar;
    }

    public static void C(Runnable runnable) {
        eJr().qkN.execute(runnable);
    }
}
