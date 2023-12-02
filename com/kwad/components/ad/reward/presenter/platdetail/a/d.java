package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.h;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    public ImageView hp;
    public ImageView vq;
    public h.a hq = new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (d.this.hp != null && !com.kwad.components.ad.reward.a.b.gq()) {
                d.this.hp.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.hp.setSelected(false);
                        d.this.qn.oI.setAudioEnabled(false, false);
                    }
                });
            }
        }
    };
    public com.kwad.components.ad.reward.m.c vr = new com.kwad.components.ad.reward.m.c() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.2
        @Override // com.kwad.components.ad.reward.m.c
        public final void io() {
            d.this.im();
        }
    };

    private void in() {
        this.hp.setOnClickListener(this);
        this.vq.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qn.a(this.vr);
        this.qn.oI.a(this.hq);
        ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hp = (ImageView) findViewById(R.id.obfuscated_res_0x7f091503);
        this.vq = (ImageView) findViewById(R.id.obfuscated_res_0x7f091426);
        in();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.oI.b(this.hq);
        this.qn.b(this.vr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (com.kwad.components.ad.reward.g.G(r4.mAdTemplate) != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void ca() {
        int i;
        ImageView imageView;
        int i2 = 0;
        if (ho()) {
            this.hp.setVisibility(8);
            imageView = this.vq;
        } else {
            ImageView imageView2 = this.hp;
            if (g.G(this.mAdTemplate)) {
                i = 8;
            } else {
                i = 0;
            }
            imageView2.setVisibility(i);
            imageView = this.vq;
        }
        i2 = 8;
        imageView.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im() {
        g gVar = this.qn;
        KsVideoPlayConfig ksVideoPlayConfig = gVar.mVideoPlayConfig;
        boolean z = true;
        if (!gVar.oG && com.kwad.components.core.s.a.ah(getContext()).qJ()) {
            this.vq.setSelected(true);
            this.qn.d(false, false);
            z = false;
        } else if (ksVideoPlayConfig != null) {
            z = ksVideoPlayConfig.isVideoSoundEnable();
            this.vq.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.qn.d(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.vq.setSelected(true);
            this.qn.d(true, true);
        }
        this.hp.setSelected(z);
        this.qn.oI.setAudioEnabled(z, false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        ImageView imageView = this.hp;
        if (view2 == imageView) {
            this.qn.oI.setAudioEnabled(!imageView.isSelected(), true);
            ImageView imageView2 = this.hp;
            imageView2.setSelected(!imageView2.isSelected());
            return;
        }
        ImageView imageView3 = this.vq;
        if (view2 == imageView3) {
            this.qn.oI.setAudioEnabled(!imageView3.isSelected(), true);
            ImageView imageView4 = this.vq;
            imageView4.setSelected(!imageView4.isSelected());
        }
    }
}
