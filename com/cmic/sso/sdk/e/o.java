package com.cmic.sso.sdk.e;

import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class o {
    private static ExecutorService a = new ThreadPoolExecutor(0, 30, 60, TimeUnit.SECONDS, new SynchronousQueue());

    public static void a(a aVar) {
        try {
            a.execute(aVar);
        } catch (Exception e) {
            aVar.a.uncaughtException(Thread.currentThread(), e);
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class a implements Runnable {
        private Thread.UncaughtExceptionHandler a;

        protected abstract void a();

        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
            this.a = new Thread.UncaughtExceptionHandler() { // from class: com.cmic.sso.sdk.e.o.a.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    th.printStackTrace();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public a(final Context context, final com.cmic.sso.sdk.a aVar) {
            this.a = new Thread.UncaughtExceptionHandler() { // from class: com.cmic.sso.sdk.e.o.a.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    com.cmic.sso.sdk.d.a.ntf.add(th);
                    com.cmic.sso.sdk.b.a.gr(context).a("200025", "发生未知错误", aVar, null);
                }
            };
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(this.a);
            a();
            Thread.currentThread().setUncaughtExceptionHandler(null);
        }
    }
}
