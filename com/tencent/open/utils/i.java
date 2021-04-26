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
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: c  reason: collision with root package name */
    public static Handler f37308c;

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f37309d;

    /* renamed from: b  reason: collision with root package name */
    public static Object f37307b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f37306a = c();

    /* loaded from: classes6.dex */
    public static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<Runnable> f37310a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f37311b;

        public a() {
            this.f37310a = new LinkedList();
        }

        public synchronized void a() {
            Runnable poll = this.f37310a.poll();
            this.f37311b = poll;
            if (poll != null) {
                i.f37306a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f37310a.offer(new Runnable() { // from class: com.tencent.open.utils.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f37311b == null) {
                a();
            }
        }
    }

    public static Handler a() {
        if (f37308c == null) {
            synchronized (i.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f37309d = handlerThread;
                handlerThread.start();
                f37308c = new Handler(f37309d.getLooper());
            }
        }
        return f37308c;
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
