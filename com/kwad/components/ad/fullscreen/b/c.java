package com.kwad.components.ad.fullscreen.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.playable.PlayableSource;
/* loaded from: classes9.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements f, com.kwad.components.core.webview.b.d.b {
    public View ev;
    public View ew;
    public e mPlayEndPageListener = new e() { // from class: com.kwad.components.ad.fullscreen.b.c.1
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            c.this.bM();
        }
    };

    public c() {
        a(new com.kwad.components.ad.fullscreen.b.kwai.e());
        a(new com.kwad.components.ad.fullscreen.b.a.a());
        a(new com.kwad.components.ad.fullscreen.b.b.a());
    }

    private void bL() {
        this.ev.setVisibility(0);
        this.ew.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM() {
        View view2;
        int i = 8;
        if (this.nM.mA) {
            this.ev.setVisibility(8);
            view2 = this.ew;
        } else {
            this.ev.setVisibility(8);
            view2 = this.ew;
            i = 0;
        }
        view2.setVisibility(i);
    }

    private void bN() {
        if (this.nM.mA) {
            return;
        }
        this.ev.setVisibility(0);
        this.ew.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void a(PlayableSource playableSource, @Nullable j jVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (k.b(this.nM)) {
            com.kwad.components.core.webview.b.c.a.pR().a(this);
            this.ev.setVisibility(8);
            this.ew.setVisibility(8);
        }
        this.nM.a(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.eV().a(this);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bO() {
        bN();
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bP() {
        bM();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ev = findViewById(R.id.obfuscated_res_0x7f091313);
        this.ew = findViewById(R.id.obfuscated_res_0x7f091314);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        this.nM.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.eV().b(this);
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-top-bar".equals(str)) {
            bL();
        }
    }
}
