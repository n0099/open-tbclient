package d.a.l0.g.c.e;

import android.app.Activity;
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
import com.baidu.swan.gamecenter.appmanager.install.InstallPluginDelegateActivity;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50701a = k.f46875a;

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
        return h.a().getBoolean("install_guide_switch_key", false);
    }

    public static boolean g() {
        return h.a().getBoolean("install_result_key", false);
    }

    public static boolean h(Context context, String str) {
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

    public static boolean i(Context context, File file, boolean z) {
        if (context != null && file != null && file.isFile() && file.exists()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (f50701a) {
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
                if ((context instanceof Activity) && g()) {
                    intent.setAction("android.intent.action.INSTALL_PACKAGE");
                    intent.setFlags(0);
                    intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.addFlags(1);
                    }
                    ((Activity) context).startActivityForResult(intent, context instanceof InstallPluginDelegateActivity ? InstallPluginDelegateActivity.INSTALL_REQUEST_CODE : 0);
                } else {
                    context.startActivity(intent);
                }
                if (f50701a) {
                    Log.e("GameCenterApkUtil", "install apk done");
                }
            } catch (Exception e2) {
                if (f50701a) {
                    e2.printStackTrace();
                }
                intent.setComponent(null);
                n(context, file, intent);
                try {
                    context.startActivity(intent);
                    if (f50701a) {
                        Log.e("GameCenterApkUtil", "retry install apk done");
                    }
                } catch (Exception e3) {
                    if (f50701a) {
                        e3.printStackTrace();
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean j(Context context, String str, boolean z) {
        if (f50701a) {
            Log.e("GameCenterApkUtil", "call installApk filePath = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return i(context, new File(str), z);
        } catch (Exception e2) {
            if (f50701a) {
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
                    if (f50701a) {
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
                if (f50701a) {
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

    public static void q(int i2) {
        if (i2 > 0) {
            h.a().edit().putInt("install_guide_max_count_key", i2).apply();
        }
    }

    public static void r(boolean z) {
        h.a().edit().putBoolean("install_guide_switch_key", z).apply();
    }

    public static void s(boolean z) {
        h.a().putBoolean("install_result_key", z);
    }

    public static void t() {
        h.a().edit().putInt("install_guide_count_key", h.a().getInt("install_guide_count_key", 0) + 1).apply();
    }
}
