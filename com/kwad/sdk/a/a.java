package com.kwad.sdk.a;

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
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.f;
/* loaded from: classes2.dex */
public class a implements KsInterstitialAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KsScene f64713a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final AdTemplate f64714b;

    /* renamed from: c  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f64715c;

    /* renamed from: d  reason: collision with root package name */
    public b f64716d;

    public a(@NonNull KsScene ksScene, @NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksScene, adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64713a = ksScene;
        this.f64714b = adTemplate;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.response.b.a.x(c.i(this.f64714b)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.b.a.w(c.i(this.f64714b)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.b.a.H(c.i(this.f64714b)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public boolean isVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.b.a.F(c.i(this.f64714b)) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public void setAdInteractionListener(@NonNull KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adInteractionListener) == null) {
            this.f64715c = adInteractionListener;
            b bVar = this.f64716d;
            if (bVar != null) {
                bVar.a(adInteractionListener);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            AdTemplate adTemplate = this.f64714b;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.a.m(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        AdTemplate adTemplate;
        int i2;
        DevelopMangerPlugin.DevelopValue a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, activity, ksVideoPlayConfig) == null) {
            if (activity == null) {
                com.kwad.sdk.core.d.a.e("InterstitialAdControl", "showInterstitialAd activity must not be null");
                return;
            }
            DevelopMangerPlugin developMangerPlugin = (DevelopMangerPlugin) f.a(DevelopMangerPlugin.class);
            if (developMangerPlugin != null && (a2 = developMangerPlugin.a("KEY_INIT_VOICE_STATUS")) != null) {
                ksVideoPlayConfig.setVideoSoundEnable(((Boolean) a2.getValue()).booleanValue());
            }
            if (ksVideoPlayConfig.isVideoSoundEnable()) {
                adTemplate = this.f64714b;
                i2 = 2;
            } else {
                adTemplate = this.f64714b;
                i2 = 1;
            }
            adTemplate.mInitVoiceStatus = i2;
            if (this.f64716d == null) {
                b bVar = new b(activity, this.f64714b, ksVideoPlayConfig, this.f64715c);
                this.f64716d = bVar;
                bVar.a();
            }
        }
    }
}
