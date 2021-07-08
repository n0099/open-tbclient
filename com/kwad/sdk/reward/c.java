package com.kwad.sdk.reward;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.page.AdRewardPreviewActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
/* loaded from: classes6.dex */
public class c implements KsRewardVideoAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f36197a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f36198b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f36199c;

    /* renamed from: d  reason: collision with root package name */
    public KsRewardVideoAd.RewardAdInteractionListener f36200d;

    public c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36197a = 1;
        this.f36198b = adTemplate;
        this.f36199c = com.kwad.sdk.core.response.b.c.i(adTemplate);
    }

    private void a(Context context, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, ksVideoPlayConfig) == null) {
            if (!isAdEnable()) {
                com.kwad.sdk.core.d.a.c("KsRewardVideoAdControl", "isAdEnable is false");
                return;
            }
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_INIT_VOICE_STATUS");
            if (a2 != null) {
                ksVideoPlayConfig.setVideoSoundEnable(((Boolean) a2.getValue()).booleanValue());
            }
            DevelopMangerPlugin.DevelopValue a3 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_SKIP_THIRTY_SECOND");
            if (a3 != null) {
                ksVideoPlayConfig.setSkipThirtySecond(((Boolean) a3.getValue()).booleanValue());
            }
            if (com.kwad.sdk.core.response.b.a.af(this.f36199c)) {
                AdRewardPreviewActivityProxy.launch(context, this.f36198b, com.kwad.sdk.core.response.b.a.y(this.f36199c), this.f36200d);
            } else {
                KSRewardVideoActivityProxy.launch(context, this.f36198b, ksVideoPlayConfig, this.f36200d, this.f36197a);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.response.b.a.x(this.f36199c) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.b.a.w(this.f36199c) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.b.a.H(this.f36199c) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public boolean isAdEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (com.kwad.sdk.core.config.c.C() >= 0) {
                return true;
            }
            return g.b(this.f36198b);
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            AdTemplate adTemplate = this.f36198b;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.a.m(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rewardAdInteractionListener) == null) {
            this.f36200d = rewardAdInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, activity, ksVideoPlayConfig) == null) {
            a(activity, ksVideoPlayConfig);
        }
    }
}
