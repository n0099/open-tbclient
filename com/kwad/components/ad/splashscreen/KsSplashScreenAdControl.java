package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.AbstrackKsSplashScreenAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public class KsSplashScreenAdControl extends AbstrackKsSplashScreenAd implements com.kwad.components.core.internal.api.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final AdTemplate mAdTemplate;
    public AdResultData xR;
    public KsScene xS;

    public KsSplashScreenAdControl(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksScene, adResultData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.xR = adResultData;
        this.xS = ksScene;
        this.mAdTemplate = adResultData.getAdTemplateList().get(0);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAdTemplate : (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) : invokeV.intValue;
    }

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, splashScreenAdInteractionListener)) == null) {
            com.kwad.components.ad.splashscreen.kwai.a aVar = (com.kwad.components.ad.splashscreen.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.ad.splashscreen.kwai.a.class);
            if (aVar != null) {
                return aVar.jI();
            }
            return null;
        }
        return (KsFragment) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.a.a.ap(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.a.a.aD(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, splashScreenAdInteractionListener)) == null) {
            d a = d.a(context, this.xS, this.xR);
            a.setSplashScreenAdListener(splashScreenAdInteractionListener);
            com.kwad.components.splash.monitor.a.qG();
            com.kwad.components.splash.monitor.a.X(this.mAdTemplate);
            return a;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isAdEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (SplashPreloadManager.qD().f(this.xR)) {
                return true;
            }
            SplashPreloadManager.qD();
            return SplashPreloadManager.g(this.xR);
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? com.kwad.sdk.core.response.a.a.aB(com.kwad.sdk.core.response.a.d.bQ(this.xR.getAdTemplateList().get(0))) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, adExposureFailedReason) == null) {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            adTemplate.mBidEcpm = i;
            com.kwad.sdk.core.report.a.aA(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean showSplashMiniWindowIfNeeded(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener, Rect rect) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, splashScreenAdInteractionListener, rect)) == null) {
            String A = com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
            if (A == null || StringUtil.NULL_STRING.equals(A) || A.equals("")) {
                return false;
            }
            return new c(context, String.valueOf(A.hashCode()), true, splashScreenAdInteractionListener).a(rect);
        }
        return invokeLLL.booleanValue;
    }
}
