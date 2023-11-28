package com.kwad.components.ad.fullscreen.c.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.h;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    public ImageView hp;
    public h.a hq = new h.a() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (c.this.hp != null && !com.kwad.components.ad.reward.a.b.gq()) {
                c.this.hp.post(new Runnable() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.hp.setSelected(false);
                        c.this.qn.oI.setAudioEnabled(false, false);
                    }
                });
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091502);
        this.hp = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.oI.b(this.hq);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        ImageView imageView = this.hp;
        if (view2 == imageView) {
            this.qn.oI.setAudioEnabled(!imageView.isSelected(), true);
            ImageView imageView2 = this.hp;
            imageView2.setSelected(!imageView2.isSelected());
        }
    }

    private void ca() {
        this.hp.setVisibility(0);
        g gVar = this.qn;
        KsVideoPlayConfig ksVideoPlayConfig = gVar.mVideoPlayConfig;
        if (!gVar.oG && com.kwad.components.core.s.a.ah(getContext()).qJ()) {
            this.hp.setSelected(false);
            this.qn.d(false, false);
        } else if (ksVideoPlayConfig != null) {
            this.hp.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.qn.d(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.hp.setSelected(true);
            this.qn.d(true, true);
        }
        this.qn.oI.a(this.hq);
    }
}
