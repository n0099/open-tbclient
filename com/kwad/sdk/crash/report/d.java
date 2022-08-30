package com.kwad.sdk.crash.report;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.o;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class d {
    public String mErrorMessage = "";
    public e mUploader;

    private void a(ExceptionMessage exceptionMessage, @NonNull List<File> list, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.core.e.b.d("ExceptionCollector", "compressAndUpload");
        File wv = this.mUploader.wv();
        if (!wv.exists()) {
            wv.mkdir();
        }
        File file = new File(wv, exceptionMessage.mLogUUID + ".zip");
        StringBuilder sb = new StringBuilder("compressAndUpload zipFile=");
        sb.append(file.getPath());
        com.kwad.sdk.core.e.b.d("ExceptionCollector", sb.toString());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
        l.a((File[]) list.toArray(new File[0]), file.getPath());
        if (file.length() <= 0) {
            o.P(file);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mLogUUID", exceptionMessage.mLogUUID);
        new JSONObject(hashMap);
        b(file, countDownLatch);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x008b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x000d */
    public static void a(File file, ExceptionMessage exceptionMessage) {
        BufferedReader bufferedReader;
        String readLine;
        String str;
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                ThreadInfo threadInfo = new ThreadInfo();
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.isEmpty()) {
                        arrayList.add(threadInfo);
                        threadInfo = new ThreadInfo();
                    } else {
                        if (!readLine.startsWith("at ") && !readLine.startsWith("(no ")) {
                            threadInfo.mName = readLine;
                        }
                        if (threadInfo.mTrace == null) {
                            str = readLine;
                        } else {
                            str = threadInfo.mTrace + readLine;
                        }
                        threadInfo.mTrace = str;
                        threadInfo.mTrace += "#";
                    }
                }
                memoryInfo.mJavaThreads = arrayList;
                exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                bufferedReader2 = readLine;
            } catch (IOException e2) {
                e = e2;
                bufferedReader2 = bufferedReader;
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                bufferedReader2 = bufferedReader2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                throw th;
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e3);
        }
    }

    @SuppressLint({"CheckResult"})
    public static void b(File file, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.upload.d.a(file, true, countDownLatch);
    }

    public static String db(String str) {
        return (str == null || !str.contains("-")) ? str : str.substring(0, str.lastIndexOf(45));
    }

    public abstract ExceptionMessage a(@NonNull File file, File file2, File file3, String str);

    public final void a(e eVar) {
        this.mUploader = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, CHECK_CAST, INVOKE, INVOKE, GOTO, INVOKE, MOVE_EXCEPTION, SGET, INVOKE, IF, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public final void a(File file, @Nullable CountDownLatch countDownLatch) {
        File[] listFiles;
        String df = com.kwad.sdk.crash.utils.f.df(file.getPath());
        File file2 = new File(df + ".msg");
        File file3 = new File(df + ".log");
        File file4 = new File(df + ".blog");
        File file5 = new File(df + ".jtrace");
        File file6 = new File(df + ".minfo");
        ArrayList<File> arrayList = new ArrayList();
        try {
            ExceptionMessage a = a(file, file2, file3, df);
            if (a == null) {
                try {
                    o.delete(file.getPath());
                    o.delete(file3.getPath());
                    o.delete(file4.getPath());
                    o.delete(file2.getPath());
                    o.delete(file5.getPath());
                    o.delete(file6.getPath());
                    for (File file7 : arrayList) {
                        o.delete(file7.getPath());
                    }
                    com.kwad.sdk.crash.utils.f.C(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                    return;
                }
            }
            com.kwad.sdk.core.e.b.d("ExceptionCollector", "message.mCrashSource=" + a.mCrashSource);
            if (a.mCrashSource == 2) {
                try {
                    o.delete(file.getPath());
                    o.delete(file3.getPath());
                    o.delete(file4.getPath());
                    o.delete(file2.getPath());
                    o.delete(file5.getPath());
                    o.delete(file6.getPath());
                    for (File file8 : arrayList) {
                        o.delete(file8.getPath());
                    }
                    com.kwad.sdk.crash.utils.f.C(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th2);
                    return;
                }
            }
            this.mUploader.a(a, countDownLatch);
            if (this instanceof f) {
                com.kwad.sdk.core.e.b.d("ExceptionCollector", " java crash 不上传文件");
                try {
                    return;
                } catch (Throwable th3) {
                    return;
                }
            }
            com.kwad.sdk.crash.utils.f.B(file4);
            List<File> arrayList2 = new ArrayList<>();
            Collections.addAll(arrayList2, file3, file4);
            Iterator<File> it = arrayList2.iterator();
            while (it.hasNext()) {
                if (!it.next().exists()) {
                    it.remove();
                }
            }
            File file9 = new File(file.getParentFile().getParent(), "custom");
            if (file9.exists()) {
                for (File file10 : file9.listFiles()) {
                    if (!file10.isDirectory() && (file10.getName().startsWith(a.mLogUUID) || file10.getName().startsWith(db(a.mLogUUID)))) {
                        arrayList.add(file10);
                    }
                }
                arrayList2.addAll(arrayList);
            }
            a(a, arrayList2, countDownLatch);
            try {
                o.delete(file.getPath());
                o.delete(file3.getPath());
                o.delete(file4.getPath());
                o.delete(file2.getPath());
                o.delete(file5.getPath());
                o.delete(file6.getPath());
                for (File file11 : arrayList) {
                    o.delete(file11.getPath());
                }
                com.kwad.sdk.crash.utils.f.C(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th4) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th4);
            }
        } catch (Throwable th5) {
            try {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th5);
                com.kwad.sdk.crash.utils.f.l(th5);
                try {
                    o.delete(file.getPath());
                    o.delete(file3.getPath());
                    o.delete(file4.getPath());
                    o.delete(file2.getPath());
                    o.delete(file5.getPath());
                    o.delete(file6.getPath());
                    for (File file12 : arrayList) {
                        o.delete(file12.getPath());
                    }
                    com.kwad.sdk.crash.utils.f.C(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th6) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th6);
                }
            } finally {
                try {
                    o.delete(file.getPath());
                    o.delete(file3.getPath());
                    o.delete(file4.getPath());
                    o.delete(file2.getPath());
                    o.delete(file5.getPath());
                    o.delete(file6.getPath());
                    for (File file13 : arrayList) {
                        o.delete(file13.getPath());
                    }
                    com.kwad.sdk.crash.utils.f.C(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th32) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th32);
                }
            }
        }
    }

    public final void b(File file, ExceptionMessage exceptionMessage) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                            return;
                        } else if (z || !readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                            if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                                if (readLine.contains("dvm_lock_sample")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                                        sb2 = new StringBuilder();
                                        sb2.append(readLine);
                                        sb2.append("\n");
                                    } else {
                                        sb2 = new StringBuilder();
                                        sb2.append(exceptionMessage.mLockInfo);
                                        sb2.append(readLine);
                                        sb2.append("\n");
                                    }
                                    exceptionMessage.mLockInfo = sb2.toString();
                                } else if (readLine.contains("Long monitor")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                                        sb3 = new StringBuilder();
                                        sb3.append(readLine);
                                        sb3.append("\n");
                                    } else {
                                        sb3 = new StringBuilder();
                                        sb3.append(exceptionMessage.mMonitorInfo);
                                        sb3.append(readLine);
                                        sb3.append("\n");
                                    }
                                    exceptionMessage.mMonitorInfo = sb3.toString();
                                } else if (readLine.contains("Slow Looper")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                                        sb4 = new StringBuilder();
                                        sb4.append(readLine);
                                        sb4.append("\n");
                                    } else {
                                        sb4 = new StringBuilder();
                                        sb4.append(exceptionMessage.mSlowLooper);
                                        sb4.append(readLine);
                                        sb4.append("\n");
                                    }
                                    exceptionMessage.mSlowLooper = sb4.toString();
                                } else if (readLine.contains("Slow Operation")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                                        sb5 = new StringBuilder();
                                        sb5.append(readLine);
                                        sb5.append("\n");
                                    } else {
                                        sb5 = new StringBuilder();
                                        sb5.append(exceptionMessage.mSlowOperation);
                                        sb5.append(readLine);
                                        sb5.append("\n");
                                    }
                                    exceptionMessage.mSlowOperation = sb5.toString();
                                }
                            }
                            if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                                sb = new StringBuilder();
                                sb.append(readLine);
                                sb.append("\n");
                            } else {
                                sb = new StringBuilder();
                                sb.append(exceptionMessage.mGCInfo);
                                sb.append(readLine);
                                sb.append("\n");
                            }
                            exceptionMessage.mGCInfo = sb.toString();
                        } else {
                            exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                            z = true;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
    }

    @SuppressLint({"CheckResult"})
    public final void z(File file) {
        com.kwad.sdk.core.e.b.d("ExceptionCollector", "reportException dir =" + file);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.d.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.getName().endsWith(".dump");
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                a(file2, (CountDownLatch) null);
            }
        }
    }
}
