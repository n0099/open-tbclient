package com.kwad.components.ad.reward.kwai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static TemplateConfig a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            SdkConfigData G = d.G();
            if (G == null) {
                return null;
            }
            return G.templateConfigMap.rewardReflowConfig;
        }
        return (TemplateConfig) invokeV.objValue;
    }

    public static boolean a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            return com.kwad.sdk.core.response.a.a.aT(adInfo) && g() != 0;
        }
        return invokeL.booleanValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a.b().intValue() : invokeV.intValue;
    }

    public static boolean b(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adInfo)) == null) ? !c(adInfo) && com.kwad.sdk.core.response.a.a.ba(adInfo) && p() : invokeL.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.e.b() : (String) invokeV.objValue;
    }

    public static boolean c(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, adInfo)) == null) ? com.kwad.sdk.core.response.a.a.ba(adInfo) && a.i.b().intValue() == 1 : invokeL.booleanValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a.b.b().intValue() : invokeV.intValue;
    }

    public static boolean d(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adInfo)) == null) ? a(adInfo) || b(adInfo) : invokeL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a.d.b().booleanValue() : invokeV.booleanValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a.c.b().intValue() : invokeV.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            int intValue = a.h.b().intValue();
            if (intValue != 1) {
                return intValue != 2 ? 0 : 2;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public static float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? a.l.b().floatValue() : invokeV.floatValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? a.l.b().floatValue() > 0.0f && a.l.b().floatValue() < 1.0f : invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? a.m.b().booleanValue() : invokeV.booleanValue;
    }

    public static long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? a.j.b().intValue() : invokeV.longValue;
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? a.k.b().intValue() : invokeV.intValue;
    }

    public static int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? a.n.b().intValue() : invokeV.intValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? a.p.b().booleanValue() : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? a.o.b().booleanValue() : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? a.g.b().intValue() == 1 : invokeV.booleanValue;
    }
}
