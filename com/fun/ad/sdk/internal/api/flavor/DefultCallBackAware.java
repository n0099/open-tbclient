package com.fun.ad.sdk.internal.api.flavor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import java.util.Map;
/* loaded from: classes9.dex */
public class DefultCallBackAware implements CallBackAware {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DefultCallBackAware() {
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

    @Override // com.fun.ad.sdk.internal.api.flavor.CallBackAware
    public boolean needRipper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.flavor.CallBackAware
    public void onAdClicked(FunAdInteractionListener funAdInteractionListener, String str, String str2, String str3, RippedAd rippedAd, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{funAdInteractionListener, str, str2, str3, rippedAd, map}) == null) {
            funAdInteractionListener.onAdClicked(str, str2, str3);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.flavor.CallBackAware
    public void onAdClose(FunAdInteractionListener funAdInteractionListener, String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, funAdInteractionListener, str, str2, str3, map) == null) {
            funAdInteractionListener.onAdClose(str);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.flavor.CallBackAware
    public void onRewardedVideo(FunAdInteractionListener funAdInteractionListener, String str, boolean z, String str2, int i, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{funAdInteractionListener, str, Boolean.valueOf(z), str2, Integer.valueOf(i), str3, map}) == null) {
            funAdInteractionListener.onRewardedVideo(str, str2, str3);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.flavor.CallBackAware
    public void show(FunAdInteractionListener funAdInteractionListener, String str, String str2, String str3, RippedAd rippedAd, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{funAdInteractionListener, str, str2, str3, rippedAd, map}) == null) {
            funAdInteractionListener.onAdShow(str, str2, str3);
        }
    }
}
