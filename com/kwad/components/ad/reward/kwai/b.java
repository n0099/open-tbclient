package com.kwad.components.ad.reward.kwai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static TemplateConfig fU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            SdkConfigData rZ = d.rZ();
            if (rZ == null) {
                return null;
            }
            return rZ.templateConfigMap.rewardReflowConfig;
        }
        return (TemplateConfig) invokeV.objValue;
    }

    public static int fV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.nR.getValue().intValue() : invokeV.intValue;
    }

    public static String fW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.nV.getValue() : (String) invokeV.objValue;
    }

    public static int fX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.nS.getValue().intValue() : invokeV.intValue;
    }

    public static boolean fY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.nU.getValue().booleanValue() : invokeV.booleanValue;
    }

    public static int fZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a.nT.getValue().intValue() : invokeV.intValue;
    }

    public static boolean ga() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a.nX.getValue().intValue() == 1 : invokeV.booleanValue;
    }

    public static float gb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.oc.getValue().floatValue() : invokeV.floatValue;
    }

    public static boolean gc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a.oc.getValue().floatValue() > 0.0f && a.oc.getValue().floatValue() < 1.0f : invokeV.booleanValue;
    }

    public static boolean gd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a.od.getValue().booleanValue() : invokeV.booleanValue;
    }

    public static long ge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a.oa.getValue().intValue() : invokeV.longValue;
    }

    public static int gf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? a.ob.getValue().intValue() : invokeV.intValue;
    }

    public static int gg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? a.oe.getValue().intValue() : invokeV.intValue;
    }

    public static boolean gh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? a.og.getValue().booleanValue() : invokeV.booleanValue;
    }

    public static boolean gi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? a.of.getValue().booleanValue() : invokeV.booleanValue;
    }

    public static boolean gj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? a.oh.getValue().intValue() == 1 || a.oh.getValue().intValue() == 3 : invokeV.booleanValue;
    }

    public static boolean h(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, adInfo)) == null) ? !i(adInfo) && com.kwad.sdk.core.response.a.a.bJ(adInfo) && ga() : invokeL.booleanValue;
    }

    public static boolean i(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, adInfo)) == null) ? com.kwad.sdk.core.response.a.a.bJ(adInfo) && a.nZ.getValue().intValue() == 1 : invokeL.booleanValue;
    }

    public static boolean j(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, adInfo)) == null) ? h(adInfo) : invokeL.booleanValue;
    }
}
