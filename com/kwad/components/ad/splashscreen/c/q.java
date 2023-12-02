package com.kwad.components.ad.splashscreen.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.h;
/* loaded from: classes10.dex */
public final class q extends e implements com.kwad.sdk.core.h.c {
    public SkipView Eh;
    public ImageView hp;
    public AdInfo mAdInfo;
    public volatile boolean Ee = false;
    public boolean Ef = false;
    public boolean Eg = false;
    public h.a hq = new h.a() { // from class: com.kwad.components.ad.splashscreen.c.q.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            q.this.Ee = false;
            if (q.this.hp != null) {
                q.this.hp.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.q.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str;
                        q qVar = q.this;
                        com.kwad.components.ad.splashscreen.e.a aVar = qVar.Df.Cp;
                        if (aVar != null) {
                            aVar.setAudioEnabled(qVar.Ee, false);
                        }
                        com.kwad.components.ad.splashscreen.h hVar = q.this.Df;
                        if (hVar != null) {
                            AdInfo dP = com.kwad.sdk.core.response.b.e.dP(hVar.mAdTemplate);
                            boolean z = q.this.Ee;
                            AdInfo.AdSplashInfo adSplashInfo = dP.adSplashInfo;
                            if (z) {
                                str = adSplashInfo.speakerIconUrl;
                            } else {
                                str = adSplashInfo.speakerMuteIconUrl;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                KSImageLoader.loadImage(q.this.hp, str, q.this.Df.mAdTemplate);
                            } else {
                                q.this.hp.setImageDrawable(q.this.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080efe));
                            }
                            q.this.hp.setSelected(false);
                        }
                    }
                });
            }
        }
    };
    public com.kwad.components.core.video.k Ei = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.splashscreen.c.q.2
        public boolean El = false;
        public String Em = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CM);

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPlaying() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            if (!this.El) {
                q.this.Df.kF();
                this.El = true;
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            q qVar = q.this;
            com.kwad.components.ad.splashscreen.e.a aVar = qVar.Df.Cp;
            if (aVar != null) {
                aVar.setAudioEnabled(qVar.Ee, false);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            if (!q.this.Ef) {
                q.this.Df.kA();
                com.kwad.components.ad.splashscreen.e.a aVar = q.this.Df.Cp;
                if (aVar != null) {
                    aVar.ae(true);
                    q qVar = q.this;
                    qVar.Df.Cp.setAudioEnabled(qVar.Ee, true);
                }
                q.b(q.this, true);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i, int i2) {
            if (!q.this.Eg) {
                q.this.Df.i(0, "onMediaPlayError");
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, final long j2) {
            q.this.Df.X(((int) j2) / 1000);
            final int min = Math.min(q.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j) / 1000);
            final String str = this.Em;
            q qVar = q.this;
            if (q.a(qVar, qVar.mAdInfo)) {
                q.this.Eh.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.q.2.1
                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        int i = (int) (((min * 1000) - j2) / 1000);
                        if (i <= 0) {
                            i = 1;
                        }
                        q.this.Eh.W(str + i);
                    }
                });
            }
            float f = ((float) j2) / 1000.0f;
            if (min > 0 && f + 0.5d > min - 1 && !this.El) {
                q qVar2 = q.this;
                if (q.a(qVar2, qVar2.mAdInfo)) {
                    q.this.Df.kF();
                    this.El = true;
                }
            }
        }
    };

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Df.Cp;
        if (aVar != null) {
            aVar.pause();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.Eg = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.a aVar = this.Df.Cp;
        if (aVar != null) {
            aVar.a(this.Ei);
            this.Df.Cp.b(this.hq);
        }
        if (this.Eh.getHandler() != null) {
            this.Eh.getHandler().removeCallbacksAndMessages(null);
        }
        this.Df.Cr.b(this);
    }

    public static boolean u(AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.ct(adInfo)) {
            return true;
        }
        return false;
    }

    public static void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cw(adInfo));
    }

    public static /* synthetic */ boolean b(q qVar, boolean z) {
        qVar.Ef = true;
        return true;
    }

    public static /* synthetic */ boolean a(q qVar, AdInfo adInfo) {
        return u(adInfo);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        int i;
        String str;
        super.aj();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate);
        ((DetailVideoView) this.Df.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0914d1)).setVisibility(0);
        com.kwad.components.ad.splashscreen.e.a aVar = this.Df.Cp;
        if (aVar != null) {
            aVar.b(this.Ei);
        }
        this.Df.Cr.a(this);
        AdBaseFrameLayout adBaseFrameLayout = this.Df.mRootContainer;
        if (com.kwad.components.ad.splashscreen.f.c.z(this.mAdInfo)) {
            i = R.id.obfuscated_res_0x7f0914cb;
        } else {
            i = R.id.obfuscated_res_0x7f0914ca;
        }
        this.Eh = (SkipView) adBaseFrameLayout.findViewById(i);
        if (u(this.mAdInfo)) {
            a(this.Eh, this.mAdInfo);
        }
        int i2 = this.mAdInfo.adSplashInfo.mute;
        boolean z = true;
        if (i2 != 2) {
            if (i2 != 3) {
                this.Ee = false;
            } else {
                if (com.kwad.sdk.utils.k.bS(this.Df.mRootContainer.getContext()) <= 0) {
                    z = false;
                }
                this.Ee = z;
            }
        } else {
            this.Ee = true;
        }
        if (com.kwad.components.core.s.a.ah(getContext()).qJ()) {
            this.Ee = false;
        }
        com.kwad.components.ad.splashscreen.e.a aVar2 = this.Df.Cp;
        if (aVar2 != null) {
            aVar2.setAudioEnabled(this.Ee, false);
            this.Df.Cp.a(this.hq);
        }
        this.hp = (ImageView) this.Df.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0914d0);
        if (com.kwad.components.ad.splashscreen.f.c.z(this.mAdInfo)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hp.getLayoutParams();
            layoutParams.gravity = 51;
            this.hp.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.hp.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.topMargin = com.kwad.sdk.d.a.a.a(this.hp.getContext(), 32.0f);
                marginLayoutParams.leftMargin = com.kwad.sdk.d.a.a.a(this.hp.getContext(), 16.0f);
            }
        }
        this.hp.setVisibility(0);
        if (this.Ee) {
            str = this.mAdInfo.adSplashInfo.speakerIconUrl;
        } else {
            str = this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
        }
        if (!TextUtils.isEmpty(str)) {
            KSImageLoader.loadImage(this.hp, str, this.Df.mAdTemplate);
        } else {
            this.hp.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080efe));
        }
        this.hp.setSelected(this.Ee);
        this.hp.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.q.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String str2;
                q qVar = q.this;
                qVar.Ee = !qVar.Ee;
                if (q.this.Ee) {
                    str2 = q.this.mAdInfo.adSplashInfo.speakerIconUrl;
                } else {
                    str2 = q.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                }
                if (!TextUtils.isEmpty(str2)) {
                    KSImageLoader.loadImage(q.this.hp, str2, q.this.Df.mAdTemplate);
                } else {
                    q.this.hp.setImageDrawable(q.this.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080efe));
                }
                q.this.hp.setSelected(q.this.Ee);
                q qVar2 = q.this;
                qVar2.Df.Cp.setAudioEnabled(qVar2.Ee, true);
            }
        });
    }
}
