package com.fun.ad.sdk;

import androidx.core.view.InputDeviceCompat;
import b.a.a.a.f;
import b.a.a.a.u.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FunAdCallbackWithBasePrice implements FunAdCallback, f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FunAdCallbackWithBasePrice() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // b.a.a.a.f
    public final void onAdClicked(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            onAdClicked(aVar.f1449d, aVar.f1448c, aVar.l.f1444b, aVar.k);
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdClicked(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
        }
    }

    public void onAdClicked(String str, String str2, String str3, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, Double.valueOf(d2)}) == null) {
        }
    }

    @Override // b.a.a.a.f
    public final void onAdClose(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            onAdClose(aVar.f1449d, aVar.f1448c, aVar.l.f1444b, aVar.k);
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdClose(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
        }
    }

    public void onAdClose(String str, String str2, String str3, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Double.valueOf(d2)}) == null) {
        }
    }

    @Override // b.a.a.a.f
    public final void onAdLoad(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            onAdLoad(aVar.f1449d, aVar.f1448c, aVar.l.f1444b, aVar.k);
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdLoad(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
        }
    }

    public void onAdLoad(String str, String str2, String str3, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, str3, Double.valueOf(d2)}) == null) {
        }
    }

    @Override // b.a.a.a.f
    public final void onAdLoadError(h.a aVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, aVar, i2, str) == null) {
            onAdLoadError(aVar.f1449d, aVar.f1448c, aVar.l.f1444b, aVar.k, i2, str);
        }
    }

    public void onAdLoadError(String str, String str2, String str3, double d2, int i2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Double.valueOf(d2), Integer.valueOf(i2), str4}) == null) {
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdLoadError(String str, String str2, String str3, int i2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
        }
    }

    @Override // b.a.a.a.f
    public final void onAdLoaded(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            onAdLoaded(aVar.f1449d, aVar.f1448c, aVar.l.f1444b, aVar.k);
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdLoaded(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, str, str2, str3) == null) {
        }
    }

    public void onAdLoaded(String str, String str2, String str3, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Double.valueOf(d2)}) == null) {
        }
    }

    @Override // b.a.a.a.f
    public final void onAdShow(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            onAdShow(aVar.f1449d, aVar.f1448c, aVar.l.f1444b, aVar.k);
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdShow(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, str3) == null) {
        }
    }

    public void onAdShow(String str, String str2, String str3, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{str, str2, str3, Double.valueOf(d2)}) == null) {
        }
    }

    @Override // b.a.a.a.f
    public final void onAdShowError(h.a aVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048594, this, aVar, i2, str) == null) {
            onAdShowError(aVar.f1449d, aVar.f1448c, aVar.l.f1444b, aVar.k, i2, str);
        }
    }

    public void onAdShowError(String str, String str2, String str3, double d2, int i2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, str2, str3, Double.valueOf(d2), Integer.valueOf(i2), str4}) == null) {
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onAdShowError(String str, String str2, String str3, int i2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
        }
    }

    @Override // b.a.a.a.f
    public final void onRewardedVideo(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) {
            onRewardedVideo(aVar.f1449d, aVar.f1448c, aVar.l.f1444b, aVar.k);
        }
    }

    @Override // com.fun.ad.sdk.FunAdCallback
    public final void onRewardedVideo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, str, str2, str3) == null) {
        }
    }

    public void onRewardedVideo(String str, String str2, String str3, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, str2, str3, Double.valueOf(d2)}) == null) {
        }
    }
}
