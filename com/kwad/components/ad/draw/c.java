package com.kwad.components.ad.draw;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class c extends AbstractKsDrawAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public AdTemplate a;
    @Nullable
    public KsDrawAd.AdInteractionListener b;
    public b c;

    public c(@NonNull AdTemplate adTemplate) {
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
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.ae(com.kwad.sdk.core.response.a.d.i(adTemplate)).a(), this.a);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public final View getDrawView2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.c == null) {
                b bVar = new b(context);
                this.c = bVar;
                bVar.setAdInteractionListener(new KsDrawAd.AdInteractionListener(this) { // from class: com.kwad.components.ad.draw.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onAdClicked() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.b == null) {
                            return;
                        }
                        this.a.b.onAdClicked();
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onAdShow() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.b == null) {
                            return;
                        }
                        this.a.b.onAdShow();
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onVideoPlayEnd() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.b == null) {
                            return;
                        }
                        try {
                            this.a.b.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.b(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onVideoPlayError() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.a.b == null) {
                            return;
                        }
                        try {
                            this.a.b.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.b(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onVideoPlayPause() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.a.b == null) {
                            return;
                        }
                        try {
                            this.a.b.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.b(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onVideoPlayResume() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.a.b == null) {
                            return;
                        }
                        try {
                            this.a.b.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.b(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onVideoPlayStart() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048582, this) == null) || this.a.b == null) {
                            return;
                        }
                        try {
                            this.a.b.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.b(th);
                        }
                    }
                });
                this.c.a(this.a);
            } else {
                com.kwad.sdk.core.d.b.c("KSDrawAdControl", "mDrawVideoView is not null");
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.a.a.M(com.kwad.sdk.core.response.a.d.i(this.a)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.a.a.L(com.kwad.sdk.core.response.a.d.i(this.a)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.a.a.Y(com.kwad.sdk.core.response.a.d.i(this.a)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, adExposureFailedReason) == null) {
            com.kwad.sdk.core.report.a.a(this.a, i, adExposureFailedReason);
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adInteractionListener) == null) {
            this.b = adInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            AdTemplate adTemplate = this.a;
            adTemplate.mBidEcpm = i;
            com.kwad.sdk.core.report.a.l(adTemplate);
        }
    }
}
