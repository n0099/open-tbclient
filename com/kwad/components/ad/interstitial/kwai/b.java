package com.kwad.components.ad.interstitial.kwai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int b(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adInfo)) == null) {
            int intValue = a.fN.getValue().intValue();
            if (com.kwad.sdk.core.response.a.a.aB(adInfo)) {
                return Math.min(intValue, com.kwad.sdk.core.response.a.a.B(adInfo));
            }
            if (intValue > 60) {
                return 60;
            }
            return intValue;
        }
        return invokeL.intValue;
    }

    public static boolean c(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) ? com.kwad.sdk.core.response.a.a.bJ(adInfo) && a.fQ.getValue().intValue() == 1 : invokeL.booleanValue;
    }

    public static boolean ci() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.fP.getValue().booleanValue() : invokeV.booleanValue;
    }

    public static boolean cj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.fJ.getValue().intValue() == 1 : invokeV.booleanValue;
    }

    public static int ck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.fK.getValue().intValue() : invokeV.intValue;
    }

    public static boolean cl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a.fL.getValue().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean cm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a.fM.getValue().intValue() == 1 : invokeV.booleanValue;
    }

    public static int cn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.fR.getValue().intValue() : invokeV.intValue;
    }

    public static boolean co() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a.fO.getValue().intValue() == 1 : invokeV.booleanValue;
    }
}
