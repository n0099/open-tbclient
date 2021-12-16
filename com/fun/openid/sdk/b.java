package com.fun.openid.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f56336b;
    public transient /* synthetic */ FieldHolder $fh;

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String str = Build.BRAND;
            if (FunOpenIDSdk.isLogEnabled()) {
                String str2 = "==========brand = " + str;
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
                return new m();
            }
            if (str.equalsIgnoreCase(RomUtils.MANUFACTURER_OPPO) || str.equalsIgnoreCase("oneplus")) {
                return new k();
            }
            if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
                return new g();
            }
            if (Build.MANUFACTURER.equalsIgnoreCase(com.kuaishou.weapon.un.g.f57226j)) {
                return new l();
            }
            return null;
        }
        return (f) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            q a2 = q.a(context);
            a2.getClass();
            if (q.f56347b) {
                String str = q.f56353h;
                if (str != null) {
                    return str;
                }
                a2.a(0, null);
                if (q.f56348c == null) {
                    Context context2 = q.a;
                    q.f56348c = new s(q.f56354i, 0, null);
                    context2.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, q.f56348c);
                }
                return q.f56353h;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
