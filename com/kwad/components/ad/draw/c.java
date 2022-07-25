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
public final class c extends AbstractKsDrawAd implements com.kwad.components.core.internal.api.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public KsDrawAd.AdInteractionListener aJ;
    public b aT;
    @NonNull
    public AdTemplate mAdTemplate;

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
        this.mAdTemplate = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.bQ(adTemplate)).getUrl(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAdTemplate : (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public final View getDrawView2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (this.aT == null) {
                b bVar = new b(context);
                this.aT = bVar;
                bVar.setAdInteractionListener(new KsDrawAd.AdInteractionListener(this) { // from class: com.kwad.components.ad.draw.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c aU;

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
                        this.aU = this;
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onAdClicked() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.aU.aJ == null) {
                            return;
                        }
                        this.aU.aJ.onAdClicked();
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onAdShow() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.aU.aJ == null) {
                            return;
                        }
                        this.aU.aJ.onAdShow();
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onVideoPlayEnd() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.aU.aJ == null) {
                            return;
                        }
                        try {
                            this.aU.aJ.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onVideoPlayError() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.aU.aJ == null) {
                            return;
                        }
                        try {
                            this.aU.aJ.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onVideoPlayPause() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.aU.aJ == null) {
                            return;
                        }
                        try {
                            this.aU.aJ.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onVideoPlayResume() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.aU.aJ == null) {
                            return;
                        }
                        try {
                            this.aU.aJ.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public final void onVideoPlayStart() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048582, this) == null) || this.aU.aJ == null) {
                            return;
                        }
                        try {
                            this.aU.aJ.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }
                });
                this.aT.b(this.mAdTemplate);
            } else {
                com.kwad.sdk.core.e.b.i("KSDrawAdControl", "mDrawVideoView is not null");
            }
            return this.aT;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.a.a.ap(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.a.a.aD(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, adExposureFailedReason) == null) {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adInteractionListener) == null) {
            this.aJ = adInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            adTemplate.mBidEcpm = i;
            com.kwad.sdk.core.report.a.aA(adTemplate);
        }
    }
}
