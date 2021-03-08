package com.win.opensdk;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes14.dex */
public class bt {
    public static final BlockingQueue b = new LinkedBlockingQueue(210);
    public static final ThreadFactory c = new br();
    public static bt qli;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f8131a = new ThreadPoolExecutor(5, 60, 1, TimeUnit.SECONDS, b, c);

    public static void a(Runnable runnable) {
        eJd().f8131a.execute(runnable);
    }

    public static synchronized bt eJd() {
        bt btVar;
        synchronized (bt.class) {
            if (qli == null) {
                qli = new bt();
            }
            btVar = qli;
        }
        return btVar;
    }
}
