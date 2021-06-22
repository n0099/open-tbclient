package d.a.m0.f.i.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    public static boolean a(Context context, String str) {
        if (context != null) {
            try {
                if (context.getPackageManager() != null) {
                    context.getPackageManager().getPackageInfo(str, 0);
                    return true;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean b(Context context, File file, boolean z) {
        if (context != null && file != null && file.isFile() && file.exists()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(1342177280);
                intent.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", context.getPackageName());
                if (z) {
                    intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                }
                if (!h.m()) {
                    intent.setComponent(new ComponentName("com.android.packageinstaller", "com.android.packageinstaller.PackageInstallerActivity"));
                }
                e(context, file, intent);
                context.startActivity(intent);
            } catch (Exception unused) {
                intent.setComponent(null);
                e(context, file, intent);
                try {
                    context.startActivity(intent);
                } catch (Exception unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean c(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return b(AppRuntime.getAppContext(), new File(str), z);
        } catch (Exception unused) {
            return false;
        }
    }

    public static String d(Context context, @NonNull String str) {
        PackageInfo packageArchiveInfo;
        File file = new File(str);
        return (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1)) == null) ? "" : packageArchiveInfo.packageName;
    }

    public static boolean e(Context context, File file, Intent intent) {
        ActivityInfo activityInfo;
        String str;
        if (h.m()) {
            try {
                Uri r = d.a.m0.f.i.m.a.b().r(context, file);
                if (r == null) {
                    return false;
                }
                intent.setDataAndType(r, intent.getType());
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                if (queryIntentActivities == null) {
                    return true;
                }
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && (str = activityInfo.packageName) != null) {
                        context.grantUriPermission(str, r, 1);
                    }
                }
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return true;
    }
}
