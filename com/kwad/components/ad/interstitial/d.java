package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.a.h;
import com.kwad.components.core.widget.f;
import com.kwad.components.core.widget.g;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bm;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.core.proxy.d {
    public com.kwad.components.ad.interstitial.g.a hZ;
    public boolean ia;
    public com.kwad.components.ad.interstitial.f.b ib;
    @NonNull
    public final KsAdVideoPlayConfig ic;
    public KsInterstitialAd.AdInteractionListener ie;

    /* renamed from: if  reason: not valid java name */
    public final g f5if;
    public final AdResultData mAdResultData;
    public final AdTemplate mAdTemplate;
    public bm mTimerHelper;

    @Override // com.kwad.components.core.proxy.d
    public final float cj() {
        return 0.0f;
    }

    @Override // com.kwad.components.core.proxy.d
    public final int getLayoutId() {
        return 0;
    }

    public d(@NonNull Activity activity, @NonNull AdResultData adResultData, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        boolean z;
        this.f5if = new g() { // from class: com.kwad.components.ad.interstitial.d.1
            @Override // com.kwad.components.core.widget.g
            public final void j(boolean z2) {
                int i;
                if (!d.this.ia) {
                    return;
                }
                Activity activity2 = d.this.mActivity;
                com.kwad.sdk.core.c.b.Ct();
                if (activity2 != com.kwad.sdk.core.c.b.getCurrentActivity()) {
                    return;
                }
                AdTemplate adTemplate = d.this.mAdTemplate;
                if (z2) {
                    i = 2;
                } else {
                    i = 1;
                }
                com.kwad.sdk.core.report.a.l(adTemplate, i);
                d.this.cn();
            }
        };
        this.ie = adInteractionListener;
        KsAdVideoPlayConfig.Builder builder = new KsAdVideoPlayConfig.Builder();
        if (ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()) {
            z = true;
        } else {
            z = false;
        }
        this.ic = builder.videoSoundEnable(z).dataFlowAutoStart(com.kwad.components.ad.interstitial.b.b.cE()).build();
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.m(adResultData);
    }

    @Override // com.kwad.components.core.proxy.d
    public final void g(View view2) {
        h.a(getWindow());
        cn();
        com.kwad.components.ad.interstitial.report.c.dQ().r(this.mAdTemplate);
        com.kwad.sdk.i.a.aj("interstitial", "show");
        com.kwad.sdk.commercial.e.c.bA(this.mAdTemplate);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.ia = z;
        com.kwad.components.ad.interstitial.g.a aVar = this.hZ;
        if (aVar != null) {
            if (z) {
                aVar.cr();
            } else {
                aVar.cs();
            }
        }
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.ie = adInteractionListener;
        com.kwad.components.ad.interstitial.g.a aVar = this.hZ;
        if (aVar != null) {
            aVar.setAdInteractionListener(adInteractionListener);
        }
    }

    private boolean cl() {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.cp(dP) && !cm() && com.kwad.components.ad.interstitial.c.a.cM() < com.kwad.sdk.core.response.b.a.cs(dP)) {
            return true;
        }
        return false;
    }

    private boolean cm() {
        if (!com.kwad.sdk.core.response.b.b.cf(this.mAdTemplate) || com.kwad.components.ad.interstitial.d.a.cO() >= com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.apv)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn() {
        com.kwad.components.ad.interstitial.g.a cVar;
        if (cl()) {
            cVar = new com.kwad.components.ad.interstitial.aggregate.b(this.mContext);
        } else {
            cVar = new com.kwad.components.ad.interstitial.g.c(this.mContext);
        }
        this.hZ = cVar;
        cVar.a(this.mAdResultData, this, this.ic, this.ie);
        this.zf.removeAllViews();
        this.zf.addView(this.hZ);
        co();
    }

    private void co() {
        com.kwad.components.ad.interstitial.f.b bVar = new com.kwad.components.ad.interstitial.f.b(this.hZ, 100);
        this.ib = bVar;
        bVar.a(new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.interstitial.d.2
            @Override // com.kwad.sdk.core.h.c
            public final void aM() {
                d.this.getTimerHelper().LM();
            }

            @Override // com.kwad.sdk.core.h.c
            public final void aN() {
                d.this.getTimerHelper().LN();
            }
        });
        this.ib.tm();
    }

    @Override // com.kwad.components.core.proxy.d
    public final ViewGroup ck() {
        f fVar = new f(this.mContext);
        fVar.setOrientationChangeListener(this.f5if);
        return fVar;
    }

    @Override // com.kwad.components.core.proxy.d, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        com.kwad.sdk.a.a.c.yT().yW();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.ie;
        if (adInteractionListener != null) {
            adInteractionListener.onPageDismiss();
        }
        h.ne();
    }

    public final bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bm();
        }
        return this.mTimerHelper;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (com.kwad.components.ad.interstitial.b.b.cI()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.f.b bVar = this.ib;
        if (bVar != null) {
            bVar.release();
        }
    }
}
