package com.kwad.components.ad.reward.presenter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.l.f;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes5.dex */
public final class f extends a implements f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo b;
    public com.kwad.components.ad.reward.h.a c;
    public com.kwad.components.core.l.f d;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdInfo i = com.kwad.sdk.core.response.a.d.i(((a) this).a.g);
            this.b = i;
            com.kwad.components.core.l.f fVar = this.d;
            if (fVar == null) {
                this.d = new com.kwad.components.core.l.f(com.kwad.sdk.core.response.a.a.C(i));
            } else {
                fVar.a(com.kwad.sdk.core.response.a.a.C(i));
            }
            com.kwad.components.ad.reward.l lVar = ((a) this).a;
            this.c = lVar.j;
            this.d.a(lVar.M, this);
        }
    }

    @Override // com.kwad.components.core.l.f.a
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.kwad.components.ad.reward.c.a aVar = ((a) this).a.b;
            if (aVar != null) {
                aVar.e();
            }
            this.c.e();
            ((a) this).a.c();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.k_();
            this.d.a(((a) this).a.M);
        }
    }
}
