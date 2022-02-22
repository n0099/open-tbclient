package j.a.a.e.p;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.ThemeColorConfig;
/* loaded from: classes5.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public static final o a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-561002622, "Lj/a/a/e/p/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-561002622, "Lj/a/a/e/p/o;");
                return;
            }
        }
        a = new o();
    }

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final int a(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        ThemeColorConfig themeColorConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, payUIKitConfig)) == null) {
            if (payUIKitConfig != null && (themeColorConfig = payUIKitConfig.themeColorConfig) != null && themeColorConfig.getThemeResId() != null) {
                Integer themeResId = payUIKitConfig.themeColorConfig.getThemeResId();
                if (themeResId == null) {
                    Intrinsics.throwNpe();
                }
                return themeResId.intValue();
            }
            return j.a.a.e.i.PayUi_Base_Theme;
        }
        return invokeL.intValue;
    }

    public final boolean b(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        ThemeColorConfig themeColorConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payUIKitConfig)) == null) {
            if (payUIKitConfig == null || (themeColorConfig = payUIKitConfig.themeColorConfig) == null) {
                return true;
            }
            Integer themeResId = themeColorConfig != null ? themeColorConfig.getThemeResId() : null;
            return themeResId != null && themeResId.intValue() == j.a.a.e.i.PayUi_Base_Theme;
        }
        return invokeL.booleanValue;
    }
}
