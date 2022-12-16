package com.kwad.components.ad.reward.presenter.platdetail;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.presenter.platdetail.kwai.c;
import com.kwad.components.ad.reward.presenter.platdetail.kwai.d;
/* loaded from: classes8.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(new com.kwad.components.ad.reward.presenter.platdetail.kwai.a());
        a(new com.kwad.components.ad.reward.presenter.platdetail.kwai.b());
        a(new d());
        a(new c());
    }
}
