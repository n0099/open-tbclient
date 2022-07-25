package com.sdk.base.api;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.utils.app.AppUtils;
import com.sdk.n.a;
import com.sdk.p.b;
import com.sdk.q.d;
/* loaded from: classes7.dex */
public class ToolUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ToolUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String Base64_Decrypt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? d.a(str) : (String) invokeL.objValue;
    }

    public static String RsaDecrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? b.a(str, str2) : (String) invokeLL.objValue;
    }

    public static void clearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            a.b(com.sdk.b.a.a, "cache clear", com.sdk.b.a.b);
            com.sdk.j.a.a(context, YYInnerSSOLoginActivity.o);
        }
    }

    public static String getAppMd5(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? AppUtils.getAppMd5(context) : (String) invokeL.objValue;
    }
}
