package d.b.g0.f.f.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.k;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48194a = k.f45443a;

    public static long a() {
        return h.a().getLong("install_authorize_guide_time_key", 0L);
    }

    public static long b() {
        return h.a().getLong("install_continue_guide_time_key", 0L);
    }

    public static String c() {
        return (Build.VERSION.SDK_INT < 26 || AppRuntime.getAppContext().getPackageManager().canRequestPackageInstalls()) ? "continue" : "authorize";
    }

    public static int d() {
        return h.a().getInt("install_guide_count_key", 0);
    }

    public static int e() {
        return h.a().getInt("install_guide_max_count_key", 3);
    }

    public static boolean f() {
        return h.a().getBoolean("install_guide_switch_key", true);
    }

    public static boolean g(Context context, String str) {
        if (context != null) {
            try {
                if (context.getPackageManager() != null) {
                    return context.getPackageManager().getPackageInfo(str, 0) != null;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean h(Context context, File file, boolean z) {
        if (context != null && file != null && file.isFile() && file.exists()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (f48194a) {
                Log.e("GameCenterApkUtil", "install apk start");
            }
            try {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(1342177280);
                intent.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", context.getPackageName());
                if (z) {
                    intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                }
                if (Build.VERSION.SDK_INT < 24) {
                    intent.setComponent(new ComponentName("com.android.packageinstaller", "com.android.packageinstaller.PackageInstallerActivity"));
                }
                n(context, file, intent);
                context.startActivity(intent);
                if (f48194a) {
                    Log.e("GameCenterApkUtil", "install apk done");
                }
            } catch (Exception e2) {
                if (f48194a) {
                    e2.printStackTrace();
                }
                intent.setComponent(null);
                n(context, file, intent);
                try {
                    context.startActivity(intent);
                    if (f48194a) {
                        Log.e("GameCenterApkUtil", "retry install apk done");
                    }
                } catch (Exception e3) {
                    if (f48194a) {
                        e3.printStackTrace();
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean i(String str) {
        return j(str, false);
    }

    public static boolean j(String str, boolean z) {
        if (f48194a) {
            Log.e("GameCenterApkUtil", "call installApk filePath = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return h(AppRuntime.getAppContext(), new File(str), z);
        } catch (Exception e2) {
            if (f48194a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static boolean k(String str) {
        return f() && m(str) && d() < e();
    }

    public static boolean l(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0 && queryIntentActivities.iterator().next() != null) {
                String str2 = queryIntentActivities.iterator().next().activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setComponent(new ComponentName(str, str2));
                intent2.setFlags(270532608);
                try {
                    context.startActivity(intent2);
                    if (f48194a) {
                        Log.d("GameCenterApkUtil", "openApp:packageName = " + str);
                        return true;
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    public static boolean m(String str) {
        return (System.currentTimeMillis() / 86400000) - ((TextUtils.equals(str, "authorize") ? a() : b()) / 86400000) > 0;
    }

    public static boolean n(Context context, File file, Intent intent) {
        ActivityInfo activityInfo;
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                if (uriForFile == null) {
                    return false;
                }
                intent.setDataAndType(uriForFile, intent.getType());
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                if (queryIntentActivities == null) {
                    return true;
                }
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && (str = activityInfo.packageName) != null) {
                        context.grantUriPermission(str, uriForFile, 1);
                    }
                }
            } catch (IllegalArgumentException e2) {
                if (f48194a) {
                    throw e2;
                }
                return false;
            }
        }
        return true;
    }

    public static void o() {
        h.a().edit().putLong("install_authorize_guide_time_key", System.currentTimeMillis()).apply();
    }

    public static void p() {
        h.a().edit().putLong("install_continue_guide_time_key", System.currentTimeMillis()).apply();
    }

    public static void q(int i) {
        if (i > 0) {
            h.a().edit().putInt("install_guide_max_count_key", i).apply();
        }
    }

    public static void r(boolean z) {
        h.a().edit().putBoolean("install_guide_switch_key", z).apply();
    }

    public static void s() {
        h.a().edit().putInt("install_guide_count_key", h.a().getInt("install_guide_count_key", 0) + 1).apply();
    }
}
