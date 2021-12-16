package com.kwad.sdk.reward.presenter.platdetail;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.presenter.platdetail.kwai.d;
import com.kwad.sdk.reward.presenter.platdetail.kwai.e;
/* loaded from: classes3.dex */
public class c extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c(boolean z) {
        Presenter bVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z) {
            bVar = new e();
        } else {
            a((Presenter) new com.kwad.sdk.reward.presenter.platdetail.kwai.a());
            bVar = new com.kwad.sdk.reward.presenter.platdetail.kwai.b();
        }
        a(bVar);
        a((Presenter) new d());
        a((Presenter) new com.kwad.sdk.reward.presenter.platdetail.kwai.c());
    }
}
