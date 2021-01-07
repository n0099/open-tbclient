package com.kwad.sdk.crash;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f9916a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f9917b = false;
    private static volatile boolean c = false;

    public static void a() {
        if (f9917b) {
            return;
        }
        f9917b = true;
        f9916a = new HandlerThread("ex-uploader");
        f9916a.start();
        new Handler(f9916a.getLooper()).postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.a.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.f();
                    a.e();
                } catch (Throwable th) {
                    a.e();
                }
            }
        }, TimeUnit.SECONDS.toMillis(c.f));
    }

    public static void a(@NonNull b bVar) {
        if (bVar.g == null || c) {
            return;
        }
        c = true;
        try {
            com.kwad.sdk.crash.utils.d.a(bVar.g);
            com.kwad.sdk.crash.a.a.a(bVar.g, bVar.n);
            d.a().a(bVar);
            d();
            Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.c.d(bVar.g));
            a();
        } catch (Throwable th) {
        }
    }

    public static void a(@NonNull final Throwable th) {
        com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.crash.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.kwad.sdk.crash.b.a.a(th)) {
                        com.kwad.sdk.crash.c.a.a(new SdkCaughtException(th));
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.a.a(th2);
                }
            }
        });
    }

    private static void d() {
        com.kwad.sdk.crash.c.c.d().a(com.kwad.sdk.crash.a.a.b(), new e() { // from class: com.kwad.sdk.crash.a.2
            @Override // com.kwad.sdk.crash.e
            public void a(int i, ExceptionMessage exceptionMessage) {
                d.a().a(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.a() { // from class: com.kwad.sdk.crash.a.3
            @Override // com.kwad.sdk.crash.report.c
            public void a(ExceptionMessage exceptionMessage) {
                a(exceptionMessage, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        try {
            if (f9916a != null && f9916a.isAlive()) {
                if (Build.VERSION.SDK_INT >= 18) {
                    f9916a.quitSafely();
                } else {
                    f9916a.quit();
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        g();
    }

    private static void g() {
        com.kwad.sdk.crash.report.d dVar = new com.kwad.sdk.crash.report.d();
        dVar.a(com.kwad.sdk.crash.c.c.d().a());
        dVar.a(com.kwad.sdk.crash.a.a.b());
    }
}
