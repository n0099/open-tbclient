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
    public static Handler f40264c;

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f40265d;

    /* renamed from: b  reason: collision with root package name */
    public static Object f40263b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f40262a = c();

    /* loaded from: classes7.dex */
    public static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<Runnable> f40266a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f40267b;

        public a() {
            this.f40266a = new LinkedList();
        }

        public synchronized void a() {
            Runnable poll = this.f40266a.poll();
            this.f40267b = poll;
            if (poll != null) {
                i.f40262a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f40266a.offer(new Runnable() { // from class: com.tencent.open.utils.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f40267b == null) {
                a();
            }
        }
    }

    public static Handler a() {
        if (f40264c == null) {
            synchronized (i.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f40265d = handlerThread;
                handlerThread.start();
                f40264c = new Handler(f40265d.getLooper());
            }
        }
        return f40264c;
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
