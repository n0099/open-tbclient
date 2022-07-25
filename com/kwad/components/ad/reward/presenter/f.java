package com.kwad.components.ad.reward.presenter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.m.f;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes5.dex */
public final class f extends a implements f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.j.a eF;
    public AdInfo mAdInfo;
    public com.kwad.components.core.m.f pJ;

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
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate);
            this.mAdInfo = bQ;
            com.kwad.components.core.m.f fVar = this.pJ;
            if (fVar == null) {
                this.pJ = new com.kwad.components.core.m.f(com.kwad.sdk.core.response.a.a.ag(bQ));
            } else {
                fVar.aw(com.kwad.sdk.core.response.a.a.ag(bQ));
            }
            com.kwad.components.ad.reward.k kVar = this.nM;
            this.eF = kVar.eF;
            this.pJ.a(kVar.mContext, this);
        }
    }

    @Override // com.kwad.components.core.m.f.a
    public final void gW() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.kwad.components.ad.reward.d.a aVar = this.nM.mAdOpenInteractionListener;
            if (aVar != null) {
                aVar.onRewardVerify();
            }
            this.eF.release();
            this.nM.fr();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onUnbind();
            this.pJ.au(this.nM.mContext);
        }
    }
}
