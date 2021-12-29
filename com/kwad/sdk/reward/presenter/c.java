package com.kwad.sdk.reward.presenter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.d.g;
import com.kwad.sdk.utils.ag;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f59690b;

    public c(AdInfo adInfo, ViewGroup viewGroup) {
        View inflate;
        this.f59690b = adInfo;
        if (!com.kwad.sdk.core.response.a.a.aH(adInfo)) {
            if (com.kwad.sdk.core.response.a.a.aI(this.f59690b)) {
                final com.kwad.sdk.reward.kwai.c cVar = new com.kwad.sdk.reward.kwai.c();
                a((Presenter) cVar);
                a(new com.kwad.sdk.reward.presenter.platdetail.actionbar.d((ViewGroup) ((ViewStub) viewGroup.findViewById(R.id.ksad_reward_order_card)).inflate(), new g.a() { // from class: com.kwad.sdk.reward.presenter.c.1
                    @Override // com.kwad.sdk.reward.d.g.a
                    public void a() {
                        cVar.e();
                    }
                }));
                return;
            }
            return;
        }
        boolean aA = com.kwad.sdk.core.response.a.a.aA(this.f59690b);
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(aA ? R.id.ksad_reward_followed_card : R.id.ksad_reward_follow_card);
        if (viewStub == null) {
            inflate = viewGroup.findViewById(aA ? R.id.ksad_reward_follow_root : R.id.ksad_reward_followed_root);
        } else {
            inflate = viewStub.inflate();
        }
        a(new com.kwad.sdk.reward.presenter.platdetail.actionbar.c((ViewGroup) inflate));
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        int i2 = 0;
        if (!(com.kwad.sdk.core.response.a.a.az(this.f59690b) || com.kwad.sdk.core.response.a.a.aF(this.f59690b)) || ((com.kwad.sdk.reward.g) this).a.f59455g.mAdScene == null) {
            return;
        }
        if (!ag.a(q(), "com.smile.gifmaker") && ag.a(q(), "com.kuaishou.nebula")) {
            i2 = 3;
        }
        String backUrl = ((com.kwad.sdk.reward.g) this).a.f59455g.mAdScene.getBackUrl();
        String aJ = com.kwad.sdk.core.response.a.a.aJ(this.f59690b);
        if (TextUtils.isEmpty(backUrl)) {
            backUrl = "";
        }
        this.f59690b.adConversionInfo.deeplinkUrl = com.kwad.sdk.ec.a.a.a(aJ, i2, backUrl);
    }
}
