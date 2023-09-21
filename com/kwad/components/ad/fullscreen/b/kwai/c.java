package com.kwad.components.ad.fullscreen.b.kwai;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.video.g;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.h;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.b.d.b {
    public ImageView eE;
    @NonNull
    public com.kwad.components.ad.reward.j.a eF;
    public h.a dv = new h.a() { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.1
        @Override // com.kwad.sdk.utils.h.a
        public final void bk() {
            if (c.this.eE == null || com.kwad.components.ad.reward.kwai.b.fY()) {
                return;
            }
            c.this.eE.post(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.eE.setSelected(false);
                    c.this.eF.c(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void bl() {
        }
    };
    public g mVideoPlayStateListener = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.2
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayStart() {
            c.this.bT();
        }
    };

    private void bQ() {
        ImageView imageView;
        this.eF = this.nM.eF;
        boolean z = false;
        this.eE.setVisibility(0);
        KsVideoPlayConfig ksVideoPlayConfig = this.nM.mVideoPlayConfig;
        if (!this.eF.iJ() && com.kwad.components.core.m.b.at(getContext()).ov()) {
            imageView = this.eE;
        } else if (ksVideoPlayConfig != null) {
            this.eE.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.eF.a(this.mVideoPlayStateListener);
            this.eF.a(this.dv);
        } else {
            imageView = this.eE;
            z = true;
        }
        imageView.setSelected(z);
        this.eF.a(this.mVideoPlayStateListener);
        this.eF.a(this.dv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT() {
        this.eE.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (k.b(this.nM)) {
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
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.eE = (ImageView) findViewById(R.id.obfuscated_res_0x7f091443);
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
