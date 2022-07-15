package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.storage.swankv.SwanKV;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.aspectj.lang.JoinPoint;
/* loaded from: classes5.dex */
public final class a {
    public static volatile boolean a;
    public static volatile boolean b;
    public static Handler c = new Handler(Looper.getMainLooper());
    public static final AtomicBoolean d = new AtomicBoolean(false);
    public static final String[] e = {SwanKV.LIB_CPP_SHARED, "kscutils", JoinPoint.EXCEPTION_HANDLER};
    public static boolean f = false;
    public static boolean g = false;

    public static void a(Context context) {
        com.kwad.sdk.crash.handler.c.a().init(com.kwad.sdk.crash.kwai.a.b(), new e() { // from class: com.kwad.sdk.crash.a.3
            @Override // com.kwad.sdk.crash.e
            public final void a(int i, ExceptionMessage exceptionMessage) {
                d.a().a(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.a.4
            @Override // com.kwad.sdk.crash.report.e
            public final File a() {
                return new File(com.kwad.sdk.crash.kwai.a.a(), "java_crash/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }

    public static void a(@NonNull b bVar) {
        if (bVar.j == null || b) {
            return;
        }
        b = true;
        f = bVar.g;
        g = bVar.h;
        try {
            com.kwad.sdk.crash.utils.d.a(bVar.j);
            com.kwad.sdk.crash.kwai.a.a(bVar.j, bVar.q);
            d.a().a(bVar);
            a(bVar.j);
            if (f || g) {
                f.a(bVar, new f.a() { // from class: com.kwad.sdk.crash.a.1
                    @Override // com.kwad.sdk.crash.f.a
                    public final void a() {
                        a.c.post(new Runnable() { // from class: com.kwad.sdk.crash.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (a.f) {
                                    a.g();
                                }
                                if (a.g) {
                                    a.b(false, "/sdcard/");
                                }
                            }
                        });
                    }
                });
            }
            h();
        } catch (Throwable unused) {
        }
    }

    public static void a(@NonNull final Throwable th) {
        com.kwad.sdk.utils.g.a(new Runnable() { // from class: com.kwad.sdk.crash.a.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.a.a.a(th)) {
                        com.kwad.sdk.crash.handler.a.a(new SdkCaughtException(th));
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.b.a(th2);
                }
            }
        });
    }

    public static boolean a() {
        if (d.get()) {
            return true;
        }
        try {
            for (String str : e) {
                System.loadLibrary(str);
            }
            d.set(true);
            return true;
        } catch (Throwable unused) {
            d.set(false);
            return false;
        }
    }

    public static void b(boolean z, String str) {
        if (com.kwad.sdk.crash.kwai.a.a(com.kwad.sdk.crash.kwai.a.d())) {
            NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.kwai.a.d(), z, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.a.7
                @Override // com.kwad.sdk.crash.report.e
                public final File a() {
                    return new File(com.kwad.sdk.crash.kwai.a.a(), "native_crash_log/upload");
                }

                @Override // com.kwad.sdk.crash.report.e
                public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                    com.kwad.sdk.core.d.b.a("ExceptionCollector", "Native upload");
                    a(exceptionMessage, 4, countDownLatch);
                }
            });
        }
    }

    public static void g() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.kwai.a.c(), new e() { // from class: com.kwad.sdk.crash.a.5
            @Override // com.kwad.sdk.crash.e
            public final void a(int i, ExceptionMessage exceptionMessage) {
                d.a().a(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.a.6
            @Override // com.kwad.sdk.crash.report.e
            public final File a() {
                return new File(com.kwad.sdk.crash.kwai.a.a(), "anr_log/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                com.kwad.sdk.core.d.b.a("ExceptionCollector", "ANR upload");
                a(exceptionMessage, 3, countDownLatch);
            }
        });
    }

    public static synchronized void h() {
        synchronized (a.class) {
            if (!a) {
                a = true;
                com.kwad.sdk.core.threads.a.a().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.a.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            a.i();
                        } catch (Throwable unused) {
                        }
                    }
                }, TimeUnit.SECONDS.toMillis(c.f));
            }
        }
    }

    public static void i() {
        j();
        if (f) {
            k();
        }
        if (g) {
            l();
        }
    }

    public static void j() {
        com.kwad.sdk.core.d.b.a("ExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.a().getUploader());
        fVar.a(com.kwad.sdk.crash.kwai.a.b());
    }

    public static void k() {
        com.kwad.sdk.core.d.b.a("ExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.a(com.kwad.sdk.crash.kwai.a.c());
    }

    public static void l() {
        com.kwad.sdk.core.d.b.a("ExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.a(com.kwad.sdk.crash.kwai.a.d());
    }
}
