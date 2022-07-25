package com.kwad.components.ad.interstitial.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes5.dex */
public final class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c gh;
    public AdInfo mAdInfo;

    public e(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdInfo = adInfo;
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            this.gh = (c) xR();
            if (!(com.kwad.sdk.core.response.a.a.bD(this.mAdInfo) || com.kwad.sdk.core.response.a.a.bJ(this.mAdInfo)) || this.gh.mAdTemplate.mAdScene == null) {
                return;
            }
            this.mAdInfo.adConversionInfo.deeplinkUrl = com.kwad.components.core.c.a.d.e(getContext(), this.mAdInfo, this.gh.mAdTemplate.mAdScene);
        }
    }
}
