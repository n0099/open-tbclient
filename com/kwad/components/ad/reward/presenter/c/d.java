package com.kwad.components.ad.reward.presenter.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes10.dex */
public final class d extends a implements f {
    public FrameLayout fl;
    public e mPlayEndPageListener = new e() { // from class: com.kwad.components.ad.reward.presenter.c.d.1
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            if (com.kwad.sdk.core.response.a.a.Z(com.kwad.sdk.core.response.a.d.bQ(d.this.nM.mAdTemplate))) {
                d.this.fl.setVisibility(8);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.d.f
    public final void a(PlayableSource playableSource, @Nullable j jVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (cc()) {
            this.nM.a(this.mPlayEndPageListener);
            com.kwad.components.ad.reward.b.eV().a(this);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(k.a aVar) {
        aVar.width = (int) ((com.kwad.sdk.b.kwai.a.getScreenWidth(getContext()) / com.kwad.sdk.b.kwai.a.aI(getContext())) + 0.5f);
        aVar.height = 44;
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bO() {
        if (this.nM.mA) {
            this.fl.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bP() {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate);
        if (!this.nM.mA || com.kwad.sdk.core.response.a.a.Z(bQ)) {
            return;
        }
        this.fl.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final String bZ() {
        return "ksad-video-top-bar";
    }

    @Override // com.kwad.components.core.webview.b.e
    public final FrameLayout ca() {
        return this.fl;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void cb() {
        com.kwad.components.ad.reward.k kVar = this.nM;
        kVar.mA = false;
        kVar.D(false);
        this.fl.setVisibility(8);
        com.kwad.components.core.webview.b.c.a.pR().aK(bZ());
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a
    public final boolean cc() {
        return com.kwad.components.ad.reward.k.a(this.nM);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091304);
        this.fl = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (cc()) {
            this.nM.b(this.mPlayEndPageListener);
            com.kwad.components.ad.reward.b.eV().b(this);
        }
    }
}
