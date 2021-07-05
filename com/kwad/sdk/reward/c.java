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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.g;
/* loaded from: classes7.dex */
public class c implements KsRewardVideoAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f39046a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f39047b;

    /* renamed from: c  reason: collision with root package name */
    public KsRewardVideoAd.RewardAdInteractionListener f39048c;

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
        this.f39046a = adTemplate;
        this.f39047b = com.kwad.sdk.core.response.b.c.j(adTemplate);
    }

    private void a(Context context, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, ksVideoPlayConfig) == null) {
            if (!isAdEnable()) {
                com.kwad.sdk.core.d.a.b("KsRewardVideoAdControl", "isAdEnable is false");
                return;
            }
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) g.a(DevelopMangerPlugin.class)).a("KEY_INIT_VOICE_STATUS");
            if (a2 != null) {
                ksVideoPlayConfig.setVideoSoundEnable(((Boolean) a2.getValue()).booleanValue());
            }
            DevelopMangerPlugin.DevelopValue a3 = ((DevelopMangerPlugin) g.a(DevelopMangerPlugin.class)).a("KEY_SKIP_THIRTY_SECOND");
            if (a3 != null) {
                ksVideoPlayConfig.setSkipThirtySecond(((Boolean) a3.getValue()).booleanValue());
            }
            KSRewardVideoActivityProxy.launch(context, this.f39046a, ksVideoPlayConfig, this.f39048c);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.response.b.a.A(this.f39047b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public boolean isAdEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (com.kwad.sdk.core.config.c.ae() >= 0) {
                return true;
            }
            return f.b(this.f39046a);
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            AdTemplate adTemplate = this.f39046a;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.b.m(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rewardAdInteractionListener) == null) {
            this.f39048c = rewardAdInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, ksVideoPlayConfig) == null) {
            a(activity, ksVideoPlayConfig);
        }
    }
}
