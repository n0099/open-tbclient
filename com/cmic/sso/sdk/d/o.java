package com.cmic.sso.sdk.d;

import android.content.Context;
import com.cmic.sso.sdk.auth.AuthnHelper;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f30481a = new ThreadPoolExecutor(0, 30, 60, TimeUnit.SECONDS, new SynchronousQueue());

    public static void a(a aVar) {
        try {
            f30481a.execute(aVar);
        } catch (Exception e2) {
            aVar.f30482a.uncaughtException(Thread.currentThread(), e2);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Thread.UncaughtExceptionHandler f30482a;

        public a() {
            this.f30482a = new Thread.UncaughtExceptionHandler() { // from class: com.cmic.sso.sdk.d.o.a.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    th.printStackTrace();
                }
            };
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(this.f30482a);
            a();
            Thread.currentThread().setUncaughtExceptionHandler(null);
        }

        public a(final Context context, final com.cmic.sso.sdk.a aVar) {
            this.f30482a = new Thread.UncaughtExceptionHandler() { // from class: com.cmic.sso.sdk.d.o.a.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    com.cmic.sso.sdk.c.a.f30450a.add(th);
                    AuthnHelper.getInstance(context).callBackResult("200025", "发生未知错误", aVar, null);
                }
            };
        }
    }
}
