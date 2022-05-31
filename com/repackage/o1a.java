package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.ThemeColorConfig;
/* loaded from: classes6.dex */
public class o1a {
    public static /* synthetic */ Interceptable $ic = null;
    public static PaysSettingInfo a = null;
    public static String b = "https://web.yy.com/yy_wallet/pay-protocol.html?";
    public static String c = "https://web.yy.com/yy_wallet/wallet.html?";
    public static String d = "https://web.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755491182, "Lcom/repackage/o1a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755491182, "Lcom/repackage/o1a;");
        }
    }

    public static String a(String str, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, payUIKitConfig)) == null) {
            if (payUIKitConfig == null || payUIKitConfig.revenueConfig == null) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            sb.append("&uid=" + payUIKitConfig.revenueConfig.getUid());
            sb.append("&hostId=" + payUIKitConfig.revenueConfig.getHostId());
            sb.append("&appid=" + payUIKitConfig.revenueConfig.getAppId());
            sb.append("&usedChannel=" + payUIKitConfig.revenueConfig.getUseChannel());
            sb.append("&authType=" + payUIKitConfig.revenueConfig.getAuthType());
            sb.append("&clientVersion=" + payUIKitConfig.revenueConfig.getVersion());
            sb.append("&sdkVersion=4.3.9-bdpay212004-SNAPSHOT");
            int i = 0;
            ThemeColorConfig themeColorConfig = payUIKitConfig.themeColorConfig;
            if (themeColorConfig != null && themeColorConfig.getThemeResId().intValue() == R.style.obfuscated_res_0x7f10014f) {
                i = 1;
            }
            sb.append("&theme=" + i);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String b(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, payUIKitConfig)) == null) {
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                return a(d, payUIKitConfig);
            }
            return d;
        }
        return (String) invokeL.objValue;
    }

    public static String c(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, payUIKitConfig)) == null) {
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                return a(c, payUIKitConfig);
            }
            return c;
        }
        return (String) invokeL.objValue;
    }

    public static String d(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, payUIKitConfig)) == null) {
            if (payUIKitConfig == null && payUIKitConfig.revenueConfig == null) {
                return b;
            }
            return a(b, payUIKitConfig);
        }
        return (String) invokeL.objValue;
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            if (z) {
                b = "https://webtest.yy.com/yy_wallet/pay-protocol.html?";
                c = "https://webtest.yy.com/yy_wallet/wallet.html?";
                d = "https://webtest.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
                return;
            }
            b = "https://web.yy.com/yy_wallet/pay-protocol.html?";
            c = "https://web.yy.com/yy_wallet/wallet.html?";
            d = "https://web.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
        }
    }
}
