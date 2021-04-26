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
        public static final AtomicInteger f35113a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        public final String f35114b;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f35116d = new AtomicInteger(1);

        /* renamed from: c  reason: collision with root package name */
        public final ThreadGroup f35115c = Thread.currentThread().getThreadGroup();

        public a(String str) {
            this.f35114b = f.i(str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f35115c;
            Thread thread = new Thread(threadGroup, runnable, this.f35114b + this.f35116d.getAndIncrement(), 0L);
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
