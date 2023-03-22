package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.video.g;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.h;
/* loaded from: classes8.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.b.d.b {
    public ImageView eE;
    @NonNull
    public com.kwad.components.ad.reward.j.a eF;
    public AdTemplate mAdTemplate;
    public ImageView si;
    public h.a dv = new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.1
        @Override // com.kwad.sdk.utils.h.a
        public final void bk() {
            if (d.this.eE == null || com.kwad.components.ad.reward.kwai.b.fY()) {
                return;
            }
            d.this.eE.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.eE.setSelected(false);
                    d.this.eF.c(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void bl() {
        }
    };
    public g mVideoPlayStateListener = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.2
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayStart() {
            d.this.bT();
        }
    };

    private void bQ() {
        k kVar = this.nM;
        AdTemplate adTemplate = kVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.eF = kVar.eF;
        this.eE.setVisibility(k.q(adTemplate) ? 8 : 0);
        this.si.setVisibility(k.q(this.mAdTemplate) ? 0 : 8);
        KsVideoPlayConfig ksVideoPlayConfig = this.nM.mVideoPlayConfig;
        if (!this.eF.iJ() && com.kwad.components.core.m.b.at(getContext()).ov()) {
            this.eE.setSelected(false);
        } else if (ksVideoPlayConfig != null) {
            this.eE.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.si.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.eF.a(this.mVideoPlayStateListener);
            this.eF.a(this.dv);
        } else {
            this.eE.setSelected(true);
        }
        this.si.setSelected(true);
        this.eF.a(this.mVideoPlayStateListener);
        this.eF.a(this.dv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT() {
        this.eE.setOnClickListener(this);
        this.si.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (k.a(this.nM)) {
            com.kwad.components.core.webview.b.c.a.pR().a(this);
        } else {
            bQ();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        ImageView imageView = this.eE;
        if (view2 == imageView) {
            this.eF.c(!imageView.isSelected(), true);
            ImageView imageView2 = this.eE;
            imageView2.setSelected(!imageView2.isSelected());
            return;
        }
        ImageView imageView3 = this.si;
        if (view2 == imageView3) {
            this.eF.c(!imageView3.isSelected(), true);
            ImageView imageView4 = this.si;
            imageView4.setSelected(!imageView4.isSelected());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.eE = (ImageView) findViewById(R.id.obfuscated_res_0x7f091396);
        this.si = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912d0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        this.nM.eF.b(this.mVideoPlayStateListener);
        this.nM.eF.b(this.dv);
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
