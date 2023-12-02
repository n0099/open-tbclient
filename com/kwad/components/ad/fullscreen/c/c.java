package com.kwad.components.ad.fullscreen.c;

import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.fullscreen.c.a.e;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements j {
    public View hc;
    public View hd;
    public g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.c.c.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            c.this.i(false);
        }
    };

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    public c() {
        a(new e());
        a(new com.kwad.components.ad.fullscreen.c.b.a());
    }

    private void bX() {
        com.kwad.components.ad.reward.g gVar = this.qn;
        if (!gVar.oZ && !gVar.oY) {
            this.hc.setVisibility(0);
            this.hd.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qn.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eW().a(this);
        this.hc.setVisibility(0);
        this.hd.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        bX();
        if (this.qn.oY && this.hd.getVisibility() == 0) {
            this.hd.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
        i(true);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hc = findViewById(R.id.obfuscated_res_0x7f0913e6);
        this.hd = findViewById(R.id.obfuscated_res_0x7f0913e7);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eW().b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z) {
        com.kwad.components.ad.reward.g gVar = this.qn;
        if ((gVar.oZ || gVar.oY) && !z) {
            this.hc.setVisibility(8);
            this.hd.setVisibility(8);
            return;
        }
        this.hc.setVisibility(8);
        this.hd.setVisibility(0);
    }
}
