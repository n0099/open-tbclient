package com.win.opensdk;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public final class ba {
    private static final BlockingQueue<Runnable> qcW = new LinkedBlockingQueue(210);
    private static final ThreadFactory qdi = new ThreadFactory() { // from class: com.win.opensdk.ba.1
        private final AtomicInteger qcN = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "T#" + this.qcN.getAndIncrement());
        }
    };
    private static ba qdj;
    private ThreadPoolExecutor qdb = new ThreadPoolExecutor(5, 60, 1, TimeUnit.SECONDS, qcW, qdi);

    private ba() {
    }

    private static synchronized ba eKf() {
        ba baVar;
        synchronized (ba.class) {
            if (qdj == null) {
                qdj = new ba();
            }
            baVar = qdj;
        }
        return baVar;
    }

    public static void D(Runnable runnable) {
        eKf().qdb.execute(runnable);
    }
}
