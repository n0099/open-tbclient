package com.kwad.components.ad.interstitial.kwai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adInfo)) == null) {
            int intValue = a.e.b().intValue();
            if (com.kwad.sdk.core.response.a.a.W(adInfo)) {
                return Math.min(intValue, com.kwad.sdk.core.response.a.a.c(adInfo));
            }
            if (intValue > 60) {
                return 60;
            }
            return intValue;
        }
        return invokeL.intValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.g.b().booleanValue() : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean b(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adInfo)) == null) ? com.kwad.sdk.core.response.a.a.ba(adInfo) && a.h.b().intValue() == 1 : invokeL.booleanValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.b.b().intValue() : invokeV.intValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a.c.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a.d.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.i.b().intValue() : invokeV.intValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a.f.b().intValue() == 1 : invokeV.booleanValue;
    }
}
