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
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.aspectj.lang.JoinPoint;
/* loaded from: classes10.dex */
public final class a {
    public static volatile boolean agy;
    public static volatile boolean agz;
    public static Handler Ll = new Handler(Looper.getMainLooper());
    public static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    public static final String[] agA = {SwanKV.LIB_CPP_SHARED, "kscutils", JoinPoint.EXCEPTION_HANDLER};
    public static boolean agB = false;
    public static boolean agC = false;

    public static void a(@NonNull b bVar) {
        if (bVar.context == null || agz) {
            return;
        }
        agz = true;
        agB = bVar.agB;
        agC = bVar.agC;
        try {
            com.kwad.sdk.crash.utils.d.init(bVar.context);
            com.kwad.sdk.crash.kwai.a.init(bVar.context, bVar.agO);
            d.wz().a(bVar);
            bH(bVar.context);
            if (!bG(bVar.context) && (agB || agC)) {
                f.a(bVar, new f.a() { // from class: com.kwad.sdk.crash.a.1
                    @Override // com.kwad.sdk.crash.f.a
                    public final void wu() {
                        a.Ll.post(new Runnable() { // from class: com.kwad.sdk.crash.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (a.agB) {
                                    a.wm();
                                }
                                if (a.agC) {
                                    a.c(false, "/sdcard/");
                                }
                            }
                        });
                    }
                });
            }
            wn();
        } catch (Throwable unused) {
        }
    }

    public static boolean bG(Context context) {
        return context == null || w.cn(context) >= 3;
    }

    public static void bH(Context context) {
        com.kwad.sdk.crash.handler.c.wO().init(com.kwad.sdk.crash.kwai.a.wJ(), new e() { // from class: com.kwad.sdk.crash.a.3
            @Override // com.kwad.sdk.crash.e
            public final void a(int i, ExceptionMessage exceptionMessage) {
                d.wz().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.a.4
            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }

            @Override // com.kwad.sdk.crash.report.e
            public final File wv() {
                return new File(com.kwad.sdk.crash.kwai.a.wI(), "java_crash/upload");
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }

    public static void c(boolean z, String str) {
        if (com.kwad.sdk.crash.kwai.a.x(com.kwad.sdk.crash.kwai.a.wL())) {
            NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.kwai.a.wL(), z, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.a.7
                @Override // com.kwad.sdk.crash.report.e
                public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                    com.kwad.sdk.core.e.b.d("ExceptionCollector", "Native upload");
                    a(exceptionMessage, 4, countDownLatch);
                }

                @Override // com.kwad.sdk.crash.report.e
                public final File wv() {
                    return new File(com.kwad.sdk.crash.kwai.a.wI(), "native_crash_log/upload");
                }
            });
        }
    }

    public static void h(@NonNull final Throwable th) {
        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.sdk.crash.a.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.a.a.i(th)) {
                        com.kwad.sdk.crash.handler.a.j(new SdkCaughtException(th));
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.e.b.printStackTrace(th2);
                }
            }
        });
    }

    public static boolean wl() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            for (String str : agA) {
                System.loadLibrary(str);
            }
            ISLOADED.set(true);
            return true;
        } catch (Throwable unused) {
            ISLOADED.set(false);
            return false;
        }
    }

    public static void wm() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.kwai.a.wK(), new e() { // from class: com.kwad.sdk.crash.a.5
            @Override // com.kwad.sdk.crash.e
            public final void a(int i, ExceptionMessage exceptionMessage) {
                d.wz().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.a.6
            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                com.kwad.sdk.core.e.b.d("ExceptionCollector", "ANR upload");
                a(exceptionMessage, 3, countDownLatch);
            }

            @Override // com.kwad.sdk.crash.report.e
            public final File wv() {
                return new File(com.kwad.sdk.crash.kwai.a.wI(), "anr_log/upload");
            }
        });
    }

    public static synchronized void wn() {
        synchronized (a.class) {
            if (!agy) {
                agy = true;
                com.kwad.sdk.core.threads.a.vf().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.a.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            a.wo();
                        } catch (Throwable unused) {
                        }
                    }
                }, TimeUnit.SECONDS.toMillis(c.aha));
            }
        }
    }

    public static void wo() {
        wp();
        if (agB) {
            wq();
        }
        if (agC) {
            wr();
        }
    }

    public static void wp() {
        com.kwad.sdk.core.e.b.d("ExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.wO().getUploader());
        fVar.z(com.kwad.sdk.crash.kwai.a.wJ());
    }

    public static void wq() {
        com.kwad.sdk.core.e.b.d("ExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.z(com.kwad.sdk.crash.kwai.a.wK());
    }

    public static void wr() {
        com.kwad.sdk.core.e.b.d("ExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.z(com.kwad.sdk.crash.kwai.a.wL());
    }
}
