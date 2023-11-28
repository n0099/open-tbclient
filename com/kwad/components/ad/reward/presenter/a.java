package com.kwad.components.ad.reward.presenter;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;
/* loaded from: classes10.dex */
public final class a extends b {
    public com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.a.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            a.this.qn.pl = j2;
        }
    };
    public DetailVideoView mDetailVideoView;

    public a(com.kwad.components.ad.reward.g gVar) {
        this.qn = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }

    private void l(com.kwad.components.ad.reward.g gVar) {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        com.kwad.components.ad.reward.m.e eVar = gVar.oI;
        if (com.kwad.sdk.core.response.b.a.bd(dP)) {
            com.kwad.components.ad.reward.m.b bVar = new com.kwad.components.ad.reward.m.b(this.mAdTemplate);
            eVar.a(3, bVar);
            gVar.a(bVar);
        } else {
            com.kwad.components.ad.reward.m.d dVar = new com.kwad.components.ad.reward.m.d(gVar, this.mDetailVideoView);
            eVar.a(1, dVar);
            gVar.a(dVar);
        }
        eVar.a(this.gO);
    }

    private boolean hg() {
        return com.kwad.sdk.core.response.b.e.i(this.mAdTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate)));
    }

    private boolean hh() {
        return com.kwad.sdk.core.response.b.e.F(this.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        getContext();
        boolean z = !ai.Kx();
        if ((hg() || hh()) && z) {
            this.mDetailVideoView.setForce(true);
        }
        this.mDetailVideoView.g(true, com.kwad.sdk.core.config.d.Bs());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.ad.reward.m.e eVar = this.qn.oI;
        if (eVar != null) {
            eVar.b(this.gO);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f0913db);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f0914ff);
        l(this.qn);
        if (RewardRenderResult.DEFAULT.equals(this.qn.fI())) {
            com.kwad.components.ad.reward.g.a(getContext(), this.qn, (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091475));
        }
    }
}
