package com.kwad.components.ad.reward.presenter.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.p;
import com.kwad.components.ad.reward.presenter.a.kwai.c;
import com.kwad.components.ad.reward.presenter.o;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo b;
    public AdTemplate c;
    public p.b d;

    /* loaded from: classes5.dex */
    public static class a extends com.kwad.components.ad.reward.presenter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AdInfo adInfo) {
            super(adInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AdInfo) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.kwad.components.ad.reward.presenter.b
        public final int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.id.obfuscated_res_0x7f091004 : invokeV.intValue;
        }

        @Override // com.kwad.components.ad.reward.presenter.b
        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 8;
            }
            return invokeV.intValue;
        }
    }

    public b(AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new p.b(this, null, null) { // from class: com.kwad.components.ad.reward.presenter.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(null, null);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, r9, r10};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr3 = newInitContext2.callArgs;
                        super((p) objArr3[0], (p.a) objArr3[1]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.p.b, com.kwad.components.ad.reward.p.a
            public final void a(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    super.a(i3);
                    ((com.kwad.components.ad.reward.presenter.a) this.a).a.a(this.a.u(), i3, 1);
                }
            }

            @Override // com.kwad.components.ad.reward.p.b, com.kwad.components.ad.reward.e
            public final void a(boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
                    super.a(z2);
                    this.a.j();
                }
            }

            @Override // com.kwad.components.ad.reward.p.b, com.kwad.components.ad.reward.p.a
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.c();
                    ((com.kwad.components.ad.reward.presenter.a) this.a).a.a(this.a.u(), 17, 2);
                }
            }
        };
        this.c = adTemplate;
        this.b = d.i(adTemplate);
        if (z) {
            d();
        } else {
            e();
        }
    }

    private void d() {
        Presenter aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (!com.kwad.sdk.core.response.a.a.ar(this.b)) {
                if (!com.kwad.components.ad.reward.kwai.b.d(this.b) && com.kwad.sdk.core.response.a.b.n(this.b)) {
                    aVar = new o();
                } else if (com.kwad.sdk.core.response.a.b.o(this.c)) {
                    aVar = new com.kwad.components.ad.reward.presenter.a.kwai.a();
                }
                a(aVar);
            }
            c cVar = new c();
            cVar.a(this.d);
            a((Presenter) cVar);
            if (com.kwad.sdk.core.response.a.b.m(this.c)) {
                a(new com.kwad.components.ad.reward.presenter.a.kwai.d());
            }
            a(new a(this.b));
            if (com.kwad.components.ad.reward.kwai.b.d(this.b) || !com.kwad.sdk.core.response.a.a.w(this.b)) {
                return;
            }
            a(new com.kwad.components.ad.reward.presenter.a.kwai.b());
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            c cVar = new c();
            cVar.a(this.d);
            a((Presenter) cVar);
            if (com.kwad.sdk.core.response.a.b.m(this.c)) {
                a(new com.kwad.components.ad.reward.presenter.a.kwai.d());
            }
            if (d.p(this.c)) {
                a(new com.kwad.components.ad.reward.presenter.a.kwai.b());
            }
            if (com.kwad.sdk.core.response.a.b.o(this.c)) {
                a(new com.kwad.components.ad.reward.presenter.a.kwai.a());
            }
        }
    }
}
