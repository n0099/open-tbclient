package com.fun.openid.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30879a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f30880b = false;

    public static f a() {
        String str = Build.BRAND;
        if (FunOpenIDSdk.isLogEnabled()) {
            Log.e(FunOpenIDSdk.TAG, "==========brand = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(RomUtils.MANUFACTURER_HUAWEI) || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new d();
        }
        if (str.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI) || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米")) {
            return new h();
        }
        if (str.equalsIgnoreCase(RomUtils.MANUFACTURER_VIVO)) {
            return new l();
        }
        if (str.equalsIgnoreCase(RomUtils.MANUFACTURER_OPPO) || str.equalsIgnoreCase("oneplus")) {
            return new k();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new g();
        }
        return null;
    }

    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
            return true;
        }
        return false;
    }
}
