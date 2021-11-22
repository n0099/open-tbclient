package i.a.a.e.l;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.ThemeColorConfig;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static PaysSettingInfo f73271a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f73272b = "https://web.yy.com/yy_wallet/pay-protocol.html?";

    /* renamed from: c  reason: collision with root package name */
    public static String f73273c = "https://web.yy.com/yy_wallet/wallet.html?";

    /* renamed from: d  reason: collision with root package name */
    public static String f73274d = "https://web.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-690204815, "Li/a/a/e/l/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-690204815, "Li/a/a/e/l/e;");
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
            if (themeColorConfig != null && themeColorConfig.getThemeResId().intValue() == i.a.a.e.g.PayUi_Yellow_Theme) {
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
                return a(f73274d, payUIKitConfig);
            }
            return f73274d;
        }
        return (String) invokeL.objValue;
    }

    public static String c(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, payUIKitConfig)) == null) {
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                return a(f73273c, payUIKitConfig);
            }
            return f73273c;
        }
        return (String) invokeL.objValue;
    }

    public static String d(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, payUIKitConfig)) == null) {
            if (payUIKitConfig == null && payUIKitConfig.revenueConfig == null) {
                return f73272b;
            }
            return a(f73272b, payUIKitConfig);
        }
        return (String) invokeL.objValue;
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) {
            if (z) {
                f73272b = "https://webtest.yy.com/yy_wallet/pay-protocol.html?";
                f73273c = "https://webtest.yy.com/yy_wallet/wallet.html?";
                f73274d = "https://webtest.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
                return;
            }
            f73272b = "https://web.yy.com/yy_wallet/pay-protocol.html?";
            f73273c = "https://web.yy.com/yy_wallet/wallet.html?";
            f73274d = "https://web.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
        }
    }
}
