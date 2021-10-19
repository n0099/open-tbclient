package com.fun.openid.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f70372a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f70373b;
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
            if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG")) {
                return new l();
            }
            return null;
        }
        return (f) invokeV.objValue;
    }
}
