package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bh;
/* loaded from: classes7.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static int f40492a = -1;

    public static af a(Context context) {
        try {
            return (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) == null || !a()) ? af.OTHER : af.HUAWEI;
        } catch (Exception unused) {
            return af.OTHER;
        }
    }

    public static boolean a() {
        try {
            String str = (String) bh.a("android.os.SystemProperties", "get", "ro.build.hw_emui_api_level", "");
            if (!TextUtils.isEmpty(str)) {
                if (Integer.parseInt(str) >= 9) {
                    return true;
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m121a(Context context) {
        Object a2 = bh.a(bh.a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object a3 = bh.a("com.google.android.gms.common.ConnectionResult", com.alipay.security.mobile.module.http.model.c.f2125g);
        if (a3 == null || !(a3 instanceof Integer)) {
            com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
            f40492a = 0;
            return false;
        }
        int intValue = ((Integer) Integer.class.cast(a3)).intValue();
        if (a2 != null) {
            if (a2 instanceof Integer) {
                f40492a = ((Integer) Integer.class.cast(a2)).intValue() == intValue ? 1 : 0;
            } else {
                f40492a = 0;
                com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("is google service can be used");
        sb.append(f40492a > 0);
        com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
        return f40492a > 0;
    }

    public static boolean b(Context context) {
        boolean z = false;
        Object a2 = bh.a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (a2 != null && (a2 instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(a2)).booleanValue();
        }
        com.xiaomi.channel.commonutils.logger.b.c("color os push  is avaliable ? :" + z);
        return z;
    }

    public static boolean c(Context context) {
        boolean z = false;
        Object a2 = bh.a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (a2 != null && (a2 instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(a2)).booleanValue();
        }
        com.xiaomi.channel.commonutils.logger.b.c("fun touch os push  is avaliable ? :" + z);
        return z;
    }
}
