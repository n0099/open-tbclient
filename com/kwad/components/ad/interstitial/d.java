package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.kwad.components.ad.interstitial.widget.g;
import com.kwad.components.ad.interstitial.widget.h;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class d extends AlertDialog {
    public g fB;
    public com.kwad.components.ad.interstitial.widget.b fC;
    @NonNull
    public KsAdVideoPlayConfig fD;
    public h fE;
    public KsInterstitialAd.AdInteractionListener fo;
    public Activity mActivity;
    public AdTemplate mAdTemplate;

    public d(@NonNull Activity activity, @NonNull AdTemplate adTemplate, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        this.fE = new h() { // from class: com.kwad.components.ad.interstitial.d.1
            @Override // com.kwad.components.ad.interstitial.widget.h
            public final void k(boolean z) {
                com.kwad.sdk.core.report.a.i(d.this.mAdTemplate, z ? 2 : 1);
                d.this.ch();
            }
        };
        this.mActivity = activity;
        this.fo = adInteractionListener;
        this.fD = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(com.kwad.components.ad.interstitial.kwai.b.ci()).build();
        setOwnerActivity(activity);
        this.mAdTemplate = adTemplate;
        initView();
    }

    private boolean cg() {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        return com.kwad.sdk.core.response.a.a.bt(bQ) && com.kwad.components.ad.interstitial.a.a.cp() < com.kwad.sdk.core.response.a.a.bw(bQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch() {
        this.fB.removeAllViews();
        com.kwad.components.ad.interstitial.widget.b cVar = cg() ? new com.kwad.components.ad.interstitial.widget.c(Wrapper.wrapContextIfNeed(this.mActivity)) : new com.kwad.components.ad.interstitial.widget.e(Wrapper.wrapContextIfNeed(this.mActivity));
        this.fC = cVar;
        cVar.a(this.mAdTemplate, this, this.fD, this.fo);
        this.fB.addView(this.fC);
    }

    private void initView() {
        this.fC = cg() ? new com.kwad.components.ad.interstitial.widget.c(Wrapper.wrapContextIfNeed(this.mActivity)) : new com.kwad.components.ad.interstitial.widget.e(Wrapper.wrapContextIfNeed(this.mActivity));
        g gVar = new g(Wrapper.wrapContextIfNeed(this.mActivity));
        this.fB = gVar;
        gVar.setOrientationChangeListener(this.fE);
        this.fB.removeAllViews();
        this.fB.addView(this.fC);
    }

    public final boolean cf() {
        try {
            if (isShowing() || this.mActivity == null || this.mActivity.isFinishing()) {
                return true;
            }
            show();
            com.kwad.components.ad.interstitial.a.b.I(this.mActivity);
            return true;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
            return false;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        com.kwad.sdk.kwai.kwai.c.rd().rg();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.fo;
        if (adInteractionListener != null) {
            adInteractionListener.onPageDismiss();
        }
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (com.kwad.components.ad.interstitial.kwai.b.cm()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.fB);
        this.fC.a(this.mAdTemplate, this, this.fD, this.fo);
        setCanceledOnTouchOutside(false);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        com.kwad.sdk.core.e.b.d("InterstitialDialog", "onStart");
        setTitle((CharSequence) null);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.fC.dM();
        } else {
            this.fC.dN();
        }
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.fo = adInteractionListener;
        com.kwad.components.ad.interstitial.widget.b bVar = this.fC;
        if (bVar != null) {
            bVar.setAdInteractionListener(adInteractionListener);
        }
    }
}
