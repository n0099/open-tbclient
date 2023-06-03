package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
/* loaded from: classes10.dex */
public final class ai {
    public static void R(String str, String str2) {
        String str3;
        com.kwad.sdk.core.e.b.w("PackageUtil", "saveDownloadFile " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str3 = "cannot save package, has no download apk info.";
        } else {
            File file = new File(str);
            if (file.exists()) {
                Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
                if (context == null) {
                    return;
                }
                w.e(context, str2, file.length());
                try {
                    w.f(context, str2, a.getFileMD5(file));
                    return;
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                    return;
                }
            }
            str3 = "cannot save package, download apk is not exists.";
        }
        com.kwad.sdk.core.e.b.w("PackageUtil", str3);
    }

    public static int S(String str, String str2) {
        String str3;
        ApplicationInfo applicationInfo;
        com.kwad.sdk.core.e.b.w("PackageUtil", "isPackageChanged " + str + " packageName " + str2);
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null) {
            return 0;
        }
        long B = w.B(context, str);
        String C = w.C(context, str);
        if (TextUtils.isEmpty(C) || B <= 0) {
            str3 = "cannot judge package, has no download apk info.";
        } else {
            try {
                PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str2, 0);
                if (TextUtils.isEmpty(str2) || packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || TextUtils.isEmpty(applicationInfo.publicSourceDir)) {
                    str3 = "cannot judge package, cannot get installed apk info.";
                } else {
                    File file = new File(packageInfo.applicationInfo.publicSourceDir);
                    if (!file.exists()) {
                        str3 = "cannot judge package, insgtalled apk is not exists.";
                    } else if (B != file.length()) {
                        return 1;
                    } else {
                        if (TextUtils.isEmpty(C)) {
                            str3 = "cannot judge package, cannot calculate md5 of download file.";
                        } else {
                            String fileMD5 = a.getFileMD5(file);
                            if (!TextUtils.isEmpty(fileMD5)) {
                                return C.equalsIgnoreCase(fileMD5) ? 2 : 1;
                            }
                            str3 = "cannot judge package, cannot calculate md5 of installed file.";
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
                return 0;
            }
        }
        com.kwad.sdk.core.e.b.w("PackageUtil", str3);
        return 0;
    }

    public static boolean U(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static int V(@Nullable Context context, String str) {
        if (context == null || str == null || c.bQ(context) || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.h.i) != 0) {
            return -1;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(absolutePath + "/Android/data/" + str);
        return (file.exists() && file.isDirectory()) ? 1 : 0;
    }

    public static boolean W(@Nullable Context context, @Nullable String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            com.kwad.sdk.core.e.b.d("PackageUtil", "openApp context: " + context);
            launchIntentForPackage.setFlags(337641472);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean X(@Nullable Context context, @Nullable String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.addFlags(3);
                Uri uriForFile = Build.VERSION.SDK_INT >= 24 ? FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file) : Uri.fromFile(file);
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
                    context.grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 3);
                }
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public static String dO(String str) {
        PackageInfo packageArchiveInfo;
        if (!new File(str).exists()) {
            com.kwad.sdk.core.e.b.w("PackageUtil", "cannot save package, download apk is not exists.");
            return null;
        }
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.applicationInfo.packageName;
    }
}
