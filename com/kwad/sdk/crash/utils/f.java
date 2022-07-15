package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f {
    public static final File a = new File("/proc/self/fd");
    public static final File b = new File("/proc/self/task");

    public static double a(long j) {
        return BigDecimal.valueOf(((float) (j >> 20)) / 1024.0f).setScale(2, 4).floatValue();
    }

    public static int a() {
        File[] listFiles;
        aj.a(a);
        if (a.exists() && a.isDirectory() && (listFiles = a.listFiles()) != null) {
            return listFiles.length;
        }
        return 0;
    }

    public static String a(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("apk.json");
            return new JSONObject(g.b(inputStream)).getString("task_id");
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.b(e);
            return "";
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.b(e2);
            return "";
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.b(th);
            return "";
        } finally {
            b.a(inputStream);
        }
    }

    public static String a(String str) {
        return str.contains(".") ? str.substring(0, str.lastIndexOf(46)) : str;
    }

    public static String a(@NonNull String str, String str2) {
        aj.a(str);
        return !str.endsWith(str2) ? str : str.substring(0, str.lastIndexOf(str2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.io.StringWriter */
    /* JADX WARN: Multi-variable type inference failed */
    public static String a(Throwable th) {
        StringWriter stringWriter;
        String th2 = th.toString();
        PrintWriter printWriter = null;
        try {
            try {
                stringWriter = new StringWriter();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            printWriter = new PrintWriter(stringWriter);
            e.a(th, printWriter);
            th2 = stringWriter.toString();
            b.a(stringWriter);
        } catch (Exception e2) {
            e = e2;
            printWriter = stringWriter;
            com.kwad.sdk.core.d.b.b(e);
            b.a(printWriter);
            return th2;
        } catch (Throwable th4) {
            th = th4;
            printWriter = stringWriter;
            b.a(printWriter);
            throw th;
        }
        return th2;
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        return a(stackTraceElementArr, 0);
    }

    public static String a(StackTraceElement[] stackTraceElementArr, int i) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("at ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        return sb.substring(0);
    }

    public static void a(@NonNull ExceptionMessage exceptionMessage) {
        exceptionMessage.mVirtualApp = com.kwad.sdk.crash.d.a().d();
        exceptionMessage.mVersionCode = com.kwad.sdk.crash.d.a().e();
    }

    public static void a(ExceptionMessage exceptionMessage, int i) {
        com.kwad.sdk.crash.g h = com.kwad.sdk.crash.d.a().h();
        if (h == null) {
            com.kwad.sdk.core.d.b.a("tag", "getter is null!");
        } else {
            exceptionMessage.mCustomMsg = h.a().toString();
        }
    }

    public static void a(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (exceptionMessage instanceof JavaExceptionMessage) {
            if ("Unknown".equals(exceptionMessage.mThreadName)) {
                exceptionMessage.mThreadName = Thread.currentThread().getName();
            }
            exceptionMessage.mTid = Process.myTid();
        }
        if (context != null) {
            String b2 = SystemUtil.b(context);
            if (!TextUtils.isEmpty(b2)) {
                exceptionMessage.mProcessName = b2;
            }
        }
        exceptionMessage.mPid = Process.myPid();
        exceptionMessage.mCurrentTimeStamp = System.currentTimeMillis();
        exceptionMessage.mUsageTimeMills = com.kwad.sdk.crash.d.a().i();
        exceptionMessage.mAbi = AbiUtil.b(context) ? "arm64" : "arm";
        exceptionMessage.mVersionConflict = TextUtils.equals(exceptionMessage.mVersionCode, ExceptionMessage.getSdkCrashVersionName("1.0", com.kwad.sdk.crash.d.a().f()));
        exceptionMessage.mBuildConfigInfo = b(context);
        a(exceptionMessage);
        b(exceptionMessage, context);
        exceptionMessage.mTaskId = a(context);
    }

    public static void a(ExceptionMessage exceptionMessage, DiskInfo diskInfo) {
        File externalStorageDirectory;
        try {
            String path = Environment.getDataDirectory().getPath();
            diskInfo.mDataTotalGB = a(g.b(path));
            if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(1024L)) {
                diskInfo.mDataAvailableGB = a(g.a(path));
            }
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                diskInfo.mExternalStorageTotalGB = a(g.b(externalStorageDirectory.getPath()));
                if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(1024L)) {
                    diskInfo.mExternalStorageAvailableGB = a(g.a(externalStorageDirectory.getPath()));
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    public static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo) {
        if (memoryInfo.mPssMB * 2 > memoryInfo.mTotalMB || (!AbiUtil.b(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a()) && memoryInfo.mVssMB > 3686.4d)) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    public static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, @Nullable Context context) {
        List<String> list;
        String canonicalPath;
        SystemUtil.a c = SystemUtil.c();
        c.e = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        c.a = SystemUtil.a();
        long pss = Debug.getPss();
        c.d = pss;
        memoryInfo.mTotalMB = (int) (c.a / 1048576);
        memoryInfo.mJavaHeapLimitMB = (int) (com.kwad.sdk.crash.c.a / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (c.e / 1048576);
        memoryInfo.mVssMB = (int) (c.b / 1024);
        memoryInfo.mRssMB = (int) (c.c / 1024);
        memoryInfo.mPssMB = (int) (pss / 1024);
        memoryInfo.mThreadsCount = c.f;
        memoryInfo.mFdCount = a();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.d(context) / 1048576);
        }
        exceptionMessage.mFdOverflow = "False";
        if (memoryInfo.mFdCount > 800) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeFdOOM();
            exceptionMessage.mFdOverflow = "True";
            File[] listFiles = a.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    try {
                        if (Build.VERSION.SDK_INT >= 21) {
                            list = memoryInfo.mFds;
                            canonicalPath = Os.readlink(file.getPath());
                        } else {
                            list = memoryInfo.mFds;
                            canonicalPath = file.getCanonicalPath();
                        }
                        list.add(canonicalPath);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.b(e);
                    }
                }
                Collections.sort(memoryInfo.mFds);
            }
        }
        exceptionMessage.mThreadOverflow = "False";
        if (c.f > 400) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeThreadOOM();
            exceptionMessage.mThreadOverflow = "True";
            a(memoryInfo);
            Collections.sort(memoryInfo.mAllThreads, new Comparator<ThreadInfo>() { // from class: com.kwad.sdk.crash.utils.f.1
                public static int a(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return threadInfo.mName.compareTo(threadInfo2.mName);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return a(threadInfo, threadInfo2);
                }
            });
        }
        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
    }

    public static void a(MemoryInfo memoryInfo) {
        File[] listFiles = b.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = g.a(new File(file, "comm"));
            } catch (IOException e) {
                com.kwad.sdk.core.d.b.b(e);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = a(threadInfo.mName, "\n");
                memoryInfo.mAllThreads.add(threadInfo);
            }
        }
    }

    public static void a(com.kwad.sdk.crash.report.e eVar, String str, File file) {
        String readLine;
        try {
            o.c(file);
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    if (eVar != null) {
                        do {
                            try {
                                readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                            } catch (FileNotFoundException e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.d.b.b(e);
                                b.a(bufferedReader);
                                return;
                            } catch (IOException e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.d.b.b(e);
                                b.a(bufferedReader);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                b.a(bufferedReader);
                                throw th;
                            }
                        } while (!readLine.isEmpty());
                    }
                    b.a(bufferedReader2);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (IOException e5) {
            com.kwad.sdk.core.d.b.b(e5);
        }
    }

    public static void a(File file) {
        try {
            c.a(SystemUtil.a(21) ? new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", "events", "-b", "crash", "-d", "-f", file.getPath()} : new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", "events", "-d", "-f", file.getPath()}, 0);
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.b(e);
        }
    }

    public static void a(File file, File file2) {
        BufferedReader bufferedReader;
        try {
            o.c(file);
            o.c(file2);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2, true));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                bufferedWriter2.write(readLine);
                                bufferedWriter2.newLine();
                            } catch (FileNotFoundException e) {
                                e = e;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.b.b(e);
                                b.a(bufferedWriter);
                                b.a(bufferedReader);
                            } catch (IOException e2) {
                                e = e2;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.b.b(e);
                                b.a(bufferedWriter);
                                b.a(bufferedReader);
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                b.a(bufferedWriter);
                                b.a(bufferedReader);
                                throw th;
                            }
                        }
                        b.a(bufferedWriter2);
                    } catch (FileNotFoundException e3) {
                        e = e3;
                    } catch (IOException e4) {
                        e = e4;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                bufferedReader = null;
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
            b.a(bufferedReader);
        } catch (IOException e7) {
            com.kwad.sdk.core.d.b.b(e7);
        }
    }

    public static void a(File file, CharSequence charSequence) {
        a(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void a(File file, CharSequence charSequence, Charset charset, boolean z) {
        a(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    public static void a(File file, CharSequence charSequence, boolean z) {
        a(file, charSequence, Charset.defaultCharset(), true);
    }

    public static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = o.a(file, z);
            g.a(str, fileOutputStream, charset);
            a(fileOutputStream);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
        } finally {
            b.a(fileOutputStream);
        }
    }

    public static void a(Throwable th, ExceptionMessage exceptionMessage) {
        if (b(th) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    public static void a(@Nullable Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (th != null) {
            b(th, exceptionMessage);
        }
        a(exceptionMessage, context);
        MemoryInfo memoryInfo = new MemoryInfo();
        a(exceptionMessage, memoryInfo, context);
        a(exceptionMessage, new DiskInfo());
        if (exceptionMessage instanceof NativeExceptionMessage) {
            a(exceptionMessage, memoryInfo);
        } else if (exceptionMessage instanceof JavaExceptionMessage) {
            a(th, exceptionMessage);
        }
    }

    public static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
                return true;
            } catch (IOException e) {
                com.kwad.sdk.core.d.b.b(e);
                return false;
            }
        }
        return true;
    }

    public static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("BuildConfig Version Name: " + com.kwad.sdk.crash.d.a().e() + "\n");
            sb.append("PackageInfo CodePath: " + context.getPackageCodePath() + "\n");
            sb.append("PackageInfo ResPath: " + context.getPackageResourcePath() + "\n");
            sb.append("DexPath: " + c(context) + "\n");
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
        }
        return sb.toString();
    }

    public static String b(String str) {
        return (str.contains("(") && str.contains(SmallTailInfo.EMOTION_SUFFIX)) ? str.substring(str.lastIndexOf(40) + 1, str.lastIndexOf(41)) : str;
    }

    public static void b(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        String absolutePath;
        String packageName;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.b(e);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (com.kwad.sdk.crash.c.b.matcher(absolutePath).matches() || com.kwad.sdk.crash.c.c.matcher(absolutePath).matches()) {
            packageName = context.getPackageName();
        } else {
            Matcher matcher = com.kwad.sdk.crash.c.d.matcher(absolutePath);
            Matcher matcher2 = com.kwad.sdk.crash.c.e.matcher(absolutePath);
            if (matcher.matches()) {
                packageName = matcher.group(1);
            } else if (!matcher2.matches()) {
                exceptionMessage.mVirtualApp = absolutePath;
                return;
            } else {
                packageName = matcher2.group(1);
            }
        }
        exceptionMessage.mVirtualApp = packageName;
    }

    public static void b(File file) {
        if (file == null) {
            return;
        }
        try {
            o.f(file);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
        }
    }

    public static void b(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage) {
        String a2 = a(th);
        if (th instanceof StackOverflowError) {
            a2 = e(a2);
        }
        exceptionMessage.mCrashDetail = a2.replaceAll("[\n\t]", "#");
    }

    public static boolean b(@Nullable Throwable th) {
        if (th == null) {
            return false;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th instanceof OutOfMemoryError;
    }

    public static int c(String str) {
        if (str.contains("-")) {
            return Integer.parseInt(str.substring(str.lastIndexOf(45)));
        }
        return -1;
    }

    public static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            String obj = classLoader.toString();
            StringBuilder sb2 = new StringBuilder("ClassLoader ");
            int i = 0;
            sb2.append(0);
            sb2.append(ZeusCrashHandler.NAME_SEPERATOR);
            sb2.append(obj);
            while (true) {
                sb.append(sb2.toString());
                if (classLoader.getParent() == null) {
                    break;
                }
                classLoader = classLoader.getParent();
                i++;
                sb2 = new StringBuilder("\nClassLoader ");
                sb2.append(i);
                sb2.append(ZeusCrashHandler.NAME_SEPERATOR);
                sb2.append(classLoader.toString());
            }
            if (obj != null) {
                String[] split = obj.split("\"");
                if (split.length >= 2) {
                    sb.append("\n====path: " + split[1] + ", length: " + d(split[1]));
                }
            }
        }
        return sb.toString();
    }

    public static void c(File file) {
        BufferedWriter bufferedWriter;
        try {
            o.c(file);
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                    String a2 = a(entry.getValue());
                    if (a2.isEmpty()) {
                        a2 = "(no managed stack frames)\n";
                    }
                    bufferedWriter.write(entry.getKey().getName());
                    bufferedWriter.newLine();
                    bufferedWriter.write(a2);
                    bufferedWriter.newLine();
                }
                b.a(bufferedWriter);
            } catch (FileNotFoundException e3) {
                e = e3;
                bufferedWriter2 = bufferedWriter;
                com.kwad.sdk.core.d.b.b(e);
                b.a(bufferedWriter2);
            } catch (IOException e4) {
                e = e4;
                bufferedWriter2 = bufferedWriter;
                com.kwad.sdk.core.d.b.b(e);
                b.a(bufferedWriter2);
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter2 = bufferedWriter;
                b.a(bufferedWriter2);
                throw th;
            }
        } catch (IOException e5) {
            com.kwad.sdk.core.d.b.b(e5);
        }
    }

    public static long d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length();
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static void d(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object a2 = q.a(q.a("android.app.ActivityThread", "currentActivityThread", new Object[0]), "mAppThread");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 1006632960);
            FileDescriptor fileDescriptor = open;
            if (!SystemUtil.a(26)) {
                fileDescriptor = open.getFileDescriptor();
            }
            if (SystemUtil.a(24)) {
                q.a(a2, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, new String[0]);
            } else if (SystemUtil.a(23)) {
                q.a(a2, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, new String[0]);
            } else if (SystemUtil.a(19)) {
                q.a(a2, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, new String[0]);
            }
            ParcelFileDescriptor open2 = ParcelFileDescriptor.open(file, 973078528);
            FileDescriptor fileDescriptor2 = open2;
            if (!SystemUtil.a(26)) {
                fileDescriptor2 = open2.getFileDescriptor();
            }
            q.a(a2, "dumpGfxInfo", fileDescriptor2, new String[]{SystemUtil.b(com.kwad.sdk.crash.d.a().g())});
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
        }
    }

    public static String e(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : str.split("\n")) {
            hashSet.add(str2);
        }
        ArrayList<String> arrayList = new ArrayList(hashSet);
        StringBuilder sb = new StringBuilder();
        for (String str3 : arrayList) {
            sb.append(str3);
            sb.append("\n");
        }
        return sb.substring(0);
    }
}
