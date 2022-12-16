package com.kwad.components.ad.reward.presenter.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.o;
import com.kwad.components.ad.reward.presenter.a.kwai.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes8.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public o.b sp;

    /* loaded from: classes8.dex */
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
        public final int gS() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.id.obfuscated_res_0x7f091106 : invokeV.intValue;
        }

        @Override // com.kwad.components.ad.reward.presenter.b
        public final int gT() {
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
        this.sp = new o.b(this, null, null) { // from class: com.kwad.components.ad.reward.presenter.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b sq;

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
                        super((o) objArr3[0], (o.a) objArr3[1]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.sq = this;
            }

            @Override // com.kwad.components.ad.reward.o.b, com.kwad.components.core.webview.b.d.c
            public final void G(boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                    super.G(z2);
                    this.sq.gR();
                }
            }

            @Override // com.kwad.components.ad.reward.o.b, com.kwad.components.ad.reward.o.a
            public final void M(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3) == null) {
                    super.M(i3);
                    this.sq.nM.a(this.sq.getContext(), i3, 1);
                }
            }

            @Override // com.kwad.components.ad.reward.o.b, com.kwad.components.ad.reward.o.a
            public final void fQ() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.fQ();
                    this.sq.nM.a(this.sq.getContext(), 17, 2);
                }
            }
        };
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.bQ(adTemplate);
        if (z) {
            hG();
        } else {
            hH();
        }
    }

    private void hG() {
        Presenter aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            if (!com.kwad.sdk.core.response.a.a.aY(this.mAdInfo)) {
                if (!com.kwad.components.ad.reward.kwai.b.j(this.mAdInfo) && com.kwad.sdk.core.response.a.b.cg(this.mAdInfo)) {
                    aVar = new com.kwad.components.ad.reward.presenter.o();
                } else if (com.kwad.sdk.core.response.a.b.bg(this.mAdTemplate)) {
                    aVar = new com.kwad.components.ad.reward.presenter.a.kwai.a();
                }
                a(aVar);
            }
            c cVar = new c();
            cVar.b(this.sp);
            a(cVar);
            if (com.kwad.sdk.core.response.a.b.bd(this.mAdTemplate)) {
                a(new com.kwad.components.ad.reward.presenter.a.kwai.d());
            }
            a(new a(this.mAdInfo));
            if (com.kwad.components.ad.reward.kwai.b.j(this.mAdInfo) || !com.kwad.sdk.core.response.a.a.Z(this.mAdInfo)) {
                return;
            }
            a(new com.kwad.components.ad.reward.presenter.a.kwai.b());
        }
    }

    private void hH() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            c cVar = new c();
            cVar.b(this.sp);
            a(cVar);
            if (com.kwad.sdk.core.response.a.b.bd(this.mAdTemplate)) {
                a(new com.kwad.components.ad.reward.presenter.a.kwai.d());
            }
            if (d.bX(this.mAdTemplate)) {
                a(new com.kwad.components.ad.reward.presenter.a.kwai.b());
            }
            if (com.kwad.sdk.core.response.a.b.bg(this.mAdTemplate)) {
                a(new com.kwad.components.ad.reward.presenter.a.kwai.a());
            }
        }
    }
}
