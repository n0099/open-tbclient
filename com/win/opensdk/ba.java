package com.win.opensdk;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class ba {
    private static final BlockingQueue<Runnable> qae = new LinkedBlockingQueue(210);
    private static final ThreadFactory qaq = new ThreadFactory() { // from class: com.win.opensdk.ba.1
        private final AtomicInteger pZV = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "T#" + this.pZV.getAndIncrement());
        }
    };
    private static ba qar;
    private ThreadPoolExecutor qaj = new ThreadPoolExecutor(5, 60, 1, TimeUnit.SECONDS, qae, qaq);

    private ba() {
    }

    private static synchronized ba eGT() {
        ba baVar;
        synchronized (ba.class) {
            if (qar == null) {
                qar = new ba();
            }
            baVar = qar;
        }
        return baVar;
    }

    public static void D(Runnable runnable) {
        eGT().qaj.execute(runnable);
    }
}
