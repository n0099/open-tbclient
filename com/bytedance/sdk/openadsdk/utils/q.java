package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class q {
    @Nullable
    @MainThread
    public static JSONArray a(@NonNull final Context context) {
        if (com.bytedance.sdk.openadsdk.core.p.h().D() && com.bytedance.sdk.openadsdk.core.i.d().e().alist() && com.bytedance.sdk.openadsdk.core.h.f.d() && e(context)) {
            com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("getIncrementalInstallApps") { // from class: com.bytedance.sdk.openadsdk.utils.q.1
                @Override // java.lang.Runnable
                public void run() {
                    q.d(context);
                }
            }, 1);
            return c(context);
        }
        return null;
    }

    @Nullable
    public static JSONArray c(Context context) {
        try {
            String b2 = com.bytedance.sdk.openadsdk.core.d.a(context).b("install_app_incremental_string", (String) null);
            if (!TextUtils.isEmpty(b2)) {
                return new JSONArray((Collection) b(b2));
            }
        } catch (Throwable th) {
            u.a("InstallAppUtils", "getCacheIncrementalApps error: ", th);
        }
        return null;
    }

    @WorkerThread
    public static void d(Context context) {
        try {
            List<String> a2 = com.bytedance.sdk.openadsdk.core.h.b.a().a(context);
            if (a2 != null && !a2.isEmpty()) {
                List<String> b2 = b(com.bytedance.sdk.openadsdk.core.d.a(context).b("install_app_string", (String) null));
                a(context, a(a2));
                if (b2 != null && !b2.isEmpty()) {
                    a2.removeAll(b2);
                }
                b(context, a(a2));
            }
        } catch (Exception e2) {
            u.a("InstallAppUtils", "loadIncrementInstallApps error: ", e2);
        }
    }

    public static boolean e(Context context) {
        long longValue = com.bytedance.sdk.openadsdk.core.d.a(context).b("apptime", -1L).longValue();
        return longValue == -1 || System.currentTimeMillis() - longValue > 43200000;
    }

    @WorkerThread
    public static void b(Context context, String str) {
        com.bytedance.sdk.openadsdk.core.d a2 = com.bytedance.sdk.openadsdk.core.d.a(context);
        a2.a("install_app_incremental_string", str);
        a2.a("apptime", System.currentTimeMillis());
    }

    public static List<String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    @WorkerThread
    public static void a(Context context, String str) {
        com.bytedance.sdk.openadsdk.core.d.a(context).a("install_app_string", str);
    }

    public static String a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString().trim();
    }

    @WorkerThread
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!ak.c(com.bytedance.sdk.openadsdk.core.p.a()) || ak.c(com.bytedance.sdk.openadsdk.core.p.a(), str)) {
            if (Build.VERSION.SDK_INT < 29 || com.bytedance.sdk.openadsdk.core.p.a().getApplicationInfo().targetSdkVersion < 29) {
                try {
                    String path = Environment.getExternalStorageDirectory().getPath();
                    File file = new File(path, "android/data/" + str);
                    if (file.exists()) {
                        long a2 = a(file);
                        PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.p.a().getPackageManager().getPackageInfo(str, 0);
                        if (packageInfo != null) {
                            if (packageInfo.lastUpdateTime < a2) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public static long a(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return a(file, file.lastModified(), 0);
    }

    public static long a(File file, long j, int i) {
        File[] listFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return j;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    j = Math.max(j, a(file2, j, i2));
                }
            }
        }
        return j;
    }
}
