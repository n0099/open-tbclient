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
/* loaded from: classes6.dex */
public class q {
    @Nullable
    @MainThread
    public static JSONArray a(@NonNull final Context context) {
        if (com.bytedance.sdk.openadsdk.core.p.h().D() && com.bytedance.sdk.openadsdk.core.i.d().e().alist() && com.bytedance.sdk.openadsdk.core.h.f.d() && e(context)) {
            com.bytedance.sdk.openadsdk.j.e.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.q.1
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
    private static JSONArray c(Context context) {
        try {
            String b = com.bytedance.sdk.openadsdk.core.d.a(context).b("install_app_incremental_string", (String) null);
            if (!TextUtils.isEmpty(b)) {
                return new JSONArray((Collection) b(b));
            }
        } catch (Throwable th) {
            u.a("InstallAppUtils", "getCacheIncrementalApps error: ", th);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static void d(Context context) {
        try {
            List<String> a2 = com.bytedance.sdk.openadsdk.core.h.b.a().a(context);
            if (a2 != null && !a2.isEmpty()) {
                List<String> b = b(com.bytedance.sdk.openadsdk.core.d.a(context).b("install_app_string", (String) null));
                a(context, a(a2));
                if (b != null && !b.isEmpty()) {
                    a2.removeAll(b);
                }
                b(context, a(a2));
            }
        } catch (Exception e) {
            u.a("InstallAppUtils", "loadIncrementInstallApps error: ", e);
        }
    }

    @WorkerThread
    private static void a(Context context, String str) {
        com.bytedance.sdk.openadsdk.core.d.a(context).a("install_app_string", str);
    }

    @WorkerThread
    private static void b(Context context, String str) {
        com.bytedance.sdk.openadsdk.core.d a2 = com.bytedance.sdk.openadsdk.core.d.a(context);
        a2.a("install_app_incremental_string", str);
        a2.a("apptime", System.currentTimeMillis());
    }

    private static boolean e(Context context) {
        long longValue = com.bytedance.sdk.openadsdk.core.d.a(context).b("apptime", -1L).longValue();
        return longValue == -1 || System.currentTimeMillis() - longValue > 43200000;
    }

    private static List<String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    private static String a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                sb.append(list.get(i2));
                if (i2 != list.size() - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            } else {
                return sb.toString().trim();
            }
        }
    }

    @WorkerThread
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!aj.c(com.bytedance.sdk.openadsdk.core.p.a()) || aj.c(com.bytedance.sdk.openadsdk.core.p.a(), str)) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            try {
                File file = new File(Environment.getExternalStorageDirectory().getPath(), "android/data/" + str);
                if (file.exists()) {
                    long a2 = a(file);
                    PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.p.a().getPackageManager().getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        return packageInfo.lastUpdateTime < a2;
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return false;
    }

    public static long a(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return a(file, file.lastModified(), 0);
    }

    private static long a(File file, long j, int i) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return j;
        }
        long max = Math.max(j, file.lastModified());
        int i2 = i + 1;
        if (i2 < 50 && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                max = Math.max(max, a(file2, max, i2));
            }
            return max;
        }
        return max;
    }
}
