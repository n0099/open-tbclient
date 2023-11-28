package com.kwad.sdk.crash.handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public abstract class b {
    public static final String FILE_NAME_BASE = UUID.randomUUID().toString();
    public static final int REAL_TIME_UPLOAD_THRESHOLD = 2;
    public static File sBackupDir;
    public File mDumpFile;
    public f mExceptionListener;
    public AtomicInteger mIndex = new AtomicInteger();
    public File mJavaTraceFile;
    public File mLogDir;
    public File mLogFile;
    public File mMemoryInfoFile;
    public e mUploader;

    public abstract int getCrashType();

    public abstract void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public f getCrashListener() {
        return this.mExceptionListener;
    }

    public final e getUploader() {
        return this.mUploader;
    }

    public void uploadRemainingExceptions() {
        File[] listFiles = this.mLogDir.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.handler.b.1
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return file.getName().endsWith(".dump");
            }
        });
        if (listFiles != null && listFiles.length > 2) {
            CountDownLatch countDownLatch = new CountDownLatch(listFiles.length);
            reportException(listFiles, countDownLatch);
            try {
                countDownLatch.await(5L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            }
        }
    }

    public static void initBackupDir(File file) {
        sBackupDir = file;
        if (!file.exists()) {
            sBackupDir.mkdirs();
        }
    }

    public void backupLogFiles(File file) {
        File file2 = sBackupDir;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            sBackupDir.mkdirs();
        }
        try {
            q.g(file.getParentFile().getParentFile(), sBackupDir);
        } catch (IOException e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }

    public void init(File file, f fVar, e eVar) {
        this.mLogDir = file;
        if (!file.exists()) {
            this.mLogDir.mkdirs();
        }
        File file2 = this.mLogDir;
        this.mDumpFile = new File(file2, FILE_NAME_BASE + "-" + this.mIndex + ".dump");
        File file3 = this.mLogDir;
        this.mLogFile = new File(file3, FILE_NAME_BASE + "-" + this.mIndex + ".log");
        File file4 = this.mLogDir;
        this.mJavaTraceFile = new File(file4, FILE_NAME_BASE + "-" + this.mIndex + ".jtrace");
        File file5 = this.mLogDir;
        this.mMemoryInfoFile = new File(file5, FILE_NAME_BASE + "-" + this.mIndex + ".minfo");
        this.mExceptionListener = fVar;
        this.mUploader = eVar;
    }
}
