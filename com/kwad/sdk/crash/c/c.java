package com.kwad.sdk.crash.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.utils.f;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public final class c extends b {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f9932a = new c();
    }

    private c() {
    }

    public static c d() {
        return a.f9932a;
    }

    @Override // com.kwad.sdk.crash.c.b
    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        super.a(file, eVar, cVar);
        if (com.kwad.sdk.crash.d.a().i()) {
            a(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    public void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        a(th, exceptionMessage, context, false);
    }

    public void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context, boolean z) {
        boolean z2 = true;
        int andIncrement = this.d.getAndIncrement();
        File file = this.f;
        File file2 = this.g;
        File file3 = this.h;
        File file4 = this.i;
        com.kwad.sdk.crash.report.c a2 = a();
        try {
            exceptionMessage.mCrashDetail = th.toString();
            if (!this.e.exists() && !this.e.mkdirs()) {
                exceptionMessage.mErrorMessage += "create " + d().e.getPath() + " failed!\n";
                z2 = false;
            }
            if (file == null || andIncrement != 0) {
                file = new File(this.e, f9929a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + andIncrement + ".dump");
            }
            if (file2 == null || andIncrement != 0) {
                file2 = new File(this.e, f9929a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + andIncrement + BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            }
            if (file3 == null || andIncrement != 0) {
                file3 = new File(this.e, f9929a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + andIncrement + ".jtrace");
            }
            f.a(th, exceptionMessage, context);
            f.a(exceptionMessage, c());
            if (this.c != null) {
                this.c.a(c(), exceptionMessage);
            }
            try {
                String jSONObject = exceptionMessage.toJson().toString();
                if (!z2) {
                    if (a2 != null) {
                        com.kwad.sdk.core.d.a.a("ExceptionCollector", "uploader.uploadEvent(message);");
                        a2.a(exceptionMessage);
                        a2.b("java_crash_mkdir_fail", jSONObject);
                        a2.a("ExceptionCollector", "------  Java Crash Happened Begin ------\n" + exceptionMessage);
                        return;
                    }
                    return;
                }
                f.a(file, jSONObject);
                f.c(file3);
                f.a(file2);
                if (com.kwad.sdk.crash.d.a().i()) {
                    b(this.e);
                }
                if (a2 != null) {
                    a2.a("ExceptionCollector", "------  Java Crash Happened Begin ------\n" + exceptionMessage);
                    if (z) {
                        a(new File[]{file}, null);
                    } else {
                        b();
                    }
                }
                f.d(file4);
            } catch (Throwable th2) {
                if (a2 != null) {
                    try {
                        a2.b("java_crash_dump_error", f.a(th2));
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Throwable th3) {
            try {
                exceptionMessage.mErrorMessage += th3;
                try {
                    String jSONObject2 = exceptionMessage.toJson().toString();
                    if (!z2) {
                        if (a2 != null) {
                            com.kwad.sdk.core.d.a.a("ExceptionCollector", "uploader.uploadEvent(message);");
                            a2.a(exceptionMessage);
                            a2.b("java_crash_mkdir_fail", jSONObject2);
                            a2.a("ExceptionCollector", "------  Java Crash Happened Begin ------\n" + exceptionMessage);
                            return;
                        }
                        return;
                    }
                    f.a(file, jSONObject2);
                    f.c(file3);
                    f.a(file2);
                    if (com.kwad.sdk.crash.d.a().i()) {
                        b(this.e);
                    }
                    if (a2 != null) {
                        a2.a("ExceptionCollector", "------  Java Crash Happened Begin ------\n" + exceptionMessage);
                        if (z) {
                            a(new File[]{file}, null);
                        } else {
                            b();
                        }
                    }
                    f.d(file4);
                } catch (Throwable th4) {
                    if (a2 != null) {
                        try {
                            a2.b("java_crash_dump_error", f.a(th4));
                        } catch (Exception e2) {
                        }
                    }
                }
            } catch (Throwable th5) {
                try {
                    String jSONObject3 = exceptionMessage.toJson().toString();
                    if (z2) {
                        f.a(file, jSONObject3);
                        f.c(file3);
                        f.a(file2);
                        if (com.kwad.sdk.crash.d.a().i()) {
                            b(this.e);
                        }
                        if (a2 != null) {
                            a2.a("ExceptionCollector", "------  Java Crash Happened Begin ------\n" + exceptionMessage);
                            if (z) {
                                a(new File[]{file}, null);
                            } else {
                                b();
                            }
                        }
                        f.d(file4);
                    } else if (a2 != null) {
                        com.kwad.sdk.core.d.a.a("ExceptionCollector", "uploader.uploadEvent(message);");
                        a2.a(exceptionMessage);
                        a2.b("java_crash_mkdir_fail", jSONObject3);
                        a2.a("ExceptionCollector", "------  Java Crash Happened Begin ------\n" + exceptionMessage);
                    }
                } catch (Throwable th6) {
                    if (a2 != null) {
                        try {
                            a2.b("java_crash_dump_error", f.a(th6));
                        } catch (Exception e3) {
                        }
                    }
                }
                throw th5;
            }
        }
    }

    @Override // com.kwad.sdk.crash.c.b
    protected void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.d dVar = new com.kwad.sdk.crash.report.d();
        dVar.a(a());
        for (File file : fileArr) {
            dVar.b(file);
        }
    }

    @Override // com.kwad.sdk.crash.c.b
    protected int c() {
        return 1;
    }
}
