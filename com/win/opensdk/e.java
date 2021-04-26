package com.win.opensdk;
/* loaded from: classes6.dex */
public class e implements PBInterstitialListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBInterstitial f37859a;

    public e(PBInterstitial pBInterstitial) {
        this.f37859a = pBInterstitial;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBInterstitialListener pBInterstitialListener = this.f37859a.f37725c;
        if (pBInterstitialListener != null) {
            pBInterstitialListener.onClicked();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        PBInterstitialListener pBInterstitialListener = this.f37859a.f37725c;
        if (pBInterstitialListener != null) {
            pBInterstitialListener.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBInterstitialListener
    public void onInterstitialDismissed() {
        PBInterstitialListener pBInterstitialListener = this.f37859a.f37725c;
        if (pBInterstitialListener != null) {
            pBInterstitialListener.onInterstitialDismissed();
        }
    }

    @Override // com.win.opensdk.PBInterstitialListener
    public void onInterstitialDisplayed() {
        PBInterstitialListener pBInterstitialListener = this.f37859a.f37725c;
        if (pBInterstitialListener != null) {
            pBInterstitialListener.onInterstitialDisplayed();
        }
    }

    @Override // com.win.opensdk.PBInterstitialListener
    public void onInterstitialShowFail(String str) {
        PBInterstitialListener pBInterstitialListener = this.f37859a.f37725c;
        if (pBInterstitialListener != null) {
            pBInterstitialListener.onInterstitialShowFail(str);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        PBInterstitialListener pBInterstitialListener = this.f37859a.f37725c;
        if (pBInterstitialListener != null) {
            pBInterstitialListener.onLoaded();
        }
    }
}
