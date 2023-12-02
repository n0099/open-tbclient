package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.n.n;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes10.dex */
public final class e extends b {
    public AdInfo mAdInfo;

    public e(AdInfo adInfo, ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        this.mAdInfo = adInfo;
        if (com.kwad.components.ad.reward.a.b.i(adInfo)) {
            final com.kwad.components.ad.reward.b.c cVar = new com.kwad.components.ad.reward.b.c();
            a(cVar);
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.obfuscated_res_0x7f09145a);
            if (viewStub != null) {
                viewGroup3 = (ViewGroup) viewStub.inflate();
            } else {
                viewGroup3 = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f09146d);
            }
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.e(viewGroup3, new n.a() { // from class: com.kwad.components.ad.reward.presenter.e.1
                @Override // com.kwad.components.ad.reward.n.n.a
                public final void hr() {
                    cVar.showDialog();
                }
            }));
        } else if (com.kwad.sdk.core.response.b.a.ca(adInfo) == 1) {
            ViewStub viewStub2 = (ViewStub) viewGroup.findViewById(R.id.obfuscated_res_0x7f091428);
            if (viewStub2 != null) {
                viewGroup2 = (ViewGroup) viewStub2.inflate();
            } else {
                viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f091442);
            }
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.d(viewGroup2));
        }
    }
}
