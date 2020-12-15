package com.cmic.sso.sdk.e;

import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f4030a = new ThreadPoolExecutor(0, 30, 60, TimeUnit.SECONDS, new SynchronousQueue());

    public static void a(a aVar) {
        try {
            f4030a.execute(aVar);
        } catch (Exception e) {
            aVar.f4031a.uncaughtException(Thread.currentThread(), e);
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f4031a;

        protected abstract void a();

        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
            this.f4031a = new Thread.UncaughtExceptionHandler() { // from class: com.cmic.sso.sdk.e.o.a.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    th.printStackTrace();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public a(final Context context, final com.cmic.sso.sdk.a aVar) {
            this.f4031a = new Thread.UncaughtExceptionHandler() { // from class: com.cmic.sso.sdk.e.o.a.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    com.cmic.sso.sdk.d.a.oZX.add(th);
                    com.cmic.sso.sdk.b.a.hA(context).a("200025", "发生未知错误", aVar, null);
                }
            };
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(this.f4031a);
            a();
            Thread.currentThread().setUncaughtExceptionHandler(null);
        }
    }
}
