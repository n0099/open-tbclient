package com.kwad.sdk.crash.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.utils.f;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class c extends b {

    /* loaded from: classes9.dex */
    public static class a {
        public static final c ahp = new c((byte) 0);
    }

    public c() {
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(2:2|3)|(24:(3:188|189|(13:191|192|6|(6:176|177|178|179|180|181)|(6:164|165|166|167|168|169)|(6:152|153|154|155|156|157)|(6:140|141|142|143|144|145)|15|16|(1:18)|20|21|(5:23|(1:25)|(2:27|(3:29|30|31)(1:34))|35|36)(1:(4:39|(1:41)(1:51)|42|(3:44|45|47)(1:50))(1:52))))|167|168|169|(0)|152|153|154|155|156|157|(0)|140|141|142|143|144|145|15|16|(0)|20|21|(0)(0))|5|6|(0)|176|177|178|179|180|181|(0)|164|165|166|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0206, code lost:
        if (r24 != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0208, code lost:
        r0 = new java.util.concurrent.CountDownLatch(1);
        reportException(new java.io.File[]{r6}, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0216, code lost:
        r0.await(5, java.util.concurrent.TimeUnit.SECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x021e, code lost:
        uploadRemainingExceptions();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0221, code lost:
        com.kwad.sdk.crash.utils.f.E(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0225, code lost:
        if (r10 != null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0227, code lost:
        com.kwad.sdk.core.e.b.d("ExceptionCollector", "uploader.uploadEvent(message);");
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x022a, code lost:
        if (r24 != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x022c, code lost:
        r11 = new java.util.concurrent.CountDownLatch(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0233, code lost:
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0234, code lost:
        r10.a(r22, r11);
        new java.lang.StringBuilder("------  Java Crash Happened Begin ------\n").append(r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x023f, code lost:
        if (r11 != null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0241, code lost:
        r11.await(5, java.util.concurrent.TimeUnit.SECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0249, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a7, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a9, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01aa, code lost:
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b3, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e4, code lost:
        com.kwad.sdk.crash.utils.f.a(r6, r0);
        com.kwad.sdk.crash.utils.f.D(r8);
        com.kwad.sdk.crash.utils.f.B(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01f5, code lost:
        if (com.kwad.sdk.crash.d.wz().isDebug() != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01f7, code lost:
        backupLogFiles(r20.mLogDir);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01fc, code lost:
        if (r10 != null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01fe, code lost:
        new java.lang.StringBuilder("------  Java Crash Happened Begin ------\n").append(r22);
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010b A[Catch: all -> 0x018f, TRY_LEAVE, TryCatch #10 {all -> 0x018f, blocks: (B:37:0x00fd, B:39:0x010b), top: B:173:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011e A[Catch: all -> 0x0186, TryCatch #5 {all -> 0x0186, blocks: (B:40:0x0114, B:42:0x011e, B:44:0x0131, B:46:0x0138, B:48:0x0142, B:49:0x0150, B:51:0x0158, B:52:0x015b, B:54:0x0162, B:56:0x0167, B:58:0x016f, B:60:0x017c), top: B:165:0x0114 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e4 A[Catch: all -> 0x024a, TryCatch #8 {all -> 0x024a, blocks: (B:93:0x01da, B:95:0x01e4, B:97:0x01f7, B:99:0x01fe, B:101:0x0208, B:102:0x0216, B:104:0x021e, B:105:0x0221, B:107:0x0227, B:109:0x022c, B:111:0x0234, B:113:0x0241), top: B:170:0x01da }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context, boolean z) {
        boolean z2;
        int andIncrement = this.mIndex.getAndIncrement();
        File file = this.mDumpFile;
        File file2 = this.mLogFile;
        File file3 = this.mJavaTraceFile;
        File file4 = this.mMemoryInfoFile;
        e uploader = getUploader();
        try {
            exceptionMessage.mCrashDetail = th.toString();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    if (!this.mLogDir.exists()) {
                                        try {
                                            if (!this.mLogDir.mkdirs()) {
                                                exceptionMessage.mErrorMessage += "create " + wO().mLogDir.getPath() + " failed!\n";
                                                z2 = false;
                                                if (file != null || andIncrement != 0) {
                                                    File file5 = this.mLogDir;
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(b.FILE_NAME_BASE);
                                                    sb.append("-");
                                                    sb.append(andIncrement);
                                                    sb.append(".dump");
                                                    file = new File(file5, sb.toString());
                                                }
                                                if (file2 != null || andIncrement != 0) {
                                                    File file6 = this.mLogDir;
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append(b.FILE_NAME_BASE);
                                                    sb2.append("-");
                                                    sb2.append(andIncrement);
                                                    sb2.append(".log");
                                                    file2 = new File(file6, sb2.toString());
                                                }
                                                if (file3 != null || andIncrement != 0) {
                                                    File file7 = this.mLogDir;
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append(b.FILE_NAME_BASE);
                                                    sb3.append("-");
                                                    sb3.append(andIncrement);
                                                    sb3.append(".jtrace");
                                                    file3 = new File(file7, sb3.toString());
                                                }
                                                if (file4 != null || andIncrement != 0) {
                                                    File file8 = this.mLogDir;
                                                    StringBuilder sb4 = new StringBuilder();
                                                    sb4.append(b.FILE_NAME_BASE);
                                                    sb4.append("-");
                                                    sb4.append(andIncrement);
                                                    sb4.append(".minfo");
                                                    file4 = new File(file8, sb4.toString());
                                                }
                                                f.b(th, exceptionMessage, context);
                                                f.a(exceptionMessage, getCrashType());
                                                if (this.mExceptionListener != null) {
                                                    this.mExceptionListener.a(getCrashType(), exceptionMessage);
                                                }
                                                String jSONObject = exceptionMessage.toJson().toString();
                                                if (z2) {
                                                    if (uploader != null) {
                                                        com.kwad.sdk.core.e.b.d("ExceptionCollector", "uploader.uploadEvent(message);");
                                                        CountDownLatch countDownLatch = z ? new CountDownLatch(1) : null;
                                                        uploader.a(exceptionMessage, countDownLatch);
                                                        new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                                        if (countDownLatch != null) {
                                                            try {
                                                                countDownLatch.await(5L, TimeUnit.SECONDS);
                                                                return;
                                                            } catch (InterruptedException unused) {
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                f.a(file, jSONObject);
                                                f.D(file3);
                                                f.B(file2);
                                                if (com.kwad.sdk.crash.d.wz().isDebug()) {
                                                    backupLogFiles(this.mLogDir);
                                                }
                                                if (uploader != null) {
                                                    new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                                    if (z) {
                                                        CountDownLatch countDownLatch2 = new CountDownLatch(1);
                                                        reportException(new File[]{file}, countDownLatch2);
                                                        try {
                                                            countDownLatch2.await(5L, TimeUnit.SECONDS);
                                                        } catch (InterruptedException unused2) {
                                                        }
                                                    } else {
                                                        uploadRemainingExceptions();
                                                    }
                                                }
                                                f.E(file4);
                                                return;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            z2 = true;
                                            try {
                                                exceptionMessage.mErrorMessage += th;
                                                try {
                                                    String jSONObject2 = exceptionMessage.toJson().toString();
                                                    if (!z2) {
                                                    }
                                                } catch (Throwable th4) {
                                                    if (uploader != null) {
                                                        try {
                                                            f.l(th4);
                                                            return;
                                                        } catch (Exception unused3) {
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                            } catch (Throwable th5) {
                                                try {
                                                    String jSONObject3 = exceptionMessage.toJson().toString();
                                                    if (z2) {
                                                        f.a(file, jSONObject3);
                                                        f.D(file3);
                                                        f.B(file2);
                                                        if (com.kwad.sdk.crash.d.wz().isDebug()) {
                                                            backupLogFiles(this.mLogDir);
                                                        }
                                                        if (uploader != null) {
                                                            new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                                            if (z) {
                                                                CountDownLatch countDownLatch3 = new CountDownLatch(1);
                                                                reportException(new File[]{file}, countDownLatch3);
                                                                try {
                                                                    countDownLatch3.await(5L, TimeUnit.SECONDS);
                                                                } catch (InterruptedException unused4) {
                                                                }
                                                            } else {
                                                                uploadRemainingExceptions();
                                                            }
                                                        }
                                                        f.E(file4);
                                                    } else if (uploader != null) {
                                                        com.kwad.sdk.core.e.b.d("ExceptionCollector", "uploader.uploadEvent(message);");
                                                        CountDownLatch countDownLatch4 = z ? new CountDownLatch(1) : null;
                                                        uploader.a(exceptionMessage, countDownLatch4);
                                                        new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                                        if (countDownLatch4 != null) {
                                                            try {
                                                                countDownLatch4.await(5L, TimeUnit.SECONDS);
                                                            } catch (InterruptedException | Exception unused5) {
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th6) {
                                                    if (uploader != null) {
                                                        f.l(th6);
                                                    }
                                                }
                                                throw th5;
                                            }
                                        }
                                    }
                                    String jSONObject4 = exceptionMessage.toJson().toString();
                                    if (z2) {
                                    }
                                } catch (Throwable th7) {
                                    if (uploader != null) {
                                        try {
                                            f.l(th7);
                                            return;
                                        } catch (Exception unused6) {
                                            return;
                                        }
                                    }
                                    return;
                                }
                                f.b(th, exceptionMessage, context);
                                f.a(exceptionMessage, getCrashType());
                                if (this.mExceptionListener != null) {
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                exceptionMessage.mErrorMessage += th;
                                String jSONObject22 = exceptionMessage.toJson().toString();
                                if (!z2) {
                                }
                            }
                            sb4.append(b.FILE_NAME_BASE);
                            sb4.append("-");
                            sb4.append(andIncrement);
                            sb4.append(".minfo");
                            file4 = new File(file8, sb4.toString());
                        } catch (Throwable th9) {
                            th = th9;
                            file4 = file4;
                            exceptionMessage.mErrorMessage += th;
                            String jSONObject222 = exceptionMessage.toJson().toString();
                            if (!z2) {
                            }
                        }
                        File file82 = this.mLogDir;
                        StringBuilder sb42 = new StringBuilder();
                    } catch (Throwable th10) {
                        th = th10;
                        exceptionMessage.mErrorMessage += th;
                        String jSONObject2222 = exceptionMessage.toJson().toString();
                        if (!z2) {
                        }
                    }
                    sb3.append(b.FILE_NAME_BASE);
                    sb3.append("-");
                    sb3.append(andIncrement);
                    sb3.append(".jtrace");
                    file3 = new File(file7, sb3.toString());
                    if (file4 != null) {
                    }
                } catch (Throwable th11) {
                    th = th11;
                    file3 = file3;
                    exceptionMessage.mErrorMessage += th;
                    String jSONObject22222 = exceptionMessage.toJson().toString();
                    if (!z2) {
                    }
                }
                File file72 = this.mLogDir;
                StringBuilder sb32 = new StringBuilder();
            } catch (Throwable th12) {
                th = th12;
                exceptionMessage.mErrorMessage += th;
                String jSONObject222222 = exceptionMessage.toJson().toString();
                if (!z2) {
                }
            }
            sb2.append(b.FILE_NAME_BASE);
            sb2.append("-");
            sb2.append(andIncrement);
            sb2.append(".log");
            file2 = new File(file6, sb2.toString());
            if (file3 != null) {
            }
        } catch (Throwable th13) {
            th = th13;
            file2 = file2;
            exceptionMessage.mErrorMessage += th;
            String jSONObject2222222 = exceptionMessage.toJson().toString();
            if (!z2) {
            }
        }
        z2 = true;
        if (file != null) {
        }
        File file52 = this.mLogDir;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(b.FILE_NAME_BASE);
        sb5.append("-");
        sb5.append(andIncrement);
        sb5.append(".dump");
        file = new File(file52, sb5.toString());
        if (file2 != null) {
        }
        File file62 = this.mLogDir;
        StringBuilder sb22 = new StringBuilder();
    }

    public static c wO() {
        return a.ahp;
    }

    public final void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        a(th, exceptionMessage, context, ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getIsExternal());
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 1;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, com.kwad.sdk.crash.e eVar, e eVar2) {
        super.init(file, eVar, eVar2);
        if (com.kwad.sdk.crash.d.wz().isDebug()) {
            b.initBackupDir(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(getUploader());
        for (File file : fileArr) {
            fVar.a(file, countDownLatch);
        }
    }
}
