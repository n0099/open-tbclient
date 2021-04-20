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
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.crash.utils.SystemUtil;
import com.kwad.sdk.utils.n;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final File f34781a = new File("/proc/self/fd");

    /* renamed from: b  reason: collision with root package name */
    public static final File f34782b = new File("/proc/self/task");

    public static int a() {
        File[] listFiles;
        Objects.requireNonNull(f34781a);
        if (f34781a.exists() && f34781a.isDirectory() && (listFiles = f34781a.listFiles()) != null) {
            return listFiles.length;
        }
        return 0;
    }

    public static String a(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("apk.json");
            return new JSONObject(h.a(inputStream)).getString("task_id");
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
            return "";
        } catch (JSONException e3) {
            com.kwad.sdk.core.d.a.b(e3);
            return "";
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
            return "";
        } finally {
            b.a(inputStream);
        }
    }

    public static String a(String str) {
        return str.contains(".") ? str.substring(0, str.lastIndexOf(46)) : str;
    }

    public static String a(@NonNull String str, String str2) {
        Objects.requireNonNull(str);
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
        } catch (Exception e2) {
            e = e2;
        }
        try {
            printWriter = new PrintWriter(stringWriter);
            e.a(th, printWriter);
            th2 = stringWriter.toString();
            b.a((Writer) stringWriter);
        } catch (Exception e3) {
            e = e3;
            printWriter = stringWriter;
            com.kwad.sdk.core.d.a.b(e);
            b.a((Writer) printWriter);
            return th2;
        } catch (Throwable th4) {
            th = th4;
            printWriter = stringWriter;
            b.a((Writer) printWriter);
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
                sb.append(TrackUI.SEPERATOR);
            }
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
        com.kwad.sdk.crash.f g2 = com.kwad.sdk.crash.d.a().g();
        if (g2 == null) {
            com.kwad.sdk.core.d.a.a("tag", "getter is null!");
            return;
        }
        com.kwad.sdk.crash.model.message.a a2 = g2.a(i);
        if (a2 != null) {
            exceptionMessage.mCustomMsg = a2.toString();
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

    public static void a(ExceptionMessage exceptionMessage, DiskInfo diskInfo, @Nullable Context context) {
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
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    public static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, @Nullable Context context) {
        List<String> list;
        String canonicalPath;
        SystemUtil.a c2 = SystemUtil.c();
        c2.f34777e = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        c2.f34773a = SystemUtil.a();
        long pss = Debug.getPss();
        c2.f34776d = pss;
        memoryInfo.mTotalMB = (int) (c2.f34773a / 1048576);
        memoryInfo.mJavaHeapLimitMB = (int) (com.kwad.sdk.crash.c.f34722a / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (c2.f34777e / 1048576);
        memoryInfo.mVssMB = (int) (c2.f34774b / 1024);
        memoryInfo.mRssMB = (int) (c2.f34775c / 1024);
        memoryInfo.mPssMB = (int) (pss / 1024);
        memoryInfo.mThreadsCount = c2.f34778f;
        memoryInfo.mFdCount = a();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.b(context) / 1048576);
        }
        exceptionMessage.mFdOverflow = "False";
        if (memoryInfo.mFdCount > 800) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeFdOOM();
            exceptionMessage.mFdOverflow = "True";
            File[] listFiles = f34781a.listFiles();
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
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.b(e2);
                    }
                }
                Collections.sort(memoryInfo.mFds);
            }
        }
        exceptionMessage.mThreadOverflow = "False";
        if (c2.f34778f > 400) {
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

    public static void a(MemoryInfo memoryInfo) {
        File[] listFiles = f34782b.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = h.a(new File(file, "comm"));
            } catch (IOException e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = a(threadInfo.mName, "\n");
                memoryInfo.mAllThreads.add(threadInfo);
            }
        }
    }

    public static void a(File file) {
        try {
            c.a(SystemUtil.a(21) ? new String[]{"logcat", "-v", "threadtime", "-b", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT, "-b", "system", "-b", "events", "-b", "crash", "-d", "-f", file.getPath()} : new String[]{"logcat", "-v", "threadtime", "-b", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT, "-b", "system", "-b", "events", "-d", "-f", file.getPath()}, 0);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public static void a(File file, File file2) {
        BufferedReader bufferedReader;
        try {
            e(file);
            e(file2);
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
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.a.b(e);
                                b.a((Writer) bufferedWriter);
                                b.a((Reader) bufferedReader);
                            } catch (IOException e3) {
                                e = e3;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.a.b(e);
                                b.a((Writer) bufferedWriter);
                                b.a((Reader) bufferedReader);
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                b.a((Writer) bufferedWriter);
                                b.a((Reader) bufferedReader);
                                throw th;
                            }
                        }
                        b.a((Writer) bufferedWriter2);
                    } catch (FileNotFoundException e4) {
                        e = e4;
                    } catch (IOException e5) {
                        e = e5;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = null;
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
            b.a((Reader) bufferedReader);
        } catch (IOException e8) {
            com.kwad.sdk.core.d.a.b(e8);
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
            try {
                fileOutputStream = g.a(file, z);
                h.a(str, fileOutputStream, charset);
                a(fileOutputStream);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
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
                return true;
            } catch (IOException e2) {
                com.kwad.sdk.core.d.a.b(e2);
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
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("BuildConfig Version Name: 3.3.9\n");
            sb.append("PackageInfo CodePath: " + context.getPackageCodePath() + "\n");
            sb.append("PackageInfo ResPath: " + context.getPackageResourcePath() + "\n");
            sb.append("DexPath: " + c(context) + "\n");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        return sb.toString();
    }

    public static void b(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        String absolutePath;
        String group;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (com.kwad.sdk.crash.c.f34723b.matcher(absolutePath).matches() || com.kwad.sdk.crash.c.f34724c.matcher(absolutePath).matches()) {
            exceptionMessage.mVirtualApp = context.getPackageName();
            return;
        }
        Matcher matcher = com.kwad.sdk.crash.c.f34725d.matcher(absolutePath);
        Matcher matcher2 = com.kwad.sdk.crash.c.f34726e.matcher(absolutePath);
        if (matcher.matches()) {
            group = matcher.group(1);
        } else if (!matcher2.matches()) {
            exceptionMessage.mVirtualApp = absolutePath;
            return;
        } else {
            group = matcher2.group(1);
        }
        exceptionMessage.mVirtualApp = group;
    }

    public static void b(File file) {
        if (file == null) {
            return;
        }
        try {
            g.c(file);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public static void b(Throwable th, ExceptionMessage exceptionMessage) {
        if (b(th) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
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

    public static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            String obj = classLoader.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ClassLoader ");
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
                sb2 = new StringBuilder();
                sb2.append("\nClassLoader ");
                sb2.append(i);
                sb2.append(ZeusCrashHandler.NAME_SEPERATOR);
                sb2.append(classLoader.toString());
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
            sb.append(str3);
            sb.append("\n");
        }
        return sb.substring(0);
    }

    public static void c(File file) {
        BufferedWriter bufferedWriter;
        try {
            e(file);
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
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
                b.a((Writer) bufferedWriter);
            } catch (FileNotFoundException e4) {
                e = e4;
                bufferedWriter2 = bufferedWriter;
                com.kwad.sdk.core.d.a.b(e);
                b.a((Writer) bufferedWriter2);
            } catch (IOException e5) {
                e = e5;
                bufferedWriter2 = bufferedWriter;
                com.kwad.sdk.core.d.a.b(e);
                b.a((Writer) bufferedWriter2);
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter2 = bufferedWriter;
                b.a((Writer) bufferedWriter2);
                throw th;
            }
        } catch (IOException e6) {
            com.kwad.sdk.core.d.a.b(e6);
        }
    }

    public static void d(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object a2 = n.a(n.a("android.app.ActivityThread", "currentActivityThread", new Object[0]), "mAppThread");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 1006632960);
            FileDescriptor fileDescriptor = open;
            if (!SystemUtil.a(26)) {
                fileDescriptor = open.getFileDescriptor();
            }
            if (SystemUtil.a(24)) {
                n.a(a2, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, new String[0]);
            } else if (SystemUtil.a(23)) {
                n.a(a2, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, new String[0]);
            } else if (SystemUtil.a(19)) {
                n.a(a2, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, new String[0]);
            }
            ParcelFileDescriptor open2 = ParcelFileDescriptor.open(file, 973078528);
            FileDescriptor fileDescriptor2 = open2;
            if (!SystemUtil.a(26)) {
                fileDescriptor2 = open2.getFileDescriptor();
            }
            n.a(a2, "dumpGfxInfo", fileDescriptor2, new String[]{SystemUtil.a(com.kwad.sdk.crash.d.a().f())});
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public static void e(File file) {
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
        if (parentFile.mkdirs() || parentFile.isDirectory()) {
            file.createNewFile();
            return;
        }
        throw new IOException("Directory '" + parentFile + "' could not be created");
    }
}
