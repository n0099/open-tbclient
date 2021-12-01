package j.a.a.e.l;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.ThemeColorConfig;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static PaysSettingInfo a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f64197b = "https://web.yy.com/yy_wallet/pay-protocol.html?";

    /* renamed from: c  reason: collision with root package name */
    public static String f64198c = "https://web.yy.com/yy_wallet/wallet.html?";

    /* renamed from: d  reason: collision with root package name */
    public static String f64199d = "https://web.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-561122096, "Lj/a/a/e/l/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-561122096, "Lj/a/a/e/l/e;");
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
            sb.append("&sdkVersion=4.3.0-bdpay");
            int i2 = 0;
            ThemeColorConfig themeColorConfig = payUIKitConfig.themeColorConfig;
            if (themeColorConfig != null && themeColorConfig.getThemeResId().intValue() == j.a.a.e.g.PayUi_Yellow_Theme) {
                i2 = 1;
            }
            sb.append("&theme=" + i2);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String b(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, payUIKitConfig)) == null) {
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                return a(f64199d, payUIKitConfig);
            }
            return f64199d;
        }
        return (String) invokeL.objValue;
    }

    public static String c(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, payUIKitConfig)) == null) {
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                return a(f64198c, payUIKitConfig);
            }
            return f64198c;
        }
        return (String) invokeL.objValue;
    }

    public static String d(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, payUIKitConfig)) == null) {
            if (payUIKitConfig == null && payUIKitConfig.revenueConfig == null) {
                return f64197b;
            }
            return a(f64197b, payUIKitConfig);
        }
        return (String) invokeL.objValue;
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            if (z) {
                f64197b = "https://webtest.yy.com/yy_wallet/pay-protocol.html?";
                f64198c = "https://webtest.yy.com/yy_wallet/wallet.html?";
                f64199d = "https://webtest.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
                return;
            }
            f64197b = "https://web.yy.com/yy_wallet/pay-protocol.html?";
            f64198c = "https://web.yy.com/yy_wallet/wallet.html?";
            f64199d = "https://web.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
        }
    }
}
