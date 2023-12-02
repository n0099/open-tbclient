package com.kwad.components.ad.fullscreen.c.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.f.a {
    public FrameLayout hR;
    public j hS = new j() { // from class: com.kwad.components.ad.fullscreen.c.c.b.1
        @Override // com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, @Nullable n nVar) {
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void bY() {
            b.this.hR.setVisibility(0);
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void bZ() {
            b.this.hR.setVisibility(4);
        }
    };

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_fullscreen";
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qn.oY = true;
        com.kwad.components.ad.reward.a.eW().a(this.hS);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.hR;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.m183do(this.qn.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hR = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09139c);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.a.eW().b(this.hS);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.sdk.core.e.c.d("jky", "fullscreen onTkLoadFailed: " + tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        this.hR.setVisibility(8);
        this.qn.oY = false;
    }
}
