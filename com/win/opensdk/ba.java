package com.win.opensdk;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public final class ba {
    private static final BlockingQueue<Runnable> qeE = new LinkedBlockingQueue(210);
    private static final ThreadFactory qeQ = new ThreadFactory() { // from class: com.win.opensdk.ba.1
        private final AtomicInteger qev = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "T#" + this.qev.getAndIncrement());
        }
    };
    private static ba qeR;
    private ThreadPoolExecutor qeJ = new ThreadPoolExecutor(5, 60, 1, TimeUnit.SECONDS, qeE, qeQ);

    private ba() {
    }

    private static synchronized ba eKJ() {
        ba baVar;
        synchronized (ba.class) {
            if (qeR == null) {
                qeR = new ba();
            }
            baVar = qeR;
        }
        return baVar;
    }

    public static void D(Runnable runnable) {
        eKJ().qeJ.execute(runnable);
    }
}
