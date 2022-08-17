package com.fun.ad.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.repackage.pl9;
/* loaded from: classes4.dex */
public class FunAdCallbackWithBasePrice implements FunAdCallback, pl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FunAdCallbackWithBasePrice() {
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

    @Override // com.repackage.pl9
    public final void onAdClicked(Ssp.Pid pid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pid) == null) {
            onAdClicked(pid.type, pid.pid, pid.ssp.sspId, pid.basePrice);
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdClicked(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
        }
    }

    public void onAdClicked(String str, String str2, String str3, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, Double.valueOf(d)}) == null) {
        }
    }

    @Override // com.repackage.pl9
    public final void onAdClose(Ssp.Pid pid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pid) == null) {
            onAdClose(pid.type, pid.pid, pid.ssp.sspId, pid.basePrice);
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdClose(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
        }
    }

    public void onAdClose(String str, String str2, String str3, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Double.valueOf(d)}) == null) {
        }
    }

    @Override // com.repackage.pl9
    public final void onAdLoad(Ssp.Pid pid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pid) == null) {
            onAdLoad(pid.type, pid.pid, pid.ssp.sspId, pid.basePrice);
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdLoad(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
        }
    }

    public void onAdLoad(String str, String str2, String str3, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, str3, Double.valueOf(d)}) == null) {
        }
    }

    @Override // com.repackage.pl9
    public final void onAdLoadError(Ssp.Pid pid, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, pid, i, str) == null) {
            onAdLoadError(pid.type, pid.pid, pid.ssp.sspId, pid.basePrice, i, str);
        }
    }

    public void onAdLoadError(String str, String str2, String str3, double d, int i, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Double.valueOf(d), Integer.valueOf(i), str4}) == null) {
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdLoadError(String str, String str2, String str3, int i, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4}) == null) {
        }
    }

    @Override // com.repackage.pl9
    public final void onAdLoaded(Ssp.Pid pid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pid) == null) {
            onAdLoaded(pid.type, pid.pid, pid.ssp.sspId, pid.basePrice);
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdLoaded(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, str, str2, str3) == null) {
        }
    }

    public void onAdLoaded(String str, String str2, String str3, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Double.valueOf(d)}) == null) {
        }
    }

    @Override // com.repackage.pl9
    public final void onAdShow(Ssp.Pid pid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pid) == null) {
            onAdShow(pid.type, pid.pid, pid.ssp.sspId, pid.basePrice);
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdShow(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, str3) == null) {
        }
    }

    public void onAdShow(String str, String str2, String str3, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{str, str2, str3, Double.valueOf(d)}) == null) {
        }
    }

    @Override // com.repackage.pl9
    public final void onAdShowError(Ssp.Pid pid, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048594, this, pid, i, str) == null) {
            onAdShowError(pid.type, pid.pid, pid.ssp.sspId, pid.basePrice, i, str);
        }
    }

    public void onAdShowError(String str, String str2, String str3, double d, int i, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, str2, str3, Double.valueOf(d), Integer.valueOf(i), str4}) == null) {
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdShowError(String str, String str2, String str3, int i, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4}) == null) {
        }
    }

    @Override // com.repackage.pl9
    public final void onRewardedVideo(Ssp.Pid pid, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{pid, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            String str = pid.type;
            String str2 = pid.pid;
            Ssp ssp = pid.ssp;
            onRewardedVideo(str, str2, ssp.sspId, pid.basePrice, z, i, ssp.type);
        }
    }

    public void onRewardedVideo(String str, String str2, String str3, double d, boolean z, int i, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{str, str2, str3, Double.valueOf(d), Boolean.valueOf(z), Integer.valueOf(i), str4}) == null) {
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onRewardedVideo(String str, String str2, String str3, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
        }
    }
}
