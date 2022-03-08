package com.kwad.sdk.crash;

import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.i;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class a {
    public static volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f55063b;

    public static synchronized void a() {
        synchronized (a.class) {
            if (!a) {
                a = true;
                com.kwad.sdk.core.i.a.a().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a.d();
                        } catch (Throwable unused) {
                        }
                    }
                }, TimeUnit.SECONDS.toMillis(c.f55098f));
            }
        }
    }

    public static void a(@NonNull b bVar) {
        if (bVar.f55070g == null || f55063b) {
            return;
        }
        f55063b = true;
        try {
            com.kwad.sdk.crash.utils.d.a(bVar.f55070g);
            com.kwad.sdk.crash.kwai.a.a(bVar.f55070g, bVar.n);
            d.a().a(bVar);
            c();
            Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.b.d(bVar.f55070g));
            a();
        } catch (Throwable unused) {
        }
    }

    public static void a(@NonNull final Throwable th) {
        i.a(new Runnable() { // from class: com.kwad.sdk.crash.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.kwad.sdk.crash.a.a.a(th)) {
                        com.kwad.sdk.crash.b.a.a(new SdkCaughtException(th));
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.a.a(th2);
                }
            }
        });
    }

    public static void c() {
        com.kwad.sdk.crash.b.c.d().a(com.kwad.sdk.crash.kwai.a.b(), new e() { // from class: com.kwad.sdk.crash.a.2
            @Override // com.kwad.sdk.crash.e
            public void a(int i2, ExceptionMessage exceptionMessage) {
                d.a().a(i2, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.a() { // from class: com.kwad.sdk.crash.a.3
            @Override // com.kwad.sdk.crash.report.c
            public void a(ExceptionMessage exceptionMessage) {
                a(exceptionMessage, 1);
            }
        });
    }

    public static void d() {
        e();
    }

    public static void e() {
        com.kwad.sdk.crash.report.d dVar = new com.kwad.sdk.crash.report.d();
        dVar.a(com.kwad.sdk.crash.b.c.d().a());
        dVar.a(com.kwad.sdk.crash.kwai.a.b());
    }
}
