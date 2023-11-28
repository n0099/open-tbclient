package com.kwad.components.ad.reward.presenter.d;

import com.baidu.tieba.R;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.c;
import com.kwad.components.ad.reward.presenter.s;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    /* loaded from: classes10.dex */
    public static class a extends c {
        @Override // com.kwad.components.ad.reward.presenter.c
        public final int hp() {
            return R.id.obfuscated_res_0x7f091317;
        }

        @Override // com.kwad.components.ad.reward.presenter.c
        public final int hq() {
            return 8;
        }

        public a(AdInfo adInfo) {
            super(adInfo);
        }
    }

    public b(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dP(adTemplate);
        if (z) {
            ir();
        } else {
            is();
        }
    }

    private void ir() {
        if (g.g(this.mAdInfo)) {
            a(new s());
        }
        a(new com.kwad.components.ad.reward.presenter.d.a.b());
        if (com.kwad.sdk.core.response.b.b.cy(this.mAdTemplate)) {
            a(new com.kwad.components.ad.reward.presenter.d.a.c());
        }
        a(new a(this.mAdInfo));
        if (!com.kwad.components.ad.reward.a.b.k(this.mAdInfo) && com.kwad.sdk.core.response.b.a.as(this.mAdInfo)) {
            a(new com.kwad.components.ad.reward.presenter.d.a.a());
        }
    }

    private void is() {
        a(new com.kwad.components.ad.reward.presenter.d.a.b());
        if (com.kwad.sdk.core.response.b.b.cy(this.mAdTemplate)) {
            a(new com.kwad.components.ad.reward.presenter.d.a.c());
        }
    }
}
