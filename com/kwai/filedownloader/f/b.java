package com.kwai.filedownloader.f;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class b {

    /* loaded from: classes6.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public static final AtomicInteger f34358a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        public final String f34359b;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f34361d = new AtomicInteger(1);

        /* renamed from: c  reason: collision with root package name */
        public final ThreadGroup f34360c = Thread.currentThread().getThreadGroup();

        public a(String str) {
            this.f34359b = f.i(str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f34360c;
            Thread thread = new Thread(threadGroup, runnable, this.f34359b + this.f34361d.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public static ThreadPoolExecutor a(int i2, String str) {
        return a(i2, new LinkedBlockingQueue(), str);
    }

    public static ThreadPoolExecutor a(int i2, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, linkedBlockingQueue, new a(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ThreadPoolExecutor a(String str) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new SynchronousQueue(), new a(str));
    }
}
