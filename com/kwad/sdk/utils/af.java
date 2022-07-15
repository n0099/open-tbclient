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
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
/* loaded from: classes5.dex */
public final class af {
    public static String a(String str) {
        PackageInfo packageArchiveInfo;
        if (!new File(str).exists()) {
            com.kwad.sdk.core.d.b.d("PackageUtil", "cannot save package, download apk is not exists.");
            return null;
        }
        Context a = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        if (a == null || (packageArchiveInfo = a.getPackageManager().getPackageArchiveInfo(str, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.applicationInfo.packageName;
    }

    public static void a(String str, String str2) {
        String str3;
        com.kwad.sdk.core.d.b.d("PackageUtil", "saveDownloadFile " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str3 = "cannot save package, has no download apk info.";
        } else {
            File file = new File(str);
            if (file.exists()) {
                Context a = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
                if (a == null) {
                    return;
                }
                as.b(a, str2, file.length());
                try {
                    as.a(a, str2, a.b(file));
                    return;
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.a(e);
                    return;
                }
            }
            str3 = "cannot save package, download apk is not exists.";
        }
        com.kwad.sdk.core.d.b.d("PackageUtil", str3);
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static int b(@Nullable Context context, String str) {
        if (context == null || str == null || c.a(context) || ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            return -1;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(absolutePath + "/Android/data/" + str);
        return (file.exists() && file.isDirectory()) ? 1 : 0;
    }

    public static int b(String str, String str2) {
        String str3;
        ApplicationInfo applicationInfo;
        com.kwad.sdk.core.d.b.d("PackageUtil", "isPackageChanged " + str + " packageName " + str2);
        Context a = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        if (a == null) {
            return 0;
        }
        long b = as.b(a, str);
        String c = as.c(a, str);
        if (TextUtils.isEmpty(c) || b <= 0) {
            str3 = "cannot judge package, has no download apk info.";
        } else {
            try {
                PackageInfo packageInfo = a.getApplicationContext().getPackageManager().getPackageInfo(str2, 0);
                if (TextUtils.isEmpty(str2) || packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || TextUtils.isEmpty(applicationInfo.publicSourceDir)) {
                    str3 = "cannot judge package, cannot get installed apk info.";
                } else {
                    File file = new File(packageInfo.applicationInfo.publicSourceDir);
                    if (!file.exists()) {
                        str3 = "cannot judge package, insgtalled apk is not exists.";
                    } else if (b != file.length()) {
                        return 1;
                    } else {
                        if (TextUtils.isEmpty(c)) {
                            str3 = "cannot judge package, cannot calculate md5 of download file.";
                        } else {
                            String b2 = a.b(file);
                            if (!TextUtils.isEmpty(b2)) {
                                return c.equalsIgnoreCase(b2) ? 2 : 1;
                            }
                            str3 = "cannot judge package, cannot calculate md5 of installed file.";
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                com.kwad.sdk.core.d.b.a(e);
                return 0;
            }
        }
        com.kwad.sdk.core.d.b.d("PackageUtil", str3);
        return 0;
    }

    public static boolean c(@Nullable Context context, @Nullable String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            com.kwad.sdk.core.d.b.a("PackageUtil", "openApp context: " + context);
            launchIntentForPackage.setFlags(337641472);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d(@Nullable Context context, @Nullable String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                Intent intent = new Intent("android.intent.action.VIEW");
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
                com.kwad.sdk.core.d.b.b(e);
            }
        }
        return false;
    }
}
