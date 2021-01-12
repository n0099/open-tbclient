package com.cmic.sso.sdk.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes6.dex */
public class f {
    private static PackageInfo U(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String d(Context context) {
        PackageInfo U = U(context);
        return U == null ? "" : U.packageName;
    }

    public static String a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String str = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(d(context), 0));
            if (str == null) {
                try {
                    PackageInfo U = U(context);
                    if (U == null) {
                        return null;
                    }
                    return context.getResources().getString(U.applicationInfo.labelRes);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return null;
                }
            }
            return str;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static String b(Context context) {
        try {
            PackageInfo U = U(context);
            if (U != null) {
                return d(context) + ETAG.ITEM_SEPARATOR + U.versionName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
