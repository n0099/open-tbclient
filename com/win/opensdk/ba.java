package com.win.opensdk;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class ba {
    private static final BlockingQueue<Runnable> qad = new LinkedBlockingQueue(210);
    private static final ThreadFactory qap = new ThreadFactory() { // from class: com.win.opensdk.ba.1
        private final AtomicInteger pZU = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "T#" + this.pZU.getAndIncrement());
        }
    };
    private static ba qaq;
    private ThreadPoolExecutor qai = new ThreadPoolExecutor(5, 60, 1, TimeUnit.SECONDS, qad, qap);

    private ba() {
    }

    private static synchronized ba eGT() {
        ba baVar;
        synchronized (ba.class) {
            if (qaq == null) {
                qaq = new ba();
            }
            baVar = qaq;
        }
        return baVar;
    }

    public static void D(Runnable runnable) {
        eGT().qai.execute(runnable);
    }
}
