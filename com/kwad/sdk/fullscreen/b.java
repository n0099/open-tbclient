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
import com.kwad.sdk.plugin.g;
import com.kwad.sdk.reward.f;
/* loaded from: classes7.dex */
public class b implements KsFullScreenVideoAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f37548a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f37549b;

    /* renamed from: c  reason: collision with root package name */
    public KsFullScreenVideoAd.FullScreenVideoAdInteractionListener f37550c;

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
        this.f37548a = adTemplate;
        this.f37549b = c.j(adTemplate);
    }

    private void a(Context context, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, ksVideoPlayConfig) == null) {
            if (!isAdEnable()) {
                com.kwad.sdk.core.d.a.b("KsFullScreenVideoAdControl", "isAdEnable is false");
                return;
            }
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) g.a(DevelopMangerPlugin.class)).a("KEY_INIT_VOICE_STATUS");
            if (a2 != null) {
                ksVideoPlayConfig.setVideoSoundEnable(((Boolean) a2.getValue()).booleanValue());
            }
            KsFullScreenVideoActivityProxy.launch(context, this.f37548a, ksVideoPlayConfig, this.f37550c);
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.response.b.a.A(this.f37549b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public boolean isAdEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (com.kwad.sdk.core.config.c.ae() >= 0) {
                return true;
            }
            return f.b(this.f37548a);
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            AdTemplate adTemplate = this.f37548a;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.b.m(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fullScreenVideoAdInteractionListener) == null) {
            this.f37550c = fullScreenVideoAdInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, ksVideoPlayConfig) == null) {
            a(activity, ksVideoPlayConfig);
        }
    }
}
