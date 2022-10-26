package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public final class b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsScene fn;
    public KsInterstitialAd.AdInteractionListener fo;
    public d fp;
    public final AdTemplate mAdTemplate;

    public b(KsScene ksScene, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksScene, adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fn = ksScene;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAdTemplate : (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.a.a.ap(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.a.a.aD(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final boolean isVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.a.a.aB(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, adExposureFailedReason) == null) {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adInteractionListener) == null) {
            this.fo = adInteractionListener;
            d dVar = this.fp;
            if (dVar != null) {
                dVar.setAdInteractionListener(adInteractionListener);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setBidEcpm(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            adTemplate.mBidEcpm = i;
            com.kwad.sdk.core.report.a.aA(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, ksVideoPlayConfig) == null) {
            if (activity == null) {
                com.kwad.sdk.core.e.b.e("StayAdHelper", "showInterstitialAd activity must not be null");
                return;
            }
            com.kwad.components.ad.interstitial.monitor.b.cr().ct();
            this.mAdTemplate.adShowStartTimeStamp = SystemClock.elapsedRealtime();
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            if (ksVideoPlayConfig.isVideoSoundEnable()) {
                this.mAdTemplate.mInitVoiceStatus = 2;
            } else {
                this.mAdTemplate.mInitVoiceStatus = 1;
            }
            com.kwad.sdk.kwai.kwai.c.rd().aI(true);
            if (this.fp == null) {
                d dVar = new d(activity, this.mAdTemplate, ksVideoPlayConfig, this.fo);
                this.fp = dVar;
                dVar.cf();
            }
        }
    }
}
