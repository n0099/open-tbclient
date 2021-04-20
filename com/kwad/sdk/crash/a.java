package com.kwad.sdk.crash;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f34698a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f34699b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f34700c = false;

    public static void a() {
        if (f34699b) {
            return;
        }
        f34699b = true;
        HandlerThread handlerThread = new HandlerThread("ex-uploader");
        f34698a = handlerThread;
        handlerThread.start();
        new Handler(f34698a.getLooper()).postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.a.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.f();
                } catch (Throwable unused) {
                }
                a.e();
            }
        }, TimeUnit.SECONDS.toMillis(c.f34727f));
    }

    public static void a(@NonNull b bVar) {
        if (bVar.f34710g == null || f34700c) {
            return;
        }
        f34700c = true;
        try {
            com.kwad.sdk.crash.utils.d.a(bVar.f34710g);
            com.kwad.sdk.crash.a.a.a(bVar.f34710g, bVar.n);
            d.a().a(bVar);
            d();
            Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.c.d(bVar.f34710g));
            a();
        } catch (Throwable unused) {
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

    public static void d() {
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

    public static void e() {
        try {
            if (f34698a != null && f34698a.isAlive()) {
                if (Build.VERSION.SDK_INT >= 18) {
                    f34698a.quitSafely();
                } else {
                    f34698a.quit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void f() {
        g();
    }

    public static void g() {
        com.kwad.sdk.crash.report.d dVar = new com.kwad.sdk.crash.report.d();
        dVar.a(com.kwad.sdk.crash.c.c.d().a());
        dVar.a(com.kwad.sdk.crash.a.a.b());
    }
}
