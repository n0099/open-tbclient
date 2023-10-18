package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k.m;
import com.kwad.components.core.webview.b.b.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class d extends a {
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public boolean pA;

    public d(AdTemplate adTemplate, AdInfo adInfo, ViewGroup viewGroup) {
        boolean z = false;
        this.pA = false;
        this.mAdInfo = adInfo;
        this.mAdTemplate = adTemplate;
        this.pA = (com.kwad.components.ad.reward.kwai.b.i(adInfo) || com.kwad.sdk.core.response.a.a.bD(adInfo)) ? true : true;
        if (com.kwad.components.ad.reward.kwai.b.h(this.mAdInfo)) {
            final com.kwad.components.ad.reward.a.c cVar = new com.kwad.components.ad.reward.a.c();
            a(cVar);
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913ca);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.e((ViewGroup) (viewStub != null ? viewStub.inflate() : viewGroup.findViewById(R.id.obfuscated_res_0x7f0913dd)), new m.a() { // from class: com.kwad.components.ad.reward.presenter.d.1
                @Override // com.kwad.components.ad.reward.k.m.a
                public final void gV() {
                    cVar.showDialog();
                }
            }));
        } else if (com.kwad.sdk.core.response.a.a.bF(adInfo)) {
            ViewStub viewStub2 = (ViewStub) viewGroup.findViewById(R.id.obfuscated_res_0x7f091398);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.d((ViewGroup) (viewStub2 != null ? viewStub2.inflate() : viewGroup.findViewById(R.id.obfuscated_res_0x7f0913b2))));
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
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

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
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
