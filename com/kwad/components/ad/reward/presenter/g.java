package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.i.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;
/* loaded from: classes10.dex */
public final class g extends b implements a.InterfaceC0649a {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        boolean Cw = com.kwad.sdk.core.d.a.Cw();
        com.kwad.sdk.core.e.c.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + Cw);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl != null && Cw) {
            com.kwad.components.core.i.a.a(sceneImpl, this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0649a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        if (list != null && list.size() != 0) {
            com.kwad.sdk.core.e.c.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
            AdTemplate adTemplate = list.get(0).getAdTemplate();
            boolean ct = com.kwad.sdk.core.response.b.b.ct(adTemplate);
            List<a.InterfaceC0649a> fH = this.qn.fH();
            if (ct) {
                com.kwad.sdk.core.d.a.f(com.kwad.sdk.core.response.b.b.cq(adTemplate), com.kwad.sdk.core.response.b.b.cr(adTemplate));
                if (fH != null) {
                    for (a.InterfaceC0649a interfaceC0649a : fH) {
                        interfaceC0649a.e(list);
                    }
                }
            }
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0649a
    public final void onError(int i, String str) {
        List<a.InterfaceC0649a> fH = this.qn.fH();
        if (fH != null) {
            for (a.InterfaceC0649a interfaceC0649a : fH) {
                interfaceC0649a.onError(i, str);
            }
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0649a
    public final void onRequestResult(int i) {
        List<a.InterfaceC0649a> fH = this.qn.fH();
        if (fH != null) {
            for (a.InterfaceC0649a interfaceC0649a : fH) {
                interfaceC0649a.onRequestResult(i);
            }
        }
    }
}
