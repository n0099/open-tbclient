package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k.m;
import com.kwad.components.core.webview.b.b.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public final class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public boolean pA;

    public d(AdTemplate adTemplate, AdInfo adInfo, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, adInfo, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        boolean z = false;
        this.pA = false;
        this.mAdInfo = adInfo;
        this.mAdTemplate = adTemplate;
        this.pA = (com.kwad.components.ad.reward.kwai.b.i(adInfo) || com.kwad.sdk.core.response.a.a.bD(adInfo)) ? true : true;
        if (com.kwad.components.ad.reward.kwai.b.h(this.mAdInfo)) {
            com.kwad.components.ad.reward.a.c cVar = new com.kwad.components.ad.reward.a.c();
            a(cVar);
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.obfuscated_res_0x7f09119d);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.e((ViewGroup) (viewStub != null ? viewStub.inflate() : viewGroup.findViewById(R.id.obfuscated_res_0x7f0911b0)), new m.a(this, cVar) { // from class: com.kwad.components.ad.reward.presenter.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.ad.reward.a.c pB;
                public final /* synthetic */ d pC;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.pC = this;
                    this.pB = cVar;
                }

                @Override // com.kwad.components.ad.reward.k.m.a
                public final void gV() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.pB.showDialog();
                    }
                }
            }));
        } else if (com.kwad.sdk.core.response.a.a.bF(adInfo)) {
            ViewStub viewStub2 = (ViewStub) viewGroup.findViewById(R.id.obfuscated_res_0x7f09116b);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.d((ViewGroup) (viewStub2 != null ? viewStub2.inflate() : viewGroup.findViewById(R.id.obfuscated_res_0x7f091185))));
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            if ((com.kwad.sdk.core.response.a.a.bD(this.mAdInfo) || com.kwad.sdk.core.response.a.a.bJ(this.mAdInfo)) && this.nM.mAdTemplate.mAdScene != null) {
                this.mAdInfo.adConversionInfo.deeplinkUrl = com.kwad.components.core.c.a.d.e(getContext(), this.mAdInfo, this.nM.mAdTemplate.mAdScene);
            }
            if (this.pA) {
                if (this.nM.fE() == null) {
                    d.b bVar = new d.b();
                    bVar.setAdTemplate(this.mAdTemplate);
                    bVar.aI("ksad-video-confirm-card");
                    bVar.aE(false);
                    bVar.aF(true);
                    this.nM.a(com.kwad.components.ad.reward.h.kwai.b.a(bVar));
                }
                if (this.nM.fF() == null) {
                    d.b bVar2 = new d.b();
                    bVar2.setAdTemplate(this.mAdTemplate);
                    bVar2.aI("ksad-video-playend-dialog-card");
                    bVar2.aE(true);
                    bVar2.aF(true);
                    this.nM.b(com.kwad.components.ad.reward.h.kwai.b.a(bVar2));
                }
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onUnbind();
            if (this.nM.fE() != null) {
                try {
                    this.nM.fE().dismiss();
                    this.nM.a((com.kwad.components.ad.reward.h.kwai.b) null);
                } catch (Exception unused) {
                }
            }
            if (this.nM.fF() != null) {
                try {
                    this.nM.fF().dismiss();
                    this.nM.b((com.kwad.components.ad.reward.h.kwai.b) null);
                } catch (Exception unused2) {
                }
            }
        }
    }
}
