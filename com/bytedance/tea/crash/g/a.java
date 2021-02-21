package com.bytedance.tea.crash.g;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.tea.crash.upload.CrashUploadService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f7664a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f7665b = null;
    private static Class<?> c = null;
    private static Field pww = null;
    private static Field pwx = null;
    private static boolean f = false;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0068 -> B:32:0x0005). Please submit an issue!!! */
    public static boolean a(Context context) {
        boolean z;
        ActivityManager activityManager;
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        try {
            activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        } catch (Throwable th) {
        }
        if (activityManager == null) {
            z = false;
        } else if (Build.VERSION.SDK_INT < 21) {
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks != null && !runningTasks.isEmpty() && (componentName = runningTasks.get(0).topActivity) != null && packageName.equals(componentName.getPackageName())) {
                z = true;
            }
            z = false;
        } else {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.importance == 100) {
                        z = packageName.equals(runningAppProcessInfo.pkgList[0]);
                        break;
                    }
                }
            }
            z = false;
        }
        return z;
    }

    @Nullable
    public static ActivityManager.ProcessErrorStateInfo V(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
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

    public static boolean b(Context context) {
        String d = d(context);
        if (d == null || !d.contains(":")) {
            if (d == null || !d.equals(context.getPackageName())) {
                return d != null && d.equals(context.getApplicationInfo().processName);
            }
            return true;
        }
        return false;
    }

    public static boolean c(Context context) {
        String d = d(context);
        if (f7665b == null) {
            try {
                f7665b = context.getPackageManager().getServiceInfo(new ComponentName(context, CrashUploadService.class), 65536).processName;
                f7665b = f7665b.substring(f7665b.lastIndexOf(":"));
            } catch (Throwable th) {
                th.printStackTrace();
                f7665b = ":npth";
            }
        }
        return d != null && d.endsWith(f7665b);
    }

    @Nullable
    public static String d(Context context) {
        String str = f7664a;
        if (TextUtils.isEmpty(str)) {
            try {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
                if (activityManager != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                        if (runningAppProcessInfo.pid == myPid) {
                            f7664a = runningAppProcessInfo.processName;
                            return f7664a;
                        }
                    }
                }
            } catch (Throwable th) {
                j.b(th);
            }
            f7664a = a();
            if (f7664a == null) {
                return "";
            }
            return f7664a;
        }
        return str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @androidx.annotation.Nullable
    private static java.lang.String a() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5a
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L5a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r4.<init>()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = "/proc/"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L5a
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = "/cmdline"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L5a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r4 = "iso-8859-1"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L5a
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
            r2.<init>()     // Catch: java.lang.Throwable -> L42
        L37:
            int r3 = r1.read()     // Catch: java.lang.Throwable -> L42
            if (r3 <= 0) goto L47
            char r3 = (char) r3     // Catch: java.lang.Throwable -> L42
            r2.append(r3)     // Catch: java.lang.Throwable -> L42
            goto L37
        L42:
            r2 = move-exception
        L43:
            com.bytedance.tea.crash.g.f.a(r1)
        L46:
            return r0
        L47:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L42
            com.bytedance.tea.crash.g.f.a(r1)
            goto L46
        L4f:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L52:
            com.bytedance.tea.crash.g.f.a(r3)
            throw r2
        L56:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L52
        L5a:
            r1 = move-exception
            r1 = r0
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.g.a.a():java.lang.String");
    }

    public static void a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        try {
            a(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            if (activityManager != null) {
                b(jSONObject, activityManager);
            }
            a(jSONObject, activityManager);
        } catch (Throwable th) {
        }
    }

    private static void a(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
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

    private static void b(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", g.a(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    private static void a(@NonNull JSONObject jSONObject) throws JSONException {
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
        jSONObject2.put("totalPrivateClean", b.a(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", a(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", b.b(memoryInfo));
        jSONObject2.put("totalSharedDirty", a(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", a(b.c(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }

    private static long a(int i) {
        if (i < 0) {
            return 0L;
        }
        return i * 1024;
    }

    @NonNull
    public static String e(Context context) {
        Class<?> ib = ib(context);
        if (pww == null && ib != null) {
            try {
                pww = ib.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException e) {
            }
        }
        if (pww != null) {
            try {
                return (String) pww.get(null);
            } catch (Throwable th) {
            }
        }
        return "";
    }

    public static int f(Context context) {
        Class<?> ib = ib(context);
        if (pwx == null && ib != null) {
            try {
                pwx = ib.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException e) {
            }
        }
        if (pwx != null) {
            try {
                return ((Integer) pwx.get(null)).intValue();
            } catch (Throwable th) {
            }
        }
        return -1;
    }

    @Nullable
    private static Class<?> ib(Context context) {
        if (c == null && !f) {
            try {
                c = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException e) {
            }
            f = true;
        }
        return c;
    }
}
