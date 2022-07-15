package com.kwad.components.ad.interstitial;

import android.app.Activity;
import androidx.annotation.NonNull;
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
/* loaded from: classes5.dex */
public final class b implements KsInterstitialAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsScene a;
    @NonNull
    public final AdTemplate b;
    public KsInterstitialAd.AdInteractionListener c;
    public d d;

    public b(@NonNull KsScene ksScene, @NonNull AdTemplate adTemplate) {
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
        this.a = ksScene;
        this.b = adTemplate;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.response.a.a.M(com.kwad.sdk.core.response.a.d.i(this.b)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.a.a.L(com.kwad.sdk.core.response.a.d.i(this.b)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.a.a.Y(com.kwad.sdk.core.response.a.d.i(this.b)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final boolean isVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.a.a.W(com.kwad.sdk.core.response.a.d.i(this.b)) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, adExposureFailedReason) == null) {
            com.kwad.sdk.core.report.a.a(this.b, i, adExposureFailedReason);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(@NonNull KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adInteractionListener) == null) {
            this.c = adInteractionListener;
            d dVar = this.d;
            if (dVar != null) {
                dVar.a(adInteractionListener);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setBidEcpm(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            AdTemplate adTemplate = this.b;
            adTemplate.mBidEcpm = i;
            com.kwad.sdk.core.report.a.l(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        AdTemplate adTemplate;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, activity, ksVideoPlayConfig) == null) {
            if (activity == null) {
                com.kwad.sdk.core.d.b.e("StayAdHelper", "showInterstitialAd activity must not be null");
                return;
            }
            com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
            if (ksVideoPlayConfig.isVideoSoundEnable()) {
                adTemplate = this.b;
                i = 2;
            } else {
                adTemplate = this.b;
                i = 1;
            }
            adTemplate.mInitVoiceStatus = i;
            if (this.d == null) {
                d dVar = new d(activity, this.b, ksVideoPlayConfig, this.c);
                this.d = dVar;
                dVar.a();
            }
        }
    }
}
