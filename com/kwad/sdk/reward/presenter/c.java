package com.kwad.sdk.reward.presenter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.d.g;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f40952b;

    public c(AdInfo adInfo, ViewGroup viewGroup) {
        View inflate;
        this.f40952b = adInfo;
        if (!com.kwad.sdk.core.response.a.a.aH(adInfo)) {
            if (com.kwad.sdk.core.response.a.a.aI(this.f40952b)) {
                final com.kwad.sdk.reward.kwai.c cVar = new com.kwad.sdk.reward.kwai.c();
                a((Presenter) cVar);
                a(new com.kwad.sdk.reward.presenter.platdetail.actionbar.d((ViewGroup) ((ViewStub) viewGroup.findViewById(R.id.obfuscated_res_0x7f09110f)).inflate(), new g.a() { // from class: com.kwad.sdk.reward.presenter.c.1
                    @Override // com.kwad.sdk.reward.d.g.a
                    public void a() {
                        cVar.e();
                    }
                }));
                return;
            }
            return;
        }
        boolean aA = com.kwad.sdk.core.response.a.a.aA(this.f40952b);
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(aA ? R.id.obfuscated_res_0x7f091104 : R.id.obfuscated_res_0x7f0910f1);
        if (viewStub == null) {
            inflate = viewGroup.findViewById(aA ? R.id.obfuscated_res_0x7f091102 : R.id.obfuscated_res_0x7f091107);
        } else {
            inflate = viewStub.inflate();
        }
        a(new com.kwad.sdk.reward.presenter.platdetail.actionbar.c((ViewGroup) inflate));
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        int i = 0;
        if (!(com.kwad.sdk.core.response.a.a.az(this.f40952b) || com.kwad.sdk.core.response.a.a.aF(this.f40952b)) || ((com.kwad.sdk.reward.g) this).a.f40747g.mAdScene == null) {
            return;
        }
        if (!ag.a(q(), "com.smile.gifmaker") && ag.a(q(), "com.kuaishou.nebula")) {
            i = 3;
        }
        String backUrl = ((com.kwad.sdk.reward.g) this).a.f40747g.mAdScene.getBackUrl();
        String aJ = com.kwad.sdk.core.response.a.a.aJ(this.f40952b);
        if (TextUtils.isEmpty(backUrl)) {
            backUrl = "";
        }
        this.f40952b.adConversionInfo.deeplinkUrl = com.kwad.sdk.ec.a.a.a(aJ, i, backUrl);
    }
}
