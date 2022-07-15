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
    public c a;
    public AdInfo b;

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
        this.b = adInfo;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.a = (c) t();
            if (!(com.kwad.sdk.core.response.a.a.aT(this.b) || com.kwad.sdk.core.response.a.a.ba(this.b)) || this.a.a.mAdScene == null) {
                return;
            }
            this.b.adConversionInfo.deeplinkUrl = com.kwad.components.core.c.a.c.a(u(), this.b, this.a.a.mAdScene);
        }
    }
}
