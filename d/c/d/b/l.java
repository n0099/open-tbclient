package d.c.d.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.ModernAsyncTask;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statusbar.ImmersiveOSUtils;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.bytedance.tea.crash.upload.CrashUploadService;
import com.bytedance.tea.crash.upload.b;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f66816a;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f66817e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f66818f;

        public a(Context context, boolean z) {
            this.f66817e = context;
            this.f66818f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.c.d.b.c.b.a().b(this.f66817e);
            d.c.d.b.n.c.a(this.f66817e);
            if (this.f66818f) {
                d.c.d.b.a.f.a(this.f66817e).b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public static String f66819a = null;

        /* renamed from: b  reason: collision with root package name */
        public static String f66820b = null;

        /* renamed from: c  reason: collision with root package name */
        public static Class<?> f66821c = null;

        /* renamed from: d  reason: collision with root package name */
        public static Field f66822d = null;

        /* renamed from: e  reason: collision with root package name */
        public static Field f66823e = null;

        /* renamed from: f  reason: collision with root package name */
        public static boolean f66824f = false;

        public static long a(int i) {
            if (i < 0) {
                return 0L;
            }
            return i * 1024;
        }

        @Nullable
        public static ActivityManager.ProcessErrorStateInfo b(Context context, int i) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            for (int i2 = 0; i2 < i; i2++) {
                SystemClock.sleep(200L);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            return processErrorStateInfo;
                        }
                    }
                    continue;
                }
            }
            return null;
        }

        @Nullable
        public static String c() {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read > 0) {
                        sb.append((char) read);
                    } else {
                        String sb2 = sb.toString();
                        g.a(bufferedReader);
                        return sb2;
                    }
                }
            } catch (Throwable unused2) {
                g.a(bufferedReader);
                return null;
            }
        }

        public static void d(@NonNull Context context, @NonNull JSONObject jSONObject) {
            try {
                e(jSONObject);
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    h(jSONObject, activityManager);
                }
                f(jSONObject, activityManager);
            } catch (Throwable unused) {
            }
        }

        public static void e(@NonNull JSONObject jSONObject) throws JSONException {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dalvikPrivateDirty", a(memoryInfo.dalvikPrivateDirty));
            jSONObject2.put("dalvikPss", a(memoryInfo.dalvikPss));
            jSONObject2.put("dalvikSharedDirty", a(memoryInfo.dalvikSharedDirty));
            jSONObject2.put("nativePrivateDirty", a(memoryInfo.nativePrivateDirty));
            jSONObject2.put("nativePss", a(memoryInfo.nativePss));
            jSONObject2.put("nativeSharedDirty", a(memoryInfo.nativeSharedDirty));
            jSONObject2.put("otherPrivateDirty", a(memoryInfo.otherPrivateDirty));
            jSONObject2.put("otherPss", a(memoryInfo.otherPss));
            jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
            jSONObject2.put("totalPrivateClean", c.a(memoryInfo));
            jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
            jSONObject2.put("totalPss", a(memoryInfo.getTotalPss()));
            jSONObject2.put("totalSharedClean", c.b(memoryInfo));
            jSONObject2.put("totalSharedDirty", a(memoryInfo.getTotalSharedDirty()));
            jSONObject2.put("totalSwappablePss", a(c.c(memoryInfo)));
            jSONObject.put("memory_info", jSONObject2);
        }

        public static void f(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
            jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
            jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
            Runtime runtime = Runtime.getRuntime();
            jSONObject2.put("max_memory", runtime.maxMemory());
            jSONObject2.put("free_memory", runtime.freeMemory());
            jSONObject2.put("total_memory", runtime.totalMemory());
            if (activityManager != null) {
                jSONObject2.put("memory_class", activityManager.getMemoryClass());
                jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
            }
            jSONObject.put("app_memory_info", jSONObject2);
        }

        public static boolean g(Context context) {
            ActivityManager activityManager;
            ComponentName componentName;
            if (context == null) {
                return false;
            }
            String packageName = context.getPackageName();
            try {
                activityManager = (ActivityManager) context.getSystemService("activity");
            } catch (Throwable unused) {
            }
            if (activityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 21) {
                List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                if (runningTasks != null && !runningTasks.isEmpty() && (componentName = runningTasks.get(0).topActivity) != null && packageName.equals(componentName.getPackageName())) {
                    return true;
                }
            } else {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.importance == 100) {
                            return packageName.equals(runningAppProcessInfo.pkgList[0]);
                        }
                    }
                }
            }
            return false;
        }

        public static void h(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
            JSONObject jSONObject2 = new JSONObject();
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            jSONObject2.put("availMem", memoryInfo.availMem);
            jSONObject2.put("lowMemory", memoryInfo.lowMemory);
            jSONObject2.put("threshold", memoryInfo.threshold);
            jSONObject2.put("totalMem", h.a(memoryInfo));
            jSONObject.put("sys_memory_info", jSONObject2);
        }

        public static boolean i(Context context) {
            String k = k(context);
            if (k == null || !k.contains(":")) {
                if (k == null || !k.equals(context.getPackageName())) {
                    return k != null && k.equals(context.getApplicationInfo().processName);
                }
                return true;
            }
            return false;
        }

        public static boolean j(Context context) {
            String k = k(context);
            if (f66820b == null) {
                try {
                    String str = context.getPackageManager().getServiceInfo(new ComponentName(context, CrashUploadService.class), 65536).processName;
                    f66820b = str;
                    f66820b = str.substring(str.lastIndexOf(":"));
                } catch (Throwable th) {
                    th.printStackTrace();
                    f66820b = ":npth";
                }
            }
            return k != null && k.endsWith(f66820b);
        }

        @Nullable
        public static String k(Context context) {
            String str = f66819a;
            if (TextUtils.isEmpty(str)) {
                try {
                    int myPid = Process.myPid();
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    if (activityManager != null) {
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                            if (runningAppProcessInfo.pid == myPid) {
                                String str2 = runningAppProcessInfo.processName;
                                f66819a = str2;
                                return str2;
                            }
                        }
                    }
                } catch (Throwable th) {
                    k.c(th);
                }
                String c2 = c();
                f66819a = c2;
                return c2 == null ? "" : c2;
            }
            return str;
        }

        @NonNull
        public static String l(Context context) {
            Class<?> n = n(context);
            if (f66822d == null && n != null) {
                try {
                    f66822d = n.getDeclaredField("VERSION_NAME");
                } catch (NoSuchFieldException unused) {
                }
            }
            Field field = f66822d;
            if (field != null) {
                try {
                    return (String) field.get(null);
                } catch (Throwable unused2) {
                    return "";
                }
            }
            return "";
        }

        public static int m(Context context) {
            Class<?> n = n(context);
            if (f66823e == null && n != null) {
                try {
                    f66823e = n.getDeclaredField("VERSION_CODE");
                } catch (NoSuchFieldException unused) {
                }
            }
            Field field = f66823e;
            if (field != null) {
                try {
                    return ((Integer) field.get(null)).intValue();
                } catch (Throwable unused2) {
                    return -1;
                }
            }
            return -1;
        }

        @Nullable
        public static Class<?> n(Context context) {
            if (f66821c == null && !f66824f) {
                try {
                    f66821c = Class.forName(context.getPackageName() + ".BuildConfig");
                } catch (ClassNotFoundException unused) {
                }
                f66824f = true;
            }
            return f66821c;
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public static final b f66825a;

        /* loaded from: classes5.dex */
        public static class b {
            public b() {
            }

            public int a(Debug.MemoryInfo memoryInfo) {
                return -1;
            }

            public int b(Debug.MemoryInfo memoryInfo) {
                return -1;
            }

            public int c(Debug.MemoryInfo memoryInfo) {
                return -1;
            }
        }

        @TargetApi(19)
        /* renamed from: d.c.d.b.l$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C1833c extends b {
            public C1833c() {
                super();
            }

            @Override // d.c.d.b.l.c.b
            public int a(Debug.MemoryInfo memoryInfo) {
                return memoryInfo.getTotalPrivateClean();
            }

            @Override // d.c.d.b.l.c.b
            public int b(Debug.MemoryInfo memoryInfo) {
                return memoryInfo.getTotalSharedClean();
            }

            @Override // d.c.d.b.l.c.b
            public int c(Debug.MemoryInfo memoryInfo) {
                return memoryInfo.getTotalSwappablePss();
            }
        }

        static {
            if (Build.VERSION.SDK_INT >= 19) {
                f66825a = new C1833c();
            } else {
                f66825a = new b();
            }
        }

        public static int a(Debug.MemoryInfo memoryInfo) {
            return f66825a.a(memoryInfo);
        }

        public static int b(Debug.MemoryInfo memoryInfo) {
            return f66825a.b(memoryInfo);
        }

        public static int c(Debug.MemoryInfo memoryInfo) {
            return f66825a.c(memoryInfo);
        }
    }

    /* loaded from: classes5.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f66826a = false;

        public static String a() {
            return c("ro.build.version.emui");
        }

        public static boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                str = a();
            }
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
                return d();
            }
            return true;
        }

        public static String c(String str) {
            BufferedReader bufferedReader;
            String str2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            try {
                str2 = bufferedReader.readLine();
                bufferedReader.close();
                g.a(bufferedReader);
                return str2;
            } catch (Throwable unused2) {
                g.a(bufferedReader);
                return str2;
            }
        }

        public static boolean d() {
            try {
                if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase(Locale.getDefault()).startsWith(RomUtils.MANUFACTURER_HUAWEI)) {
                    if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                        return false;
                    }
                    if (!Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith(RomUtils.MANUFACTURER_HUAWEI)) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        public static boolean e() {
            if (!f66826a) {
                try {
                    if (Class.forName("miui.os.Build") != null) {
                        com.bytedance.tea.crash.upload.b.f30206a = true;
                        f66826a = true;
                        return true;
                    }
                } catch (Exception unused) {
                }
                f66826a = true;
            }
            return com.bytedance.tea.crash.upload.b.f30206a;
        }

        public static boolean f() {
            return Build.DISPLAY.contains("Flyme") || Build.USER.equals(ImmersiveOSUtils.FLYME);
        }
    }

    /* loaded from: classes5.dex */
    public class e {
        public static String a(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) {
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("url", str2);
                jSONObject2.put("body", jSONObject);
                if (str3 == null) {
                    str3 = "";
                }
                jSONObject2.put("dump_file", str3);
                jSONObject2.put(LightappBusinessClient.MTD_ENCRYPT, z);
                e(file2, jSONObject2.toString(), false);
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            return file2.getAbsolutePath();
        }

        public static String b(File file, String str, String str2, JSONObject jSONObject, boolean z) {
            return a(file, str, str2, jSONObject, null, z);
        }

        public static String c(String str, String str2) throws IOException {
            BufferedReader bufferedReader = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                            if (str2 != null) {
                                sb.append(str2);
                            }
                        } else {
                            g.a(bufferedReader2);
                            return sb.toString();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        g.a(bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public static void d(Context context, String str, String str2) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                sb.append(" ");
                if (str == null) {
                    str = StringUtil.NULL_STRING;
                }
                sb.append(str);
                sb.append(" ");
                if (str2 == null) {
                    str2 = StringUtil.NULL_STRING;
                }
                sb.append(str2);
                sb.append("\n");
                e(i.c(context), sb.toString(), true);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        public static void e(@NonNull File file, @NonNull String str, boolean z) throws IOException {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            file.getParentFile().mkdirs();
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
                try {
                    fileOutputStream2.write(str.getBytes());
                    fileOutputStream2.flush();
                    g.a(fileOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    g.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public static boolean f(File file) {
            return file.exists() && file.delete();
        }

        public static boolean g(@NonNull File file, boolean z) {
            boolean g2;
            if (z && !file.isFile()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    boolean z2 = true;
                    for (int i = 0; listFiles != null && i < listFiles.length; i++) {
                        if (listFiles[i].isFile()) {
                            g2 = f(listFiles[i]);
                        } else {
                            g2 = g(listFiles[i], true);
                        }
                        z2 &= g2;
                    }
                    return z2 & f(file);
                }
                return true;
            }
            return f(file);
        }

        public static boolean h(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            return file.exists() && file.delete();
        }

        public static String i(String str) throws IOException {
            return c(str, null);
        }

        public static d.c.d.b.e.c j(String str) {
            try {
                JSONObject jSONObject = new JSONObject(i(str));
                d.c.d.b.e.c cVar = new d.c.d.b.e.c();
                cVar.b(jSONObject.optString("url"));
                cVar.c(jSONObject.optJSONObject("body"));
                cVar.f(jSONObject.optString("dump_file"));
                cVar.d(jSONObject.optBoolean(LightappBusinessClient.MTD_ENCRYPT, false));
                return cVar;
            } catch (Throwable unused) {
                return null;
            }
        }

        @Nullable
        public static String[] k(String str) {
            BufferedReader bufferedReader;
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), 1000);
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        int indexOf = readLine.indexOf(SmallTailInfo.EMOTION_SUFFIX);
                        if (indexOf > 0) {
                            readLine = readLine.substring(indexOf + 2);
                        }
                        String[] split = readLine.split(" ");
                        g.a(bufferedReader);
                        return split;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        g.a(bufferedReader);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    g.a(bufferedReader2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                g.a(bufferedReader2);
                throw th;
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class f {

        /* renamed from: a  reason: collision with root package name */
        public static final Set<String> f66827a;

        static {
            HashSet hashSet = new HashSet();
            f66827a = hashSet;
            hashSet.add("HeapTaskDaemon");
            f66827a.add("ThreadPlus");
            f66827a.add("ApiDispatcher");
            f66827a.add("ApiLocalDispatcher");
            f66827a.add("AsyncLoader");
            f66827a.add(ModernAsyncTask.LOG_TAG);
            f66827a.add("Binder");
            f66827a.add("PackageProcessor");
            f66827a.add("SettingsObserver");
            f66827a.add("WifiManager");
            f66827a.add("JavaBridge");
            f66827a.add("Compiler");
            f66827a.add("Signal Catcher");
            f66827a.add("GC");
            f66827a.add("ReferenceQueueDaemon");
            f66827a.add("FinalizerDaemon");
            f66827a.add("FinalizerWatchdogDaemon");
            f66827a.add("CookieSyncManager");
            f66827a.add("RefQueueWorker");
            f66827a.add("CleanupReference");
            f66827a.add("VideoManager");
            f66827a.add("DBHelper-AsyncOp");
            f66827a.add("InstalledAppTracker2");
            f66827a.add("AppData-AsyncOp");
            f66827a.add("IdleConnectionMonitor");
            f66827a.add("LogReaper");
            f66827a.add("ActionReaper");
            f66827a.add("Okio Watchdog");
            f66827a.add("CheckWaitingQueue");
            f66827a.add("NPTH-CrashTimer");
            f66827a.add("NPTH-JavaCallback");
            f66827a.add("NPTH-LocalParser");
            f66827a.add("ANR_FILE_MODIFY");
        }

        public static Set<String> a() {
            return f66827a;
        }
    }

    /* loaded from: classes5.dex */
    public final class g {
        public static void a(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public static final b f66828a;

        /* loaded from: classes5.dex */
        public static class b {
            public b() {
            }

            public long a(ActivityManager.MemoryInfo memoryInfo) {
                return 0L;
            }
        }

        @TargetApi(16)
        /* loaded from: classes5.dex */
        public static class c extends b {
            public c() {
                super();
            }

            @Override // d.c.d.b.l.h.b
            public long a(ActivityManager.MemoryInfo memoryInfo) {
                return memoryInfo.totalMem;
            }
        }

        static {
            if (Build.VERSION.SDK_INT >= 16) {
                f66828a = new c();
            } else {
                f66828a = new b();
            }
        }

        public static long a(ActivityManager.MemoryInfo memoryInfo) {
            return f66828a.a(memoryInfo);
        }
    }

    /* loaded from: classes5.dex */
    public class i {
        public static File a(@NonNull Context context) {
            return new File(e(context), "CrashLogJava");
        }

        public static String b() {
            return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
        }

        public static File c(@NonNull Context context) {
            return new File(e(context), "crash_history");
        }

        public static String d() {
            return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
        }

        @SuppressLint({"SdCardPath"})
        public static String e(@NonNull Context context) {
            String path;
            try {
                if (context.getFilesDir() != null) {
                    path = context.getFilesDir().getPath();
                } else {
                    File dir = context.getDir("/data/data/" + context.getPackageName() + "/files/", 0);
                    path = dir != null ? dir.getPath() : null;
                }
                return path != null ? path : "/sdcard/";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "/sdcard/";
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class j {

        /* loaded from: classes5.dex */
        public static /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f66829a;

            static {
                int[] iArr = new int[b.EnumC0343b.values().length];
                f66829a = iArr;
                try {
                    iArr[b.EnumC0343b.WIFI.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    f66829a[b.EnumC0343b.MOBILE_2G.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    f66829a[b.EnumC0343b.MOBILE_3G.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    f66829a[b.EnumC0343b.MOBILE_4G.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    f66829a[b.EnumC0343b.MOBILE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
            }
        }

        public static String a(Context context) {
            return b(d(context));
        }

        public static String b(b.EnumC0343b enumC0343b) {
            String str;
            try {
                int i = a.f66829a[enumC0343b.ordinal()];
                if (i == 1) {
                    str = "wifi";
                } else if (i == 2) {
                    str = "2g";
                } else if (i == 3) {
                    str = "3g";
                } else if (i == 4) {
                    str = "4g";
                } else if (i != 5) {
                    return "";
                } else {
                    str = "mobile";
                }
                return str;
            } catch (Exception unused) {
                return "";
            }
        }

        public static boolean c(Context context) {
            NetworkInfo activeNetworkInfo;
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return false;
                }
                return activeNetworkInfo.isAvailable();
            } catch (Exception unused) {
                return false;
            }
        }

        public static b.EnumC0343b d(Context context) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return b.EnumC0343b.NONE;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    int type = activeNetworkInfo.getType();
                    if (1 == type) {
                        return b.EnumC0343b.WIFI;
                    }
                    if (type == 0) {
                        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return b.EnumC0343b.MOBILE_3G;
                            case 4:
                            case 7:
                            case 11:
                            default:
                                return b.EnumC0343b.MOBILE;
                            case 13:
                                return b.EnumC0343b.MOBILE_4G;
                        }
                    }
                    return b.EnumC0343b.MOBILE;
                }
                return b.EnumC0343b.NONE;
            } catch (Throwable unused) {
                return b.EnumC0343b.MOBILE;
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class k {
        public static void a(String str) {
            if (d.c.d.b.m.f().d()) {
                Log.i("npth", str);
            }
        }

        public static void b(Throwable th) {
            if (d.c.d.b.m.f().d()) {
                Log.e("npth", "NPTH Catch Error", th);
            }
        }

        public static void c(Throwable th) {
            if (d.c.d.b.m.f().d()) {
                Log.w("npth", "NPTH Catch Error", th);
            }
        }
    }

    /* renamed from: d.c.d.b.l$l  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public final class C1834l {
        public static String a(String str) {
            Map<String, Object> a2;
            if (d.c.d.b.m.a() == null || (a2 = d.c.d.b.m.a().a()) == null) {
                return null;
            }
            Object obj = a2.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        public static void b(d.c.d.b.e.a aVar, d.c.d.b.e.b bVar, com.bytedance.tea.crash.c cVar) {
            if (aVar == null || aVar.j() == null || cVar == null) {
                return;
            }
            JSONObject j = aVar.j();
            long optLong = j.optLong("crash_time");
            int c2 = c(a("aid"));
            String a2 = d.c.d.b.m.d().a();
            if (optLong <= 0 || c2 <= 0 || TextUtils.isEmpty(a2) || "0".equals(a2) || TextUtils.isEmpty(cVar.a())) {
                return;
            }
            try {
                String str = "android_" + c2 + "_" + a2 + "_" + optLong + "_" + cVar;
                if (bVar != null) {
                    JSONObject b2 = bVar.b();
                    if (b2 != null) {
                        b2.put("unique_key", str);
                    }
                } else {
                    j.put("unique_key", str);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        public static int c(String str) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                k.c(e2);
                return 0;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m {

        /* renamed from: a  reason: collision with root package name */
        public static final CharSequence f66830a = "amigo";

        /* renamed from: b  reason: collision with root package name */
        public static final CharSequence f66831b = "funtouch";

        public static String a() {
            if (d.e()) {
                return k();
            }
            if (d.f()) {
                return m();
            }
            if (n()) {
                return o();
            }
            String l = l();
            if (TextUtils.isEmpty(l)) {
                if (f()) {
                    return e();
                }
                if (g()) {
                    return h();
                }
                if (d()) {
                    return c();
                }
                String i = i();
                return !TextUtils.isEmpty(i) ? i : Build.DISPLAY;
            }
            return l;
        }

        public static String b(String str) {
            String str2 = "";
            BufferedReader bufferedReader = null;
            try {
                Runtime runtime = Runtime.getRuntime();
                Process exec = runtime.exec("getprop " + str);
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
                try {
                    str2 = bufferedReader2.readLine();
                    exec.destroy();
                    g.a(bufferedReader2);
                    return str2;
                } catch (Throwable unused) {
                    bufferedReader = bufferedReader2;
                    g.a(bufferedReader);
                    return str2;
                }
            } catch (Throwable unused2) {
            }
        }

        public static String c() {
            return b("ro.build.uiversion") + "_" + Build.DISPLAY;
        }

        public static boolean d() {
            String str = Build.MANUFACTURER + Build.BRAND;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase(Locale.getDefault());
            return lowerCase.contains("360") || lowerCase.contains("qiku");
        }

        public static String e() {
            return b("ro.vivo.os.build.display.id") + "_" + b("ro.vivo.product.version");
        }

        public static boolean f() {
            String b2 = b("ro.vivo.os.build.display.id");
            return !TextUtils.isEmpty(b2) && b2.toLowerCase(Locale.getDefault()).contains(f66831b);
        }

        public static boolean g() {
            return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(f66830a);
        }

        public static String h() {
            return Build.DISPLAY + "_" + b(RomUtils.KEY_VERSION_GIONEE);
        }

        public static String i() {
            if (j()) {
                return "eui_" + b("ro.letv.release.version") + "_" + Build.DISPLAY;
            }
            return "";
        }

        public static boolean j() {
            return !TextUtils.isEmpty(b("ro.letv.release.version"));
        }

        public static String k() {
            if (d.e()) {
                return "miui_" + b("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
            }
            return "";
        }

        public static String l() {
            String a2 = d.a();
            if (a2 == null || !a2.toLowerCase(Locale.getDefault()).contains("emotionui")) {
                return "";
            }
            return a2 + "_" + Build.DISPLAY;
        }

        public static String m() {
            String str = Build.DISPLAY;
            return (str == null || !str.toLowerCase(Locale.getDefault()).contains(ImmersiveOSUtils.FLYME)) ? "" : str;
        }

        public static boolean n() {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase(Locale.getDefault()).contains(RomUtils.MANUFACTURER_OPPO);
        }

        public static String o() {
            if (n()) {
                return "coloros_" + b("ro.build.version.opporom") + "_" + Build.DISPLAY;
            }
            return "";
        }
    }

    /* loaded from: classes5.dex */
    public final class n {

        /* loaded from: classes5.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final PrintWriter f66832a;

            public a(PrintWriter printWriter) {
                this.f66832a = printWriter;
            }

            public Object a() {
                return this.f66832a;
            }

            public void b(Object obj) {
                this.f66832a.println(obj);
            }
        }

        @NonNull
        public static String a(@NonNull Throwable th) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            try {
                if (i(th)) {
                    f(th, printWriter);
                } else {
                    th.printStackTrace(printWriter);
                }
                return stringWriter.toString();
            } catch (Exception unused) {
                return "";
            } finally {
                printWriter.close();
            }
        }

        public static String b(StackTraceElement[] stackTraceElementArr) {
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                c(stackTraceElement, sb);
            }
            return sb.toString();
        }

        public static StringBuilder c(StackTraceElement stackTraceElement, StringBuilder sb) {
            String className = stackTraceElement.getClassName();
            sb.append("  at ");
            sb.append(className);
            sb.append(".");
            sb.append(stackTraceElement.getMethodName());
            sb.append("(");
            sb.append(stackTraceElement.getFileName());
            sb.append(":");
            sb.append(stackTraceElement.getLineNumber());
            sb.append(")\n");
            return sb;
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00d5 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0029 A[SYNTHETIC] */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static JSONObject d(String str) {
            Thread key;
            boolean z;
            try {
                Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
                JSONObject jSONObject = new JSONObject();
                if (allStackTraces == null) {
                    return null;
                }
                jSONObject.put("thread_all_count", allStackTraces.size());
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    String name = entry.getKey().getName();
                    if (!g(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                        jSONObject2.put("thread_name", key.getName() + "(" + key.getId() + SmallTailInfo.EMOTION_SUFFIX);
                        StackTraceElement[] value = entry.getValue();
                        if (value != null) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (StackTraceElement stackTraceElement : value) {
                                jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + SmallTailInfo.EMOTION_SUFFIX);
                            }
                            jSONObject2.put("thread_stack", jSONArray2);
                            if (jSONArray2.length() <= 0) {
                                z = false;
                                if (!z) {
                                    jSONArray.put(jSONObject2);
                                }
                            }
                        }
                        z = true;
                        if (!z) {
                        }
                    }
                }
                jSONObject.put("thread_stacks", jSONArray);
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: java.lang.Object[] */
        /* JADX WARN: Multi-variable type inference failed */
        public static void e(Throwable th, a aVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
            if (set.contains(th)) {
                aVar.b("\t[CIRCULAR REFERENCE:" + th + "]");
                return;
            }
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int min = Math.min(stackTrace.length, 256);
            int i = min - 1;
            int i2 = i;
            for (int min2 = Math.min(stackTraceElementArr.length, 256) - 1; i2 >= 0 && min2 >= 0 && stackTrace[i2].equals(stackTraceElementArr[min2]); min2--) {
                i2--;
            }
            int i3 = i - i2;
            aVar.b(str2 + str + th);
            for (int i4 = 0; i4 <= i2; i4++) {
                aVar.b(str2 + "\tat " + stackTrace[i4]);
            }
            if (min < stackTrace.length) {
                aVar.b("\t... skip " + (stackTrace.length - min) + " lines");
            }
            if (i3 != 0) {
                aVar.b(str2 + "\t... " + i3 + " more");
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable th2 : th.getSuppressed()) {
                    e(th2, aVar, stackTrace, "Suppressed: ", str2 + TrackUI.SEPERATOR, set);
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                e(cause, aVar, stackTrace, "Caused by: ", str2, set);
            }
        }

        public static void f(Throwable th, PrintWriter printWriter) {
            if (th == null || printWriter == null) {
                return;
            }
            a aVar = new a(printWriter);
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.add(th);
            synchronized (aVar.a()) {
                aVar.b(th);
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (i2 > 256) {
                        aVar.b("\t... skip " + (stackTrace.length - i2) + " lines");
                        break;
                    }
                    aVar.b("\tat " + stackTraceElement);
                    i2++;
                    i++;
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    for (Throwable th2 : th.getSuppressed()) {
                        e(th2, aVar, stackTrace, "Suppressed: ", TrackUI.SEPERATOR, newSetFromMap);
                    }
                }
                Throwable cause = th.getCause();
                if (cause != null) {
                    e(cause, aVar, stackTrace, "Caused by: ", "", newSetFromMap);
                }
            }
        }

        public static boolean g(String str) {
            Set<String> a2 = f.a();
            if (a2.contains(str)) {
                return true;
            }
            for (String str2 : a2) {
                if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean h(Throwable th) {
            if (th == null) {
                return false;
            }
            int i = 0;
            while (th != null) {
                try {
                    if (th instanceof OutOfMemoryError) {
                        return true;
                    }
                    if (i > 20) {
                        return false;
                    }
                    i++;
                    th = th.getCause();
                } catch (Throwable unused) {
                }
            }
            return false;
        }

        public static boolean i(Throwable th) {
            int i = 0;
            while (th != null) {
                if (th instanceof StackOverflowError) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                th = th.getCause();
                i++;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class o {
        public static long a(File file) {
            try {
                StatFs statFs = new StatFs(file.getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    return statFs.getTotalBytes();
                }
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable unused) {
                return 0L;
            }
        }

        public static JSONObject b(Context context) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("inner_app_used", e(context));
                jSONObject.put("inner_free", d());
                jSONObject.put("inner_total", g());
                jSONObject.put("sdcard_app_used", h(context));
                jSONObject.put("sdcard_free", j());
                jSONObject.put("sdcard_total", k());
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public static boolean c() {
            return "mounted".equals(Environment.getExternalStorageState());
        }

        public static long d() {
            try {
                return f(Environment.getRootDirectory());
            } catch (Exception unused) {
                return 0L;
            }
        }

        public static long e(Context context) {
            try {
                return i(context.getFilesDir().getParentFile());
            } catch (Exception unused) {
                return 0L;
            }
        }

        public static long f(File file) {
            try {
                StatFs statFs = new StatFs(file.getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    return statFs.getFreeBytes();
                }
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Throwable unused) {
                return 0L;
            }
        }

        public static long g() {
            try {
                return a(Environment.getRootDirectory());
            } catch (Exception unused) {
                return 0L;
            }
        }

        public static long h(Context context) {
            File externalFilesDir;
            try {
                if (!c() || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
                    return 0L;
                }
                return i(externalFilesDir.getParentFile());
            } catch (Exception unused) {
                return 0L;
            }
        }

        public static long i(File file) {
            long length;
            File[] listFiles = file.listFiles();
            long j = 0;
            if (listFiles == null) {
                return 0L;
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    length = i(file2);
                } else {
                    length = file2.length();
                }
                j += length;
            }
            return j;
        }

        public static long j() {
            try {
                if (c()) {
                    return Environment.getExternalStorageDirectory().getFreeSpace();
                }
                return 0L;
            } catch (Exception unused) {
                return 0L;
            }
        }

        public static long k() {
            try {
                if (c()) {
                    return Environment.getExternalStorageDirectory().getTotalSpace();
                }
                return 0L;
            } catch (Exception unused) {
                return 0L;
            }
        }
    }

    public static synchronized void a(@NonNull Context context, @NonNull d.c.d.b.g gVar, boolean z, boolean z2) {
        synchronized (l.class) {
            b(context, gVar, z, false, z2);
        }
    }

    public static synchronized void b(@NonNull Context context, @NonNull d.c.d.b.g gVar, boolean z, boolean z2, boolean z3) {
        synchronized (l.class) {
            c(context, gVar, z, z, z2, z3);
        }
    }

    public static synchronized void c(@NonNull Context context, @NonNull d.c.d.b.g gVar, boolean z, boolean z2, boolean z3, boolean z4) {
        synchronized (l.class) {
            if (f66816a) {
                return;
            }
            if (context == null) {
                throw new IllegalArgumentException("context must be not null.");
            }
            if (gVar != null) {
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                if (b.j(context)) {
                    return;
                }
                d.c.d.b.m.b(context, gVar);
                d.c.d.b.h.a.e.d(context);
                if (z || z2) {
                    d.c.d.b.f.a a2 = d.c.d.b.f.a.a();
                    if (z) {
                        a2.c(new d.c.d.b.f.c(context));
                    }
                }
                f66816a = true;
                d.c.d.b.h.i.b().post(new a(context, z4));
                return;
            }
            throw new IllegalArgumentException("params must be not null.");
        }
    }

    public static void d(d.c.d.b.k kVar) {
        d.c.d.b.m.c().c(kVar);
    }

    public static void e(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        d.c.d.b.m.c().d(map);
    }
}
