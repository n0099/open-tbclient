package com.kwad.sdk.fullscreen;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes10.dex */
public class b implements KsFullScreenVideoAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f72867a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f72868b;

    /* renamed from: c  reason: collision with root package name */
    public KsFullScreenVideoAd.FullScreenVideoAdInteractionListener f72869c;

    public b(@NonNull AdTemplate adTemplate) {
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
        this.f72867a = adTemplate;
        this.f72868b = c.i(adTemplate);
    }

    private void a(Context context, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, ksVideoPlayConfig) == null) {
            if (!isAdEnable()) {
                com.kwad.sdk.core.d.a.c("KsFullScreenVideoAdControl", "isAdEnable is false");
                return;
            }
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) f.a(DevelopMangerPlugin.class)).a("KEY_INIT_VOICE_STATUS");
            if (a2 != null) {
                ksVideoPlayConfig.setVideoSoundEnable(((Boolean) a2.getValue()).booleanValue());
            }
            KsFullScreenVideoActivityProxy.launch(context, this.f72867a, ksVideoPlayConfig, this.f72869c);
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.response.b.a.x(this.f72868b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.b.a.w(this.f72868b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.b.a.H(this.f72868b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public boolean isAdEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (com.kwad.sdk.core.config.c.C() >= 0) {
                return true;
            }
            return g.b(this.f72867a);
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            AdTemplate adTemplate = this.f72867a;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.a.m(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fullScreenVideoAdInteractionListener) == null) {
            this.f72869c = fullScreenVideoAdInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, activity, ksVideoPlayConfig) == null) {
            a(activity, ksVideoPlayConfig);
        }
    }
}
