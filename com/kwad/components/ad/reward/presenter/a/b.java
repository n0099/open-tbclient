package com.kwad.components.ad.reward.presenter.a;

import com.baidu.tieba.R;
import com.kwad.components.ad.reward.o;
import com.kwad.components.ad.reward.presenter.a.kwai.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes8.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a {
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public o.b sp = new o.b(null, null) { // from class: com.kwad.components.ad.reward.presenter.a.b.1
        {
            super(null, null);
        }

        @Override // com.kwad.components.ad.reward.o.b, com.kwad.components.core.webview.b.d.c
        public final void G(boolean z) {
            super.G(z);
            b.this.gR();
        }

        @Override // com.kwad.components.ad.reward.o.b, com.kwad.components.ad.reward.o.a
        public final void M(int i) {
            super.M(i);
            b.this.nM.a(b.this.getContext(), i, 1);
        }

        @Override // com.kwad.components.ad.reward.o.b, com.kwad.components.ad.reward.o.a
        public final void fQ() {
            super.fQ();
            b.this.nM.a(b.this.getContext(), 17, 2);
        }
    };

    /* loaded from: classes8.dex */
    public static class a extends com.kwad.components.ad.reward.presenter.b {
        public a(AdInfo adInfo) {
            super(adInfo);
        }

        @Override // com.kwad.components.ad.reward.presenter.b
        public final int gS() {
            return R.id.obfuscated_res_0x7f0911ed;
        }

        @Override // com.kwad.components.ad.reward.presenter.b
        public final int gT() {
            return 8;
        }
    }

    public b(AdTemplate adTemplate, boolean z) {
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

    private void hH() {
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
