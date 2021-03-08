package com.win.opensdk;
/* loaded from: classes14.dex */
public class cl implements PBInterstitialListener {
    public final /* synthetic */ PBInterstitial qlA;

    public cl(PBInterstitial pBInterstitial) {
        this.qlA = pBInterstitial;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBInterstitialListener pBInterstitialListener = this.qlA.c;
        if (pBInterstitialListener != null) {
            pBInterstitialListener.onClicked();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        PBInterstitialListener pBInterstitialListener = this.qlA.c;
        if (pBInterstitialListener != null) {
            pBInterstitialListener.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBInterstitialListener
    public void onInterstitialDismissed() {
        PBInterstitialListener pBInterstitialListener = this.qlA.c;
        if (pBInterstitialListener != null) {
            pBInterstitialListener.onInterstitialDismissed();
        }
    }

    @Override // com.win.opensdk.PBInterstitialListener
    public void onInterstitialDisplayed() {
        PBInterstitialListener pBInterstitialListener = this.qlA.c;
        if (pBInterstitialListener != null) {
            pBInterstitialListener.onInterstitialDisplayed();
        }
    }

    @Override // com.win.opensdk.PBInterstitialListener
    public void onInterstitialShowFail(String str) {
        PBInterstitialListener pBInterstitialListener = this.qlA.c;
        if (pBInterstitialListener != null) {
            pBInterstitialListener.onInterstitialShowFail(str);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        PBInterstitialListener pBInterstitialListener = this.qlA.c;
        if (pBInterstitialListener != null) {
            pBInterstitialListener.onLoaded();
        }
    }
}
