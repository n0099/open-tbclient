package com.kwad.sdk.draw;

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
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public class b extends AbstractKsDrawAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f73093a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f73094b;

    /* renamed from: c  reason: collision with root package name */
    public a f73095c;

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
        this.f73093a = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.T(c.i(adTemplate)).a(), this.f73093a);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public View getDrawView2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.f73095c == null) {
                a aVar = new a(context);
                this.f73095c = aVar;
                aVar.setAdInteractionListener(new KsDrawAd.AdInteractionListener(this) { // from class: com.kwad.sdk.draw.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f73096a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f73096a = this;
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onAdClicked() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f73096a.f73094b == null) {
                            return;
                        }
                        this.f73096a.f73094b.onAdClicked();
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onAdShow() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f73096a.f73094b == null) {
                            return;
                        }
                        this.f73096a.f73094b.onAdShow();
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onVideoPlayEnd() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f73096a.f73094b == null) {
                            return;
                        }
                        try {
                            this.f73096a.f73094b.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onVideoPlayError() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.f73096a.f73094b == null) {
                            return;
                        }
                        try {
                            this.f73096a.f73094b.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onVideoPlayPause() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.f73096a.f73094b == null) {
                            return;
                        }
                        try {
                            this.f73096a.f73094b.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onVideoPlayResume() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.f73096a.f73094b == null) {
                            return;
                        }
                        try {
                            this.f73096a.f73094b.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onVideoPlayStart() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048582, this) == null) || this.f73096a.f73094b == null) {
                            return;
                        }
                        try {
                            this.f73096a.f73094b.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                });
                this.f73095c.a(this.f73093a);
            } else {
                com.kwad.sdk.core.d.a.c("KSDrawAdControl", "mDrawVideoView is not null");
            }
            return this.f73095c;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.b.a.x(c.i(this.f73093a)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.b.a.w(c.i(this.f73093a)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.b.a.H(c.i(this.f73093a)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adInteractionListener) == null) {
            this.f73094b = adInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            AdTemplate adTemplate = this.f73093a;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.a.m(adTemplate);
        }
    }
}
