package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.storage.swankv.SwanKV;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.aspectj.lang.JoinPoint;
/* loaded from: classes10.dex */
public final class b {
    public static volatile boolean aDY;
    public static volatile boolean aDZ;
    public static Handler Wk = new Handler(Looper.getMainLooper());
    public static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    public static final String[] aEa = {SwanKV.LIB_CPP_SHARED, "kscutils", JoinPoint.EXCEPTION_HANDLER};
    public static boolean aEb = false;
    public static boolean aEc = false;

    public static boolean FU() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            for (String str : aEa) {
                System.loadLibrary(str);
            }
            ISLOADED.set(true);
            return true;
        } catch (Throwable unused) {
            ISLOADED.set(false);
            return false;
        }
    }

    public static void FV() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.a.a.Gx(), new f() { // from class: com.kwad.sdk.crash.b.5
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                e.Gl().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.6
            @Override // com.kwad.sdk.crash.report.e
            public final File Gg() {
                return new File(com.kwad.sdk.crash.a.a.Gv(), "anr_log/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                com.kwad.sdk.core.e.c.d("AdExceptionCollector", "ANR upload");
                a(exceptionMessage, 3, countDownLatch);
            }
        });
    }

    public static synchronized void FW() {
        synchronized (b.class) {
            if (!aDY) {
                aDY = true;
                com.kwad.sdk.core.threads.a.Ep().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.b.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            b.FX();
                        } catch (Throwable unused) {
                        }
                    }
                }, TimeUnit.SECONDS.toMillis(d.aEE));
            }
        }
    }

    public static void FX() {
        FY();
        if (aEb) {
            FZ();
        }
        if (aEc) {
            Ga();
        }
    }

    public static void FY() {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.GB().getUploader());
        fVar.C(com.kwad.sdk.crash.a.a.Gw());
    }

    public static void FZ() {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.C(com.kwad.sdk.crash.a.a.Gx());
    }

    public static void Ga() {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.C(com.kwad.sdk.crash.a.a.Gy());
    }

    public static void a(@NonNull c cVar) {
        if (cVar.context == null || aDZ) {
            return;
        }
        aDZ = true;
        aEb = cVar.aEb;
        aEc = cVar.aEc;
        try {
            com.kwad.sdk.crash.utils.e.init(cVar.context);
            com.kwad.sdk.crash.a.a.init(cVar.context, cVar.aEp);
            e.Gl().a(cVar);
            bu(cVar.context);
            if (!bt(cVar.context) && (aEb || aEc)) {
                g.a(cVar, new g.a() { // from class: com.kwad.sdk.crash.b.1
                    @Override // com.kwad.sdk.crash.g.a
                    public final void Ge() {
                        b.Wk.post(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.kwad.sdk.core.e.c.w("AdExceptionCollector", "ExceptionSoLoadHelper.init onLoad");
                                if (b.aEb) {
                                    b.FV();
                                }
                                if (!b.aEc) {
                                    return;
                                }
                                b.c(false, "/sdcard/");
                            }
                        });
                    }

                    @Override // com.kwad.sdk.crash.g.a
                    public final void Gf() {
                        com.kwad.sdk.core.e.c.w("AdExceptionCollector", "ExceptionSoLoadHelper.init fail");
                    }
                });
            }
            FW();
        } catch (Throwable unused) {
        }
    }

    public static boolean bt(Context context) {
        if (context == null || y.cb(context) >= 3) {
            return true;
        }
        return false;
    }

    public static void bu(Context context) {
        com.kwad.sdk.crash.handler.c.GB().init(com.kwad.sdk.crash.a.a.Gw(), new f() { // from class: com.kwad.sdk.crash.b.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                e.Gl().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.4
            @Override // com.kwad.sdk.crash.report.e
            public final File Gg() {
                return new File(com.kwad.sdk.crash.a.a.Gv(), "java_crash/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }

    public static void m(@NonNull final Throwable th) {
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.sdk.crash.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.b.a.n(th)) {
                        com.kwad.sdk.crash.handler.a.o(th);
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.e.c.printStackTrace(th2);
                }
            }
        });
    }

    public static void c(boolean z, String str) {
        if (!com.kwad.sdk.crash.a.a.A(com.kwad.sdk.crash.a.a.Gy())) {
            return;
        }
        NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.a.a.Gy(), z, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.7
            @Override // com.kwad.sdk.crash.report.e
            public final File Gg() {
                return new File(com.kwad.sdk.crash.a.a.Gv(), "native_crash_log/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                com.kwad.sdk.core.e.c.d("AdExceptionCollector", "Native upload");
                a(exceptionMessage, 4, countDownLatch);
            }
        });
    }
}
