package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.h;
/* loaded from: classes10.dex */
public final class n extends e implements com.kwad.sdk.core.h.b {
    public ImageView eE;
    public AdInfo mAdInfo;
    public SkipView zw;
    public volatile boolean zu = false;
    public boolean zv = false;
    public boolean yG = false;
    public boolean yJ = false;
    public h.a dv = new h.a() { // from class: com.kwad.components.ad.splashscreen.b.n.1
        @Override // com.kwad.sdk.utils.h.a
        public final void bk() {
            n.this.zu = false;
            if (n.this.eE != null) {
                n.this.eE.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.n.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        n nVar = n.this;
                        com.kwad.components.ad.splashscreen.c.a aVar = nVar.yF.yc;
                        if (aVar != null) {
                            aVar.c(nVar.zu, false);
                        }
                        com.kwad.components.ad.splashscreen.h hVar = n.this.yF;
                        if (hVar != null) {
                            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(hVar.mAdTemplate);
                            boolean z = n.this.zu;
                            AdInfo.AdSplashInfo adSplashInfo = bQ.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                n.this.eE.setImageDrawable(n.this.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e9f));
                            } else {
                                KSImageLoader.loadImage(n.this.eE, str, n.this.yF.mAdTemplate);
                            }
                            n.this.eE.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void bl() {
        }
    };
    public com.kwad.components.core.video.g zx = new com.kwad.components.core.video.g() { // from class: com.kwad.components.ad.splashscreen.b.n.2
        public boolean zA = false;
        public int zB = com.kwad.components.ad.splashscreen.a.b.jP();
        public String zC = com.kwad.components.ad.splashscreen.a.b.jL();
        public String zD = com.kwad.components.ad.splashscreen.a.b.jQ();

        @Override // com.kwad.components.core.video.g
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.g
        public final void onVideoPlayBufferingPlaying() {
        }

        @Override // com.kwad.components.core.video.g
        public final void onVideoPlayCompleted() {
            if (this.zA) {
                return;
            }
            n.this.yF.jF();
            this.zA = true;
        }

        @Override // com.kwad.components.core.video.g
        public final void onVideoPlayError(int i, int i2) {
            if (n.this.yJ) {
                return;
            }
            com.kwad.components.splash.monitor.a.qG();
            com.kwad.components.splash.monitor.a.d(n.this.yF.mAdTemplate, i, String.valueOf(i2));
            n.this.yF.e(0, "onVideoPlayError");
        }

        @Override // com.kwad.components.core.video.g
        public final void onVideoPlayPaused() {
        }

        @Override // com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, final long j2) {
            String str;
            int i = this.zB;
            final boolean jX = n.this.jX();
            if (jX) {
                str = this.zC;
            } else {
                i = Math.min(n.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j) / 1000);
                str = this.zD;
            }
            final String str2 = str;
            n nVar = n.this;
            if (nVar.p(nVar.mAdInfo)) {
                final int i2 = i;
                n.this.zw.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.n.2.1
                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        int i3 = (int) (((i2 * 1000) - j2) / 1000);
                        if (i3 <= 0) {
                            i3 = 1;
                        }
                        String str3 = str2 + i3;
                        if (jX) {
                            n.this.zw.setSkipText(str3);
                        } else {
                            n.this.zw.ac(str3);
                        }
                    }
                });
            }
            float f = ((float) j2) / 1000.0f;
            if (i <= 0 || f + 0.5d <= i - 1) {
                return;
            }
            com.kwad.components.ad.splashscreen.h hVar = n.this.yF;
            if (!hVar.yb) {
                hVar.jC();
            }
            n nVar2 = n.this;
            nVar2.yF.yb = true;
            if (this.zA || !nVar2.p(nVar2.mAdInfo)) {
                return;
            }
            n.this.yF.jF();
            this.zA = true;
        }

        @Override // com.kwad.components.core.video.g
        public final void onVideoPlayStart() {
            n nVar = n.this;
            com.kwad.components.ad.splashscreen.c.a aVar = nVar.yF.yc;
            if (aVar != null) {
                aVar.c(nVar.zu, false);
            }
        }

        @Override // com.kwad.components.core.video.g
        public final void onVideoPlaying() {
            if (n.this.zv) {
                return;
            }
            n.this.yF.jE();
            com.kwad.components.ad.splashscreen.c.a aVar = n.this.yF.yc;
            if (aVar != null) {
                aVar.ad(true);
                n nVar = n.this;
                nVar.yF.yc.c(nVar.zu, true);
            }
            n.b(n.this, true);
        }

        @Override // com.kwad.components.core.video.g
        public final void onVideoPrepared() {
        }

        @Override // com.kwad.components.core.video.g
        public final void onVideoPreparing() {
        }
    };

    private void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(jX() ? false : com.kwad.sdk.core.response.a.a.bA(adInfo));
    }

    public static /* synthetic */ boolean b(n nVar, boolean z) {
        nVar.zv = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jX() {
        com.kwad.components.ad.splashscreen.h hVar = this.yF;
        return hVar != null && hVar.jz() && com.kwad.components.ad.splashscreen.a.b.jP() > 0 && !ax.dT(com.kwad.components.ad.splashscreen.a.b.jL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(AdInfo adInfo) {
        return jX() || !com.kwad.sdk.core.response.a.a.bx(adInfo);
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aR() {
        if (this.yG) {
            return;
        }
        this.yG = true;
        com.kwad.components.ad.splashscreen.local.c.V(getContext());
        com.kwad.components.core.m.c.ox().a(this.yF.mAdTemplate, null, null);
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aS() {
        com.kwad.components.ad.splashscreen.c.a aVar = this.yF.yc;
        if (aVar != null) {
            aVar.pause();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c7  */
    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void aq() {
        com.kwad.components.ad.splashscreen.c.a aVar;
        String str;
        super.aq();
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate);
        ((DetailVideoView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0913f9)).setVisibility(0);
        com.kwad.components.ad.splashscreen.c.a aVar2 = this.yF.yc;
        if (aVar2 != null) {
            aVar2.a(this.zx);
        }
        this.yF.yd.a(this);
        this.zw = (SkipView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0913f1);
        if (p(this.mAdInfo)) {
            a(this.zw, this.mAdInfo);
        }
        int i = this.mAdInfo.adSplashInfo.mute;
        boolean z = true;
        if (i != 2) {
            if (i != 3) {
                this.zu = false;
                if (com.kwad.components.core.m.b.at(getContext()).ov()) {
                    this.zu = false;
                }
                aVar = this.yF.yc;
                if (aVar != null) {
                    aVar.c(this.zu, false);
                    this.yF.yc.a(this.dv);
                }
                ImageView imageView = (ImageView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0913f6);
                this.eE = imageView;
                imageView.setVisibility(0);
                str = !this.zu ? this.mAdInfo.adSplashInfo.speakerIconUrl : this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str)) {
                    KSImageLoader.loadImage(this.eE, str, this.yF.mAdTemplate);
                } else {
                    this.eE.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e9f));
                }
                this.eE.setSelected(this.zu);
                this.eE.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.b.n.3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        n nVar = n.this;
                        nVar.zu = !nVar.zu;
                        String str2 = n.this.zu ? n.this.mAdInfo.adSplashInfo.speakerIconUrl : n.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            n.this.eE.setImageDrawable(n.this.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e9f));
                        } else {
                            KSImageLoader.loadImage(n.this.eE, str2, n.this.yF.mAdTemplate);
                        }
                        n.this.eE.setSelected(n.this.zu);
                        n nVar2 = n.this;
                        nVar2.yF.yc.c(nVar2.zu, true);
                    }
                });
            } else if (com.kwad.sdk.utils.j.cc(this.yF.mRootContainer.getContext()) <= 0) {
                z = false;
            }
        }
        this.zu = z;
        if (com.kwad.components.core.m.b.at(getContext()).ov()) {
        }
        aVar = this.yF.yc;
        if (aVar != null) {
        }
        ImageView imageView2 = (ImageView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0913f6);
        this.eE = imageView2;
        imageView2.setVisibility(0);
        if (!this.zu) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        this.eE.setSelected(this.zu);
        this.eE.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.b.n.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n nVar = n.this;
                nVar.zu = !nVar.zu;
                String str2 = n.this.zu ? n.this.mAdInfo.adSplashInfo.speakerIconUrl : n.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    n.this.eE.setImageDrawable(n.this.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e9f));
                } else {
                    KSImageLoader.loadImage(n.this.eE, str2, n.this.yF.mAdTemplate);
                }
                n.this.eE.setSelected(n.this.zu);
                n nVar2 = n.this;
                nVar2.yF.yc.c(nVar2.zu, true);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.yJ = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.c.a aVar = this.yF.yc;
        if (aVar != null) {
            aVar.b(this.zx);
            this.yF.yc.b(this.dv);
        }
        if (this.zw.getHandler() != null) {
            this.zw.getHandler().removeCallbacksAndMessages(null);
        }
        this.yF.yd.b(this);
    }
}
