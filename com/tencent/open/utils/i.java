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
    public static Handler f40161c;

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f40162d;

    /* renamed from: b  reason: collision with root package name */
    public static Object f40160b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f40159a = c();

    /* loaded from: classes7.dex */
    public static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<Runnable> f40163a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f40164b;

        public a() {
            this.f40163a = new LinkedList();
        }

        public synchronized void a() {
            Runnable poll = this.f40163a.poll();
            this.f40164b = poll;
            if (poll != null) {
                i.f40159a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f40163a.offer(new Runnable() { // from class: com.tencent.open.utils.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f40164b == null) {
                a();
            }
        }
    }

    public static Handler a() {
        if (f40161c == null) {
            synchronized (i.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f40162d = handlerThread;
                handlerThread.start();
                f40161c = new Handler(f40162d.getLooper());
            }
        }
        return f40161c;
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
