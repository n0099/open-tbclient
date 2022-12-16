package com.kwad.components.ad.reward.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.api.KsRewardVideoAd;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b bVar, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, bVar, rewardAdInteractionListener) == null) || rewardAdInteractionListener == null || bVar == null) {
            return;
        }
        try {
            rewardAdInteractionListener.onExtraRewardVerify(bVar.getType());
        } catch (Exception unused) {
        }
    }

    public static boolean a(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rewardAdInteractionListener)) == null) {
            if (rewardAdInteractionListener == null) {
                return false;
            }
            try {
                for (Method method : rewardAdInteractionListener.getClass().getMethods()) {
                    if ("onExtraRewardVerify".equals(method.getName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static b gt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b(1) : (b) invokeV.objValue;
    }
}
