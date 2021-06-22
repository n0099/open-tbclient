package com.cmic.sso.sdk.d;

import android.content.Context;
import com.cmic.sso.sdk.auth.AuthnHelper;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f30758a = new ThreadPoolExecutor(0, 30, 60, TimeUnit.SECONDS, new SynchronousQueue());

    public static void a(a aVar) {
        try {
            f30758a.execute(aVar);
        } catch (Exception e2) {
            aVar.f30759a.uncaughtException(Thread.currentThread(), e2);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final Thread.UncaughtExceptionHandler f30759a;

        public a() {
            this.f30759a = new Thread.UncaughtExceptionHandler() { // from class: com.cmic.sso.sdk.d.o.a.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    th.printStackTrace();
                }
            };
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(this.f30759a);
            a();
            Thread.currentThread().setUncaughtExceptionHandler(null);
        }

        public a(final Context context, final com.cmic.sso.sdk.a aVar) {
            this.f30759a = new Thread.UncaughtExceptionHandler() { // from class: com.cmic.sso.sdk.d.o.a.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    aVar.a().f30729a.add(th);
                    AuthnHelper.getInstance(context).callBackResult("200025", "发生未知错误", aVar, null);
                }
            };
        }
    }
}
