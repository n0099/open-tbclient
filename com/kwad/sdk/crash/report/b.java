package com.kwad.sdk.crash.report;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.crash.utils.f;
import com.kwad.sdk.crash.utils.h;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected c f9648a;

    /* renamed from: b  reason: collision with root package name */
    protected String f9649b = "";

    private String a(String str) {
        return (str == null || !str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) ? str : str.substring(0, str.lastIndexOf(45));
    }

    protected abstract ExceptionMessage a(@NonNull File file, File file2, File file3, String str);

    public void a(c cVar) {
        this.f9648a = cVar;
    }

    @SuppressLint({"CheckResult"})
    public void a(File file) {
        com.kwad.sdk.core.d.a.a("ExceptionCollector", "reportException dir =" + file);
        for (File file2 : file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.b.1
            @Override // java.io.FileFilter
            public boolean accept(File file3) {
                return file3.getName().endsWith(".dump");
            }
        })) {
            b(file2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(File file, ExceptionMessage exceptionMessage) {
        BufferedReader bufferedReader;
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        ThreadInfo threadInfo = new ThreadInfo();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                memoryInfo.mJavaThreads = arrayList;
                                exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                                com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                                return;
                            } else if (readLine.isEmpty()) {
                                arrayList.add(threadInfo);
                                threadInfo = new ThreadInfo();
                            } else if (readLine.startsWith("at ") || readLine.startsWith("(no ")) {
                                if (threadInfo.mTrace != null) {
                                    readLine = threadInfo.mTrace + readLine;
                                }
                                threadInfo.mTrace = readLine;
                                threadInfo.mTrace += "#";
                            } else {
                                threadInfo.mName = readLine;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        com.kwad.sdk.core.d.a.b(e);
                        com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.a((Reader) null);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.a((Reader) null);
                throw th;
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.b(e3);
        }
    }

    public void b(File file) {
        String a2 = f.a(file.getPath());
        File file2 = new File(a2 + ".msg");
        File file3 = new File(a2 + BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        File file4 = new File(a2 + ".blog");
        File file5 = new File(a2 + ".jtrace");
        ArrayList<File> arrayList = new ArrayList();
        try {
            ExceptionMessage a3 = a(file, file2, file3, a2);
            this.f9648a.a(a3);
            f.a(file4);
            ArrayList arrayList2 = new ArrayList();
            Collections.addAll(arrayList2, file3, file4);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                if (!((File) it.next()).exists()) {
                    it.remove();
                }
            }
            File file6 = new File(file.getParentFile().getParent(), "custom");
            if (file6.exists()) {
                File[] listFiles = file6.listFiles();
                for (File file7 : listFiles) {
                    if (!file7.isDirectory() && (file7.getName().startsWith(a3.mLogUUID) || file7.getName().startsWith(a(a3.mLogUUID)))) {
                        arrayList.add(file7);
                    }
                }
                arrayList2.addAll(arrayList);
            }
            try {
                h.b(file.getPath());
                h.b(file3.getPath());
                h.b(file4.getPath());
                for (File file8 : arrayList) {
                    h.b(file8.getPath());
                }
                h.b(file5.getPath());
                f.b(com.kwad.sdk.crash.c.b.f9632b);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        } catch (Throwable th2) {
            try {
                com.kwad.sdk.core.d.a.b(th2);
                this.f9648a.b("report_ex_error", f.a(th2));
                try {
                    h.b(file.getPath());
                    h.b(file3.getPath());
                    h.b(file4.getPath());
                    for (File file9 : arrayList) {
                        h.b(file9.getPath());
                    }
                    h.b(file5.getPath());
                    f.b(com.kwad.sdk.crash.c.b.f9632b);
                } catch (Throwable th3) {
                    com.kwad.sdk.core.d.a.b(th3);
                }
            } catch (Throwable th4) {
                try {
                    h.b(file.getPath());
                    h.b(file3.getPath());
                    h.b(file4.getPath());
                    for (File file10 : arrayList) {
                        h.b(file10.getPath());
                    }
                    h.b(file5.getPath());
                    f.b(com.kwad.sdk.crash.c.b.f9632b);
                } catch (Throwable th5) {
                    com.kwad.sdk.core.d.a.b(th5);
                }
                throw th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(File file, ExceptionMessage exceptionMessage) {
        BufferedReader bufferedReader;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                boolean z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                            return;
                        } else if (!z && readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                            exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                            z = true;
                        } else if (readLine.contains("Waiting for a blocking GC ") || readLine.contains("WaitForGcToComplete")) {
                            exceptionMessage.mGCInfo = TextUtils.isEmpty(exceptionMessage.mGCInfo) ? readLine + "\n" : exceptionMessage.mGCInfo + readLine + "\n";
                        } else if (readLine.contains("dvm_lock_sample")) {
                            exceptionMessage.mLockInfo = TextUtils.isEmpty(exceptionMessage.mLockInfo) ? readLine + "\n" : exceptionMessage.mLockInfo + readLine + "\n";
                        } else if (readLine.contains("Long monitor")) {
                            exceptionMessage.mMonitorInfo = TextUtils.isEmpty(exceptionMessage.mMonitorInfo) ? readLine + "\n" : exceptionMessage.mMonitorInfo + readLine + "\n";
                        } else if (readLine.contains("Slow Looper")) {
                            exceptionMessage.mSlowLooper = TextUtils.isEmpty(exceptionMessage.mSlowLooper) ? readLine + "\n" : exceptionMessage.mSlowLooper + readLine + "\n";
                        } else if (readLine.contains("Slow Operation")) {
                            exceptionMessage.mSlowOperation = TextUtils.isEmpty(exceptionMessage.mSlowOperation) ? readLine + "\n" : exceptionMessage.mSlowOperation + readLine + "\n";
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        this.f9649b += e + "\n";
                        com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                        return;
                    } catch (IOException e2) {
                        e = e2;
                        this.f9649b += e + "\n";
                        com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.a((Reader) null);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            bufferedReader = null;
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.a((Reader) null);
            throw th;
        }
    }
}
