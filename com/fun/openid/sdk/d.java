package com.fun.openid.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5243a;
    public static boolean b;

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
        if (((java.lang.Integer) java.lang.Class.forName("android.content.Context").getMethod("checkSelfPermission", java.lang.String.class).invoke(r7, r8)).intValue() == 0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
                return false;
            }
        }
        return true;
        return false;
    }

    public static h eAG() {
        String str = Build.BRAND;
        if (b.isLogEnabled()) {
            Log.e("FunOpenIDSdk", "==========brand = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(RomUtils.MANUFACTURER_HUAWEI) || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new f();
        }
        if (str.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI) || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米")) {
            return new j();
        }
        if (str.equalsIgnoreCase(RomUtils.MANUFACTURER_VIVO)) {
            return new n();
        }
        if (str.equalsIgnoreCase(RomUtils.MANUFACTURER_OPPO) || str.equalsIgnoreCase("oneplus")) {
            return new m();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new i();
        }
        return null;
    }
}
