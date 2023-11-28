package com.kwad.sdk.crash.handler;

import android.app.ActivityManager;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.util.Printer;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
@Keep
/* loaded from: classes10.dex */
public final class AnrHandler extends b {
    public static final String ANR_HAPPENED_BEGIN = "------ ANR Happened Begin ------\n";
    public static final String DEFAULT_TRACE_ROOT = "/data/anr/";
    public static final long GET_REASON_INTERVAL = 500;
    public static final long PARSE_TRACE_INTERVAL = 10000;
    public static final String TAG = "AnrHandler";
    public static final long TRY_TIMES = 20;
    public static long sLastTime;
    public FileObserver mTraceFileObserver;
    public static final int MY_PID = Process.myPid();
    public static final Pattern PID_PATTERN = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
    public static final boolean DUMP_FROM_SIG_QUIT = SystemUtil.dF(21);

    public static native void install(String str, int i);

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 3;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static final AnrHandler aES = new AnrHandler();
    }

    public AnrHandler() {
    }

    public static AnrHandler getInstance() {
        return a.aES;
    }

    private void watchTraceFile() {
        com.kwad.sdk.core.e.c.d(TAG, "ANR watchTraceFile");
        FileObserver fileObserver = new FileObserver(DEFAULT_TRACE_ROOT, 8) { // from class: com.kwad.sdk.crash.handler.AnrHandler.1
            @Override // android.os.FileObserver
            public final void onEvent(int i, @Nullable String str) {
                if (str != null) {
                    AnrHandler.this.onTraceFileWritten(AnrHandler.DEFAULT_TRACE_ROOT + str);
                }
            }
        };
        this.mTraceFileObserver = fileObserver;
        try {
            fileObserver.startWatching();
        } catch (Throwable unused) {
            getInstance().getUploader();
        }
    }

    @Keep
    public static void onCallFromNative(int i) {
        com.kwad.sdk.core.e.c.d(TAG, "ANR onCallFromNative index=" + i);
        dumpAnr(null, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTraceFileWritten(String str) {
        com.kwad.sdk.core.e.c.d(TAG, "ANR onTraceFileWritten");
        if (parseTraceFile(str)) {
            dumpAnr(str, this.mIndex.getAndIncrement());
        }
    }

    public static void getAnrReason(@Nullable String str, final File file) {
        com.kwad.sdk.core.e.c.d(TAG, "ANR getAnrReason");
        if (str == null) {
            g.schedule(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.3
                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getAnrReasonInner(null, file);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } else {
            getAnrReasonInner(str, file);
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(getUploader());
        for (File file : fileArr) {
            bVar.a(file, countDownLatch);
        }
    }

    public static synchronized void dumpAnr(@Nullable String str, int i) {
        synchronized (AnrHandler.class) {
            com.kwad.sdk.core.e.c.d(TAG, "ANR dumpAnr tracePath=" + str + " index=" + i);
            AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
            File file = getInstance().mLogDir;
            boolean z = true;
            if (!file.exists() && !file.mkdirs()) {
                com.kwad.sdk.core.e.c.d(TAG, "ANR dumpAnr create dir failed.");
                anrExceptionMessage.mErrorMessage += "create " + file.getPath() + " failed!\n";
                z = false;
            }
            if (str != null && z) {
                StringBuilder sb = new StringBuilder();
                getInstance();
                sb.append(b.FILE_NAME_BASE);
                sb.append("-");
                sb.append(i);
                sb.append(".dump");
                q.f(new File(str), new File(file, sb.toString()));
                StringBuilder sb2 = new StringBuilder();
                getInstance();
                sb2.append(b.FILE_NAME_BASE);
                sb2.append("-");
                sb2.append(i);
                sb2.append(".log");
                com.kwad.sdk.crash.utils.g.E(new File(file, sb2.toString()));
            }
            com.kwad.sdk.crash.utils.g.b(null, anrExceptionMessage, e.Gl().getContext());
            com.kwad.sdk.crash.utils.g.a(anrExceptionMessage, 3);
            if (getInstance().mExceptionListener != null) {
                getInstance().mExceptionListener.a(getInstance().getCrashType(), anrExceptionMessage);
            }
            dumpAnrReason(str, i, anrExceptionMessage, z);
        }
    }

    public static void dumpAnrReason(@Nullable String str, int i, @NonNull AnrExceptionMessage anrExceptionMessage, boolean z) {
        com.kwad.sdk.core.e.c.d(TAG, "ANR dumpAnrReason tracePath=" + str + " index=" + i + " dirReady=" + z);
        com.kwad.sdk.crash.report.e uploader = getInstance().getUploader();
        try {
            File file = getInstance().mLogDir;
            final StringBuilder sb = new StringBuilder();
            Looper.getMainLooper().dump(new Printer() { // from class: com.kwad.sdk.crash.handler.AnrHandler.2
                @Override // android.util.Printer
                public final void println(String str2) {
                    StringBuilder sb2 = sb;
                    sb2.append(str2);
                    sb2.append("\n");
                }
            }, "");
            anrExceptionMessage.mMessageQueueDetail = sb.substring(0, sb.length() - 1);
            String jSONObject = anrExceptionMessage.toJson().toString();
            StringBuilder sb2 = new StringBuilder();
            getInstance();
            sb2.append(b.FILE_NAME_BASE);
            sb2.append("-");
            sb2.append(i);
            sb2.append(".dump");
            File file2 = new File(file, sb2.toString());
            if (z) {
                StringBuilder sb3 = new StringBuilder();
                getInstance();
                sb3.append(b.FILE_NAME_BASE);
                sb3.append("-");
                sb3.append(i);
                sb3.append(".msg");
                File file3 = new File(file, sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                getInstance();
                sb4.append(b.FILE_NAME_BASE);
                sb4.append("-");
                sb4.append(i);
                sb4.append(".minfo");
                File file4 = new File(file, sb4.toString());
                com.kwad.sdk.crash.utils.g.a(file3, jSONObject);
                getInstance().backupLogFiles(file);
                if (uploader != null) {
                    new StringBuilder(ANR_HAPPENED_BEGIN).append(anrExceptionMessage);
                }
                com.kwad.sdk.crash.utils.g.a(uploader, TAG, file2);
                getInstance().uploadRemainingExceptions();
                com.kwad.sdk.crash.utils.g.H(file4);
            } else if (uploader != null) {
                if (str != null) {
                    uploader.a(anrExceptionMessage, null);
                }
                new StringBuilder(ANR_HAPPENED_BEGIN).append(anrExceptionMessage);
            }
            StringBuilder sb5 = new StringBuilder();
            getInstance();
            sb5.append(b.FILE_NAME_BASE);
            sb5.append("-");
            sb5.append(i);
            sb5.append(".anr");
            getAnrReason(str, new File(file, sb5.toString()));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            if (uploader != null) {
                com.kwad.sdk.crash.utils.g.q(th);
            }
        }
    }

    public static void getAnrReasonInner(@Nullable String str, File file) {
        com.kwad.sdk.core.e.c.d(TAG, "ANR getAnrReasonInner");
        com.kwad.sdk.crash.report.e uploader = getInstance().getUploader();
        if (str != null) {
            try {
                long lastModified = new File(str).lastModified();
                if (Math.abs(lastModified - sLastTime) < 10000) {
                    return;
                }
                sLastTime = lastModified;
            } catch (Throwable unused) {
                return;
            }
        }
        ActivityManager activityManager = (ActivityManager) e.Gl().getContext().getSystemService("activity");
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
        if (activityManager == null) {
            return;
        }
        for (int i = 0; i < 20; i++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.ProcessErrorStateInfo next = it.next();
                    if (next.condition == 2) {
                        processErrorStateInfo = next;
                        break;
                    }
                }
            }
            if (processErrorStateInfo != null) {
                break;
            }
            Thread.sleep(500L);
        }
        if (processErrorStateInfo == null) {
            return;
        }
        if (processErrorStateInfo.pid != MY_PID) {
            if (uploader != null) {
                new StringBuilder("other process anr:\n").append(processErrorStateInfo.shortMsg);
                return;
            }
            return;
        }
        AnrReason anrReason = new AnrReason();
        anrReason.mTag = processErrorStateInfo.tag;
        anrReason.mShortMsg = processErrorStateInfo.shortMsg;
        anrReason.mLongMsg = processErrorStateInfo.longMsg;
        com.kwad.sdk.crash.utils.g.a(file, anrReason.toJson().toString());
    }

    private boolean parseTraceFile(String str) {
        boolean z = false;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                int i = -1;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (PID_PATTERN.matcher(readLine).matches()) {
                                i = Integer.parseInt(readLine.split("\\s")[2]);
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (FileNotFoundException unused) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                if (i == MY_PID) {
                    z = true;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                return z;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException unused3) {
        } catch (IOException unused4) {
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, com.kwad.sdk.crash.report.e eVar) {
        super.init(file, fVar, eVar);
        if (!com.kwad.sdk.crash.b.FU()) {
            return;
        }
        com.kwad.sdk.core.e.c.d(TAG, "ANR init ");
        this.mLogDir = file;
        if (!file.exists()) {
            this.mLogDir.mkdirs();
        }
        File file2 = new File(this.mLogDir, b.FILE_NAME_BASE);
        if (!DUMP_FROM_SIG_QUIT) {
            watchTraceFile();
            return;
        }
        try {
            install(file2.getPath(), Build.VERSION.SDK_INT);
        } catch (Throwable unused) {
            getUploader();
        }
    }
}
