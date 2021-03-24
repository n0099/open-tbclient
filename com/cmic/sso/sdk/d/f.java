package com.cmic.sso.sdk.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes6.dex */
public class f {
    public static String a(Context context) {
        String str = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            String str2 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(d(context), 0));
            if (str2 != null) {
                return str2;
            }
            try {
                PackageInfo c2 = c(context);
                if (c2 == null) {
                    return null;
                }
                return context.getResources().getString(c2.applicationInfo.labelRes);
            } catch (Exception e2) {
                e = e2;
                str = str2;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static String b(Context context) {
        try {
            PackageInfo c2 = c(context);
            if (c2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(d(context));
                sb.append("&");
                sb.append(c2.versionName);
                return sb.toString();
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static PackageInfo c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String d(Context context) {
        PackageInfo c2 = c(context);
        return c2 == null ? "" : c2.packageName;
    }
}
