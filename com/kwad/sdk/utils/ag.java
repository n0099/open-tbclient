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
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;
/* loaded from: classes4.dex */
public class ag {
    public static String a(String str) {
        PackageInfo packageArchiveInfo;
        if (!new File(str).exists()) {
            com.kwad.sdk.core.d.a.d("PackageUtil", "cannot save package, download apk is not exists.");
            return null;
        }
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.applicationInfo.packageName;
    }

    public static void a(String str, String str2) {
        String str3;
        com.kwad.sdk.core.d.a.d("PackageUtil", "saveDownloadFile " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str3 = "cannot save package, has no download apk info.";
        } else {
            File file = new File(str);
            if (file.exists()) {
                Context context = KsAdSDKImpl.get().getContext();
                if (context == null) {
                    return;
                }
                as.b(context, str2, file.length());
                try {
                    as.a(context, str2, c.b(file));
                    return;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    return;
                }
            }
            str3 = "cannot save package, download apk is not exists.";
        }
        com.kwad.sdk.core.d.a.d("PackageUtil", str3);
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int b(@Nullable Context context, String str) {
        if (context == null || str == null) {
            return -1;
        }
        if ((context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29 || Environment.isExternalStorageLegacy()) && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f55460i) == 0) {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            File file = new File(absolutePath + "/Android/data/" + str);
            return (file.exists() && file.isDirectory()) ? 1 : 0;
        }
        return -1;
    }

    public static int b(String str, String str2) {
        String str3;
        ApplicationInfo applicationInfo;
        com.kwad.sdk.core.d.a.d("PackageUtil", "isPackageChanged " + str + " packageName " + str2);
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return 0;
        }
        long b2 = as.b(context, str);
        String c2 = as.c(context, str);
        if (TextUtils.isEmpty(c2) || b2 <= 0) {
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
                    } else if (b2 != file.length()) {
                        return 1;
                    } else {
                        if (TextUtils.isEmpty(c2)) {
                            str3 = "cannot judge package, cannot calculate md5 of download file.";
                        } else {
                            String b3 = c.b(file);
                            if (!TextUtils.isEmpty(b3)) {
                                return c2.equalsIgnoreCase(b3) ? 2 : 1;
                            }
                            str3 = "cannot judge package, cannot calculate md5 of installed file.";
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return 0;
            }
        }
        com.kwad.sdk.core.d.a.d("PackageUtil", str3);
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
            launchIntentForPackage.setFlags(337641472);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.addFlags(3);
                Uri uriForFile = Build.VERSION.SDK_INT >= 24 ? FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file) : Uri.fromFile(file);
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
                    context.grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 3);
                }
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }
}
