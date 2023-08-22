package com.kwad.components.ad.reward.presenter.c;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.b.f;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.sdk.components.h;
import com.kwad.sdk.utils.az;
/* loaded from: classes10.dex */
public final class c extends a implements RewardActionBarControl.d {
    public FrameLayout hP;
    public int ts = 0;
    public e mPlayEndPageListener = new e() { // from class: com.kwad.components.ad.reward.presenter.c.c.1
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            c.this.hide();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        this.hP.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.components.core.webview.b.e
    public final void a(h hVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(hVar, bVar);
        hVar.c(new f(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.presenter.c.c.2
            @Override // com.kwad.components.ad.reward.b.d
            public final void a(com.kwad.components.ad.reward.b.b bVar2) {
                com.kwad.sdk.core.e.b.d("TkRewardActionBarPresenter", "onUpdateExtraReward : " + bVar2.gs());
                c.this.a(bVar2);
            }
        }));
        hVar.c(new com.kwad.components.core.webview.jshandler.a(new com.kwad.components.core.webview.jshandler.b() { // from class: com.kwad.components.ad.reward.presenter.c.c.3
            @Override // com.kwad.components.core.webview.jshandler.b
            public final void a(com.kwad.components.core.webview.jshandler.a aVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    aVar.a(com.kwad.components.ad.reward.b.a.gp().gq());
                    com.kwad.components.ad.reward.b.a.gp().a(aVar);
                }
            }
        }));
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (cc()) {
            this.ts = this.hP.getVisibility();
            getRootView().findViewById(R.id.obfuscated_res_0x7f091449).setVisibility(8);
            this.nM.a(this.mPlayEndPageListener);
            this.nM.ml.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(k.a aVar) {
        float aI = com.kwad.sdk.b.kwai.a.aI(getContext());
        aVar.width = (int) ((az.getScreenWidth(getContext()) / aI) + 0.5f);
        aVar.height = (int) ((az.getScreenHeight(getContext()) / aI) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final String bZ() {
        return "ksad-video-bottom-card-v2";
    }

    @Override // com.kwad.components.core.webview.b.e
    public final FrameLayout ca() {
        return this.hP;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void cb() {
        this.hP.setVisibility(8);
        com.kwad.components.core.webview.b.c.a.pR().aK(bZ());
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a
    public final boolean cc() {
        return com.kwad.components.ad.reward.k.c(this.nM);
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
    public final void f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.hP.setVisibility(0);
        RewardActionBarControl.a(aVar, this.hP, RewardActionBarControl.ShowActionBarResult.TK);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hP = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091301);
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (cc()) {
            this.nM.b(this.mPlayEndPageListener);
            this.hP.setVisibility(this.ts);
            this.nM.ml.a((RewardActionBarControl.d) null);
        }
    }
}
