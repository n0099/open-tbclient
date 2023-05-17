package com.kwad.sdk.crash.handler;

import android.os.Build;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.report.g;
import com.kwad.sdk.crash.utils.f;
import java.io.File;
import java.util.concurrent.CountDownLatch;
@Keep
/* loaded from: classes9.dex */
public final class NativeCrashHandler extends b {
    public static final String NATIVE_CRASH_HAPPENED_BEGIN = "------ Native Crash Happened Begin ------\n";
    public static final String TAG = "NativeCrashHandler";
    public static ExceptionMessage mMessage = new NativeExceptionMessage();
    public File mMessageFile;

    /* loaded from: classes9.dex */
    public static class a {
        public static final NativeCrashHandler ahq = new NativeCrashHandler();
    }

    public NativeCrashHandler() {
    }

    public static native void doCrash();

    public static NativeCrashHandler getInstance() {
        return a.ahq;
    }

    public static native void install(@NonNull String str, boolean z, @NonNull String str2, int i);

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE, INVOKE, INVOKE, SGET, INVOKE, INVOKE, INVOKE, INVOKE, IF, INVOKE, MOVE_EXCEPTION] complete} */
    @Keep
    public static void onCallFromNative() {
        com.kwad.sdk.core.e.b.d(TAG, "onCallFromNative NativeCrashHandler.doCrash()");
        File file = getInstance().mLogDir;
        File file2 = getInstance().mMessageFile;
        File file3 = getInstance().mJavaTraceFile;
        File file4 = getInstance().mMemoryInfoFile;
        e uploader = getInstance().getUploader();
        try {
            if (!file.exists() && !file.mkdirs()) {
                StringBuilder sb = new StringBuilder();
                ExceptionMessage exceptionMessage = mMessage;
                sb.append(exceptionMessage.mErrorMessage);
                sb.append("create ");
                sb.append(file.getPath());
                sb.append(" failed!\n");
                exceptionMessage.mErrorMessage = sb.toString();
                if (uploader != null) {
                    mMessage.toJson();
                }
            }
            if (file2 == null) {
                StringBuilder sb2 = new StringBuilder();
                getInstance();
                sb2.append(b.FILE_NAME_BASE);
                sb2.append(".msg");
                file2 = new File(file, sb2.toString());
            }
            if (file3 == null) {
                StringBuilder sb3 = new StringBuilder();
                getInstance();
                sb3.append(b.FILE_NAME_BASE);
                sb3.append(".jtrace");
                file3 = new File(file, sb3.toString());
            }
            if (file4 == null) {
                StringBuilder sb4 = new StringBuilder();
                getInstance();
                sb4.append(b.FILE_NAME_BASE);
                sb4.append(".minfo");
                file4 = new File(file, sb4.toString());
            }
            f.b(null, mMessage, com.kwad.sdk.crash.d.wz().getContext());
            f.a(mMessage, getInstance().getCrashType());
            if (getInstance().mExceptionListener != null) {
                getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
            }
        } catch (Throwable th) {
            try {
                StringBuilder sb5 = new StringBuilder();
                ExceptionMessage exceptionMessage2 = mMessage;
                sb5.append(exceptionMessage2.mErrorMessage);
                sb5.append(th);
                exceptionMessage2.mErrorMessage = sb5.toString();
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                if (file2 != null) {
                    try {
                        f.a(file2, mMessage.toJson().toString());
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(th2);
                        if (uploader != null) {
                            f.l(th2);
                            return;
                        }
                        return;
                    }
                }
                f.D(file3);
                getInstance().backupLogFiles(file);
                f.a(uploader, TAG, getInstance().mDumpFile);
                getInstance().uploadRemainingExceptions();
                f.E(file4);
            } finally {
                if (file2 != null) {
                    try {
                        f.a(file2, mMessage.toJson().toString());
                    } catch (Throwable th3) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(th3);
                        if (uploader != null) {
                            f.l(th3);
                        }
                    }
                }
                f.D(file3);
                getInstance().backupLogFiles(file);
                f.a(uploader, TAG, getInstance().mDumpFile);
                getInstance().uploadRemainingExceptions();
                f.E(file4);
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 4;
    }

    public final void init(@NonNull File file, boolean z, @NonNull String str, com.kwad.sdk.crash.report.c cVar) {
        super.init(file, null, cVar);
        if (com.kwad.sdk.crash.a.wl()) {
            this.mLogDir = file;
            if (!file.exists()) {
                this.mLogDir.mkdirs();
            }
            this.mDumpFile = new File(file, b.FILE_NAME_BASE + ".dump");
            this.mJavaTraceFile = new File(file, b.FILE_NAME_BASE + ".jtrace");
            this.mMemoryInfoFile = new File(file, b.FILE_NAME_BASE + ".minfo");
            try {
                com.kwad.sdk.core.e.b.d(TAG, "ANR init2 " + this.mDumpFile.getPath());
                install(this.mDumpFile.getPath(), z, str, Build.VERSION.SDK_INT);
                this.mMessageFile = new File(file, b.FILE_NAME_BASE + ".msg");
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        g gVar = new g();
        gVar.a(getUploader());
        for (File file : fileArr) {
            gVar.a(file, countDownLatch);
        }
    }
}
