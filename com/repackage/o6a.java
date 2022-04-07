package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
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
/* loaded from: classes6.dex */
public final class o6a {
    public static /* synthetic */ Interceptable $ic;
    public static final o6a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755486377, "Lcom/repackage/o6a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755486377, "Lcom/repackage/o6a;");
                return;
            }
        }
        a = new o6a();
    }

    public o6a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (payUIKitConfig == null || (themeColorConfig = payUIKitConfig.themeColorConfig) == null || themeColorConfig.getThemeResId() == null) {
                return R.style.obfuscated_res_0x7f100149;
            }
            Integer themeResId = payUIKitConfig.themeColorConfig.getThemeResId();
            if (themeResId == null) {
                Intrinsics.throwNpe();
            }
            return themeResId.intValue();
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
            return themeResId != null && themeResId.intValue() == R.style.obfuscated_res_0x7f100149;
        }
        return invokeL.booleanValue;
    }
}
