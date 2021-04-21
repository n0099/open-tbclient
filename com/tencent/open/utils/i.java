package com.tencent.open.utils;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class i {

    /* renamed from: c  reason: collision with root package name */
    public static Handler f39706c;

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f39707d;

    /* renamed from: b  reason: collision with root package name */
    public static Object f39705b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f39704a = c();

    /* loaded from: classes7.dex */
    public static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<Runnable> f39708a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f39709b;

        public a() {
            this.f39708a = new LinkedList();
        }

        public synchronized void a() {
            Runnable poll = this.f39708a.poll();
            this.f39709b = poll;
            if (poll != null) {
                i.f39704a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f39708a.offer(new Runnable() { // from class: com.tencent.open.utils.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f39709b == null) {
                a();
            }
        }
    }

    public static Handler a() {
        if (f39706c == null) {
            synchronized (i.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f39707d = handlerThread;
                handlerThread.start();
                f39706c = new Handler(f39707d.getLooper());
            }
        }
        return f39706c;
    }

    public static Executor b() {
        return new a();
    }

    public static Executor c() {
        Executor threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 11) {
            threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        } else {
            try {
                Field declaredField = AsyncTask.class.getDeclaredField("sExecutor");
                declaredField.setAccessible(true);
                threadPoolExecutor = (Executor) declaredField.get(null);
            } catch (Exception unused) {
                threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
        }
        if (threadPoolExecutor instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) threadPoolExecutor).setCorePoolSize(3);
        }
        return threadPoolExecutor;
    }

    public static void a(Runnable runnable) {
        a().post(runnable);
    }
}
