package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import java.util.Random;
/* loaded from: classes15.dex */
public class h {
    public static String a() {
        return a("com.tencent.mobileqq", GDTADManager.getInstance().getSM().getInteger("qqNotFoundSampleRate", 1000));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0019 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0046 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.qq.e.comm.plugin.y.c */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.qq.e.comm.plugin.y.c] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private static String a(String str, int i) {
        String str2 = 0;
        str2 = 0;
        str2 = 0;
        str2 = 0;
        str2 = 0;
        com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("getVersionName error, packageName == null");
            com.qq.e.comm.plugin.y.u.a(100192, 1, null, dVar);
        } else {
            dVar.a(Config.INPUT_DEF_PKG, str);
            Context appContext = GDTADManager.getInstance().getAppContext();
            if (appContext == null) {
                GDTLogger.e("getVersionName error, context == null, pkg = " + str);
                com.qq.e.comm.plugin.y.u.a(100192, 2, null, dVar);
            } else {
                try {
                    PackageManager packageManager = appContext.getPackageManager();
                    if (packageManager == null) {
                        GDTLogger.e("getVersionName error, pm == null, pkg = " + str);
                        com.qq.e.comm.plugin.y.u.a(100192, 3, null, dVar);
                    } else {
                        PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                        if (packageInfo == null) {
                            GDTLogger.e("getVersionName error, info == null, pkg = " + str);
                            com.qq.e.comm.plugin.y.u.a(100192, 4, null, dVar);
                        } else {
                            str2 = packageInfo.versionName;
                        }
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    ai.a("getVersionName error, exception = %s", e.toString());
                    if (new Random().nextInt(10000) < i) {
                        com.qq.e.comm.plugin.y.u.a(100192, 5, str2, dVar);
                    }
                }
            }
        }
        return str2;
    }
}
