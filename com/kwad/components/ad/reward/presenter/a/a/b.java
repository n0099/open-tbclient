package com.kwad.components.ad.reward.presenter.a.a;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bd;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c, com.kwad.components.core.webview.b.d.b {
    public View sK;
    public final Runnable sL = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.a.a.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                return;
            }
            b.this.hS();
            b.this.sK.setAlpha(0.0f);
            b.this.sK.animate().alpha(1.0f).setDuration(500L).start();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hS() {
        this.sK.setVisibility(0);
        this.sK.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (k.a(this.nM)) {
            com.kwad.components.core.webview.b.c.a.pR().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a.a.c
    public final void hR() {
        k kVar = this.nM;
        if (kVar.mF) {
            return;
        }
        long j = kVar.mO;
        if (j == 0) {
            this.sL.run();
        } else {
            bd.runOnUiThreadDelay(this.sL, j);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.sK) {
            PlayableSource fz = this.nM.fz();
            if (fz != null && (fz.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || fz.equals(PlayableSource.PENDANT_CLICK_AUTO) || fz.equals(PlayableSource.PENDANT_AUTO) || fz.equals(PlayableSource.ACTIONBAR_CLICK))) {
                com.kwad.components.ad.reward.b.eV().eW();
                return;
            }
            k kVar = this.nM;
            e.b(kVar, kVar.fC());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sK = findViewById(R.id.obfuscated_res_0x7f0912da);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.sK.setVisibility(8);
        bd.c(this.sL);
        com.kwad.components.core.webview.b.c.a.pR().b(this);
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        "ksad-video-top-bar".equals(str);
    }
}
