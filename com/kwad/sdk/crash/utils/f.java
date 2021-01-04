package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.crash.utils.SystemUtil;
import com.kwad.sdk.utils.n;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final File f9959a = new File("/proc/self/fd");

    /* renamed from: b  reason: collision with root package name */
    private static final File f9960b = new File("/proc/self/task");

    private static int a() {
        File[] listFiles;
        Objects.requireNonNull(f9959a);
        if (f9959a.exists() && f9959a.isDirectory() && (listFiles = f9959a.listFiles()) != null) {
            return listFiles.length;
        }
        return 0;
    }

    private static String a(Context context) {
        String str;
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("apk.json");
            str = new JSONObject(h.a(inputStream)).getString("task_id");
        } catch (IOException e) {
            com.kwad.sdk.core.d.a.b(e);
            str = "";
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.b(e2);
            str = "";
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
            str = "";
        } finally {
            b.a(inputStream);
        }
        return str;
    }

    public static String a(String str) {
        return str.contains(".") ? str.substring(0, str.lastIndexOf(46)) : str;
    }

    public static String a(@NonNull String str, String str2) {
        Objects.requireNonNull(str);
        return !str.endsWith(str2) ? str : str.substring(0, str.lastIndexOf(str2));
    }

    public static String a(Throwable th) {
        StringWriter stringWriter;
        String th2 = th.toString();
        try {
            stringWriter = new StringWriter();
            try {
                try {
                    e.a(th, new PrintWriter(stringWriter));
                    th2 = stringWriter.toString();
                    b.a((Writer) stringWriter);
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.d.a.b(e);
                    b.a((Writer) stringWriter);
                    return th2;
                }
            } catch (Throwable th3) {
                th = th3;
                b.a((Writer) stringWriter);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            stringWriter = null;
        } catch (Throwable th4) {
            th = th4;
            stringWriter = null;
            b.a((Writer) stringWriter);
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
            for (int i2 = 0; i2 < i; i2++) {
                sb.append("\t");
            }
            sb.append("at ").append(stackTraceElement).append('\n');
        }
        return sb.substring(0);
    }

    private static void a(@NonNull ExceptionMessage exceptionMessage) {
        exceptionMessage.mVirtualApp = com.kwad.sdk.crash.d.a().d();
        exceptionMessage.mVersionCode = com.kwad.sdk.crash.d.a().e();
    }

    public static void a(ExceptionMessage exceptionMessage, int i) {
        com.kwad.sdk.crash.f g = com.kwad.sdk.crash.d.a().g();
        if (g == null) {
            com.kwad.sdk.core.d.a.a("tag", "getter is null!");
            return;
        }
        com.kwad.sdk.crash.model.message.a a2 = g.a(i);
        if (a2 != null) {
            exceptionMessage.mCustomMsg = a2.toString();
        }
    }

    private static void a(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (exceptionMessage instanceof JavaExceptionMessage) {
            if ("Unknown".equals(exceptionMessage.mThreadName)) {
                exceptionMessage.mThreadName = Thread.currentThread().getName();
            }
            exceptionMessage.mTid = Process.myTid();
        }
        if (context != null) {
            String a2 = SystemUtil.a(context);
            if (!TextUtils.isEmpty(a2)) {
                exceptionMessage.mProcessName = a2;
            }
        }
        exceptionMessage.mPid = Process.myPid();
        exceptionMessage.mCurrentTimeStamp = System.currentTimeMillis();
        exceptionMessage.mUsageTimeMills = com.kwad.sdk.crash.d.a().h();
        exceptionMessage.mAbi = AbiUtil.b() ? "arm64" : "arm";
        exceptionMessage.mVersionConflict = TextUtils.equals(exceptionMessage.mVersionCode, "3.3.9");
        exceptionMessage.mBuildConfigInfo = b(context);
        a(exceptionMessage);
        b(exceptionMessage, context);
        exceptionMessage.mTaskId = a(context);
    }

    private static void a(ExceptionMessage exceptionMessage, DiskInfo diskInfo, @Nullable Context context) {
        File externalStorageDirectory;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            diskInfo.mDataTotalGB = BigDecimal.valueOf(((float) (statFs.getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).floatValue();
            diskInfo.mDataAvailableGB = BigDecimal.valueOf(((float) (statFs.getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).floatValue();
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                StatFs statFs2 = new StatFs(externalStorageDirectory.getPath());
                diskInfo.mExternalStorageTotalGB = BigDecimal.valueOf(((float) (statFs2.getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).floatValue();
                diskInfo.mExternalStorageAvailableGB = BigDecimal.valueOf(((float) (statFs2.getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).floatValue();
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, @Nullable Context context) {
        SystemUtil.a c = SystemUtil.c();
        c.e = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        c.f9955a = SystemUtil.a();
        c.d = Debug.getPss();
        memoryInfo.mTotalMB = (int) (c.f9955a / 1048576);
        memoryInfo.mJavaHeapLimitMB = (int) (com.kwad.sdk.crash.c.f9926a / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (c.e / 1048576);
        memoryInfo.mVssMB = (int) (c.f9956b / 1024);
        memoryInfo.mRssMB = (int) (c.c / 1024);
        memoryInfo.mPssMB = (int) (c.d / 1024);
        memoryInfo.mThreadsCount = c.f;
        memoryInfo.mFdCount = a();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.b(context) / 1048576);
        }
        exceptionMessage.mFdOverflow = "False";
        if (memoryInfo.mFdCount > 800) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeFdOOM();
            exceptionMessage.mFdOverflow = "True";
            File[] listFiles = f9959a.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    try {
                        if (Build.VERSION.SDK_INT >= 21) {
                            memoryInfo.mFds.add(Os.readlink(file.getPath()));
                        } else {
                            memoryInfo.mFds.add(file.getCanonicalPath());
                        }
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.a.b(e);
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
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return threadInfo.mName.compareTo(threadInfo2.mName);
                }
            });
        }
        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
    }

    private static void a(MemoryInfo memoryInfo) {
        File[] listFiles = f9960b.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = h.a(new File(file, "comm"));
            } catch (IOException e) {
                com.kwad.sdk.core.d.a.b(e);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = a(threadInfo.mName, "\n");
                memoryInfo.mAllThreads.add(threadInfo);
            }
        }
    }

    public static void a(File file) {
        try {
            c.a(SystemUtil.a(21) ? new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", "events", "-b", "crash", "-d", "-f", file.getPath()} : new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", "events", "-d", "-f", file.getPath()}, 0);
        } catch (IOException e) {
            com.kwad.sdk.core.d.a.b(e);
        }
    }

    public static void a(File file, File file2) {
        BufferedReader bufferedReader;
        Writer writer;
        BufferedWriter bufferedWriter;
        try {
            try {
                e(file);
                e(file2);
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                } catch (FileNotFoundException e) {
                    e = e;
                    bufferedWriter = null;
                    bufferedReader = null;
                } catch (IOException e2) {
                    e = e2;
                    bufferedWriter = null;
                    bufferedReader = null;
                } catch (Throwable th) {
                    th = th;
                    writer = null;
                    bufferedReader = null;
                }
            } catch (IOException e3) {
                com.kwad.sdk.core.d.a.b(e3);
                return;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file2, true));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        b.a((Writer) bufferedWriter);
                        b.a((Reader) bufferedReader);
                        return;
                    }
                    bufferedWriter.write(readLine);
                    bufferedWriter.newLine();
                } catch (FileNotFoundException e4) {
                    e = e4;
                    com.kwad.sdk.core.d.a.b(e);
                    b.a((Writer) bufferedWriter);
                    b.a((Reader) bufferedReader);
                    return;
                } catch (IOException e5) {
                    e = e5;
                    com.kwad.sdk.core.d.a.b(e);
                    b.a((Writer) bufferedWriter);
                    b.a((Reader) bufferedReader);
                    return;
                }
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            bufferedWriter = null;
        } catch (IOException e7) {
            e = e7;
            bufferedWriter = null;
        } catch (Throwable th3) {
            th = th3;
            writer = null;
            b.a(writer);
            b.a((Reader) bufferedReader);
            throw th;
        }
    }

    public static void a(File file, CharSequence charSequence) {
        a(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void a(File file, CharSequence charSequence, Charset charset, boolean z) {
        a(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    public static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = g.a(file, z);
            h.a(str, fileOutputStream, charset);
            a(fileOutputStream);
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        } finally {
            b.a((OutputStream) fileOutputStream);
        }
    }

    public static void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage) {
        String a2 = a(th);
        if (th instanceof StackOverflowError) {
            a2 = c(a2);
        }
        exceptionMessage.mCrashDetail = a2.replaceAll("[\n\t]", "#");
    }

    public static void a(@Nullable Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (th != null) {
            a(th, exceptionMessage);
        }
        a(exceptionMessage, context);
        a(exceptionMessage, new MemoryInfo(), context);
        a(exceptionMessage, new DiskInfo(), context);
        if (exceptionMessage instanceof JavaExceptionMessage) {
            b(th, exceptionMessage);
        }
    }

    public static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
                com.kwad.sdk.core.d.a.b(e);
                return false;
            }
        }
        return true;
    }

    public static long b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length();
            }
            return -1L;
        } catch (Exception e) {
            return -1L;
        }
    }

    private static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("BuildConfig Version Name: 3.3.9\n");
            sb.append("PackageInfo CodePath: " + context.getPackageCodePath() + "\n");
            sb.append("PackageInfo ResPath: " + context.getPackageResourcePath() + "\n");
            sb.append("DexPath: " + c(context) + "\n");
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
        return sb.toString();
    }

    private static void b(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        String absolutePath;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e) {
            com.kwad.sdk.core.d.a.b(e);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (com.kwad.sdk.crash.c.f9927b.matcher(absolutePath).matches() || com.kwad.sdk.crash.c.c.matcher(absolutePath).matches()) {
            exceptionMessage.mVirtualApp = context.getPackageName();
            return;
        }
        Matcher matcher = com.kwad.sdk.crash.c.d.matcher(absolutePath);
        Matcher matcher2 = com.kwad.sdk.crash.c.e.matcher(absolutePath);
        if (matcher.matches()) {
            exceptionMessage.mVirtualApp = matcher.group(1);
        } else if (matcher2.matches()) {
            exceptionMessage.mVirtualApp = matcher2.group(1);
        } else {
            exceptionMessage.mVirtualApp = absolutePath;
        }
    }

    public static void b(File file) {
        if (file == null) {
            return;
        }
        try {
            g.c(file);
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
    }

    private static void b(Throwable th, ExceptionMessage exceptionMessage) {
        if (b(th) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static boolean b(@Nullable Throwable th) {
        if (th == null) {
            return false;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th instanceof OutOfMemoryError;
    }

    private static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        int i = 0;
        if (classLoader != null) {
            String obj = classLoader.toString();
            sb.append("ClassLoader 0 : " + obj);
            while (classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
                i++;
                sb.append("\nClassLoader " + i + " : " + classLoader.toString());
            }
            if (obj != null) {
                String[] split = obj.split("\"");
                if (split.length >= 2) {
                    sb.append("\n====path: " + split[1] + ", length: " + b(split[1]));
                }
            }
        }
        return sb.toString();
    }

    public static String c(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : str.split("\n")) {
            hashSet.add(str2);
        }
        ArrayList<String> arrayList = new ArrayList(hashSet);
        StringBuilder sb = new StringBuilder();
        for (String str3 : arrayList) {
            sb.append(str3).append("\n");
        }
        return sb.substring(0);
    }

    public static void c(File file) {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        try {
            e(file);
            BufferedWriter bufferedWriter3 = null;
            try {
                try {
                    bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
                    try {
                        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                            String a2 = a(entry.getValue());
                            if (a2.isEmpty()) {
                                a2 = "(no managed stack frames)\n";
                            }
                            bufferedWriter2.write(entry.getKey().getName());
                            bufferedWriter2.newLine();
                            bufferedWriter2.write(a2);
                            bufferedWriter2.newLine();
                        }
                        b.a((Writer) bufferedWriter2);
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedWriter3 = bufferedWriter2;
                        try {
                            com.kwad.sdk.core.d.a.b(e);
                            b.a((Writer) bufferedWriter3);
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter = bufferedWriter3;
                            b.a((Writer) bufferedWriter);
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        com.kwad.sdk.core.d.a.b(e);
                        b.a((Writer) bufferedWriter2);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    b.a((Writer) bufferedWriter);
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
                bufferedWriter2 = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = null;
                b.a((Writer) bufferedWriter);
                throw th;
            }
        } catch (IOException e5) {
            com.kwad.sdk.core.d.a.b(e5);
        }
    }

    public static void d(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object a2 = n.a(n.a("android.app.ActivityThread", "currentActivityThread", new Object[0]), "mAppThread");
            Object open = ParcelFileDescriptor.open(file, 1006632960);
            if (!SystemUtil.a(26)) {
                open = ((ParcelFileDescriptor) open).getFileDescriptor();
            }
            if (SystemUtil.a(24)) {
                n.a(a2, "dumpMemInfo", open, memoryInfo, false, true, true, false, false, new String[0]);
            } else if (SystemUtil.a(23)) {
                n.a(a2, "dumpMemInfo", open, memoryInfo, false, true, true, false, new String[0]);
            } else if (SystemUtil.a(19)) {
                n.a(a2, "dumpMemInfo", open, memoryInfo, false, true, true, new String[0]);
            }
            Object open2 = ParcelFileDescriptor.open(file, 973078528);
            if (!SystemUtil.a(26)) {
                open2 = ((ParcelFileDescriptor) open2).getFileDescriptor();
            }
            n.a(a2, "dumpGfxInfo", open2, new String[]{SystemUtil.a(com.kwad.sdk.crash.d.a().f())});
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
    }

    private static void e(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            throw new IOException("Could not find parent directory");
        }
        if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Directory '" + parentFile + "' could not be created");
        }
        file.createNewFile();
    }
}
