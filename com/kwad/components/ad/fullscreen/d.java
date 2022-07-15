package com.kwad.components.ad.fullscreen;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.f;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class d implements KsFullScreenVideoAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public AdTemplate a;
    public AdInfo b;
    public KsFullScreenVideoAd.FullScreenVideoAdInteractionListener c;

    public d(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = adTemplate;
        this.b = com.kwad.sdk.core.response.a.d.i(adTemplate);
    }

    private void a(Context context, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, ksVideoPlayConfig) == null) {
            if (!isAdEnable()) {
                com.kwad.sdk.core.d.b.c("KsFullScreenVideoAdControl", "isAdEnable is false");
                return;
            }
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
            KsFullScreenVideoActivityProxy.launch(context, this.a, ksVideoPlayConfig, this.c);
        }
    }

    public final AdTemplate a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.a.a.M(this.b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.a.a.L(this.b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.a.a.Y(this.b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final boolean isAdEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (com.kwad.sdk.core.config.d.J() >= 0) {
                return true;
            }
            return f.a(this.a);
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, adExposureFailedReason) == null) {
            com.kwad.sdk.core.report.a.a(this.a, i, adExposureFailedReason);
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setBidEcpm(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            AdTemplate adTemplate = this.a;
            adTemplate.mBidEcpm = i;
            com.kwad.sdk.core.report.a.l(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setFullScreenVideoAdInteractionListener(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fullScreenVideoAdInteractionListener) == null) {
            this.c = fullScreenVideoAdInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, ksVideoPlayConfig) == null) {
            if (activity == null || ksVideoPlayConfig == null) {
                com.kwad.sdk.core.d.b.e("KsFullScreenVideoAdControl", "showFullScreenVideoAd error, activity or config is null.");
            } else {
                a(activity, ksVideoPlayConfig);
            }
        }
    }
}
