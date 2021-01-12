package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;
/* loaded from: classes4.dex */
public class y {
    public static String a(String str) {
        PackageInfo packageArchiveInfo;
        if (!new File(str).exists()) {
            com.kwad.sdk.core.d.a.c("PackageUtil", "cannot save package, download apk is not exists.");
            return null;
        }
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.applicationInfo.packageName;
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.kwad.sdk.core.d.a.c("PackageUtil", "cannot save package, has no download apk info.");
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            com.kwad.sdk.core.d.a.c("PackageUtil", "cannot save package, download apk is not exists.");
            return;
        }
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            ae.b(context, str2, file.length());
            try {
                ae.a(context, str2, c.b(file));
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static int b(String str) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return 0;
        }
        long b2 = ae.b(context, str);
        String c = ae.c(context, str);
        if (TextUtils.isEmpty(c) || b2 <= 0) {
            com.kwad.sdk.core.d.a.c("PackageUtil", "cannot judge package, has no download apk info.");
            return 0;
        }
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 0);
            if (TextUtils.isEmpty(str) || packageInfo == null || packageInfo.applicationInfo == null || TextUtils.isEmpty(packageInfo.applicationInfo.publicSourceDir)) {
                com.kwad.sdk.core.d.a.c("PackageUtil", "cannot judge package, cannot get installed apk info.");
                return 0;
            }
            File file = new File(packageInfo.applicationInfo.publicSourceDir);
            if (!file.exists()) {
                com.kwad.sdk.core.d.a.c("PackageUtil", "cannot judge package, insgtalled apk is not exists.");
                return 0;
            } else if (b2 == file.length()) {
                if (TextUtils.isEmpty(c)) {
                    com.kwad.sdk.core.d.a.c("PackageUtil", "cannot judge package, cannot calculate md5 of download file.");
                    return 0;
                }
                String b3 = c.b(file);
                if (!TextUtils.isEmpty(b3)) {
                    return c.equalsIgnoreCase(b3) ? 2 : 1;
                }
                com.kwad.sdk.core.d.a.c("PackageUtil", "cannot judge package, cannot calculate md5 of installed file.");
                return 0;
            } else {
                return 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            com.kwad.sdk.core.d.a.a(e);
            return 0;
        }
    }

    public static void b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(337641472);
                context.startActivity(launchIntentForPackage);
            }
        } catch (Exception e) {
        }
    }

    public static void c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
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
        } catch (Exception e) {
        }
    }
}
