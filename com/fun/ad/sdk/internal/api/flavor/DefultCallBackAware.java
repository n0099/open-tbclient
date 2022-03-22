package com.fun.ad.sdk.internal.api.flavor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
/* loaded from: classes6.dex */
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
    public void onAdClicked(FunAdInteractionListener funAdInteractionListener, String str, String str2, String str3, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdInteractionListener, str, str2, str3, strArr) == null) {
            funAdInteractionListener.onAdClicked(str, str2, str3);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.flavor.CallBackAware
    public void onRewardedVideo(FunAdInteractionListener funAdInteractionListener, String str, boolean z, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{funAdInteractionListener, str, Boolean.valueOf(z), strArr}) == null) {
            funAdInteractionListener.onRewardedVideo(str);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.flavor.CallBackAware
    public void show(FunAdInteractionListener funAdInteractionListener, String str, String str2, String str3, double d2, RippedAd rippedAd, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{funAdInteractionListener, str, str2, str3, Double.valueOf(d2), rippedAd, strArr}) == null) {
            funAdInteractionListener.onAdShow(str, str2, str3);
        }
    }
}
