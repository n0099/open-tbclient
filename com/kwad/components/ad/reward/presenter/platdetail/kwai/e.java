package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.ag;
/* loaded from: classes9.dex */
public final class e extends com.kwad.components.ad.reward.presenter.a implements f, com.kwad.components.core.webview.b.d.b {
    public com.kwad.components.ad.reward.d.e mPlayEndPageListener = new com.kwad.components.ad.reward.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.e.1
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            e.this.bM();
        }
    };
    public View sl;
    public View sm;
    public ImageView sn;

    public e() {
        a(new com.kwad.components.ad.reward.presenter.platdetail.a());
        a(new com.kwad.components.ad.reward.presenter.a.a());
        a(new com.kwad.components.ad.reward.presenter.c.d());
    }

    private void bL() {
        this.sl.setVisibility(0);
        this.sm.setVisibility(8);
    }

    private void hF() {
        if (!this.nM.mA) {
            this.sm.setVisibility(8);
        }
        this.sl.setVisibility(0);
        Context context = getContext();
        if (k.p(this.nM.mAdTemplate) && ag.cB(context)) {
            this.sn.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void a(PlayableSource playableSource, @Nullable j jVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (k.a(this.nM)) {
            com.kwad.components.core.webview.b.c.a.pR().a(this);
            this.sl.setVisibility(8);
            this.sm.setVisibility(8);
        }
        this.nM.a(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.eV().a(this);
    }

    public final void bM() {
        if (this.nM.mA) {
            this.sl.setVisibility(8);
        } else {
            this.sl.setVisibility(8);
            this.sm.setVisibility(0);
        }
        Context context = getContext();
        if (k.p(this.nM.mAdTemplate) && ag.cB(context)) {
            this.sn.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bO() {
        hF();
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bP() {
        bM();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sl = findViewById(R.id.obfuscated_res_0x7f0912d2);
        this.sm = findViewById(R.id.obfuscated_res_0x7f0912d3);
        this.sn = (ImageView) findViewById(R.id.obfuscated_res_0x7f091228);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        hF();
        this.nM.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.eV().b(this);
        this.sm.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-top-bar".equals(str)) {
            bL();
        }
    }
}
