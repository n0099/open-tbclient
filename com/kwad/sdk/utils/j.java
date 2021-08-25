package com.kwad.sdk.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public class j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static long f73793a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1510835446, "Lcom/kwad/sdk/utils/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1510835446, "Lcom/kwad/sdk/utils/j;");
        }
    }

    public static void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, adTemplate) == null) || adTemplate == null) {
            return;
        }
        adTemplate.mVisibleTimeParam = f73793a;
        adTemplate.mOutClickTimeParam = f73793a;
    }

    public static void b(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, adTemplate) == null) || adTemplate == null) {
            return;
        }
        adTemplate.mOutClickTimeParam = System.currentTimeMillis();
    }

    public static void c(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, adTemplate) == null) || adTemplate == null) {
            return;
        }
        adTemplate.mVisibleTimeParam = System.currentTimeMillis();
    }

    public static long d(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return System.currentTimeMillis();
            }
            long j2 = adTemplate.mOutClickTimeParam;
            return j2 > 0 ? j2 : adTemplate.mVisibleTimeParam;
        }
        return invokeL.longValue;
    }
}
