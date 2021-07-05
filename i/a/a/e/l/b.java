package i.a.a.e.l;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import i.a.a.e.g;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.ThemeColorConfig;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static PaysSettingInfo f75851a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f75852b = "https://web.yy.com/yy_wallet/pay-protocol.html?";

    /* renamed from: c  reason: collision with root package name */
    public static String f75853c = "https://web.yy.com/yy_wallet/wallet.html?";

    /* renamed from: d  reason: collision with root package name */
    public static String f75854d = "https://web.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-690204908, "Li/a/a/e/l/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-690204908, "Li/a/a/e/l/b;");
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
            sb.append("&sdkVersion=4.2.20-bdpay");
            int i2 = 0;
            ThemeColorConfig themeColorConfig = payUIKitConfig.themeColorConfig;
            if (themeColorConfig != null && themeColorConfig.getThemeResId().intValue() == g.PayUi_Yellow_Theme) {
                i2 = 1;
            }
            sb.append("&theme=" + i2);
            String token = payUIKitConfig.revenueConfig.getToken();
            if (payUIKitConfig.revenueConfig.getTokenCallback() != null) {
                token = payUIKitConfig.revenueConfig.getTokenCallback().onUpdateToken();
            }
            sb.append("&ticket=" + token);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String b(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, payUIKitConfig)) == null) {
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                return a(f75854d, payUIKitConfig);
            }
            return f75854d;
        }
        return (String) invokeL.objValue;
    }

    public static String c(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, payUIKitConfig)) == null) {
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                return a(f75853c, payUIKitConfig);
            }
            return f75853c;
        }
        return (String) invokeL.objValue;
    }

    public static String d(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, payUIKitConfig)) == null) {
            if (payUIKitConfig == null && payUIKitConfig.revenueConfig == null) {
                return f75852b;
            }
            return a(f75852b, payUIKitConfig);
        }
        return (String) invokeL.objValue;
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) {
            if (z) {
                f75852b = "https://webtest.yy.com/yy_wallet/pay-protocol.html?";
                f75853c = "https://webtest.yy.com/yy_wallet/wallet.html?";
                f75854d = "https://webtest.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
                return;
            }
            f75852b = "https://web.yy.com/yy_wallet/pay-protocol.html?";
            f75853c = "https://web.yy.com/yy_wallet/wallet.html?";
            f75854d = "https://web.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
        }
    }
}
