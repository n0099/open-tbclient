package com.win.opensdk;
/* loaded from: classes14.dex */
public class cp implements PBNativeListener {
    public final /* synthetic */ PBNative BC;

    public cp(PBNative pBNative) {
        this.BC = pBNative;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBNativeListener pBNativeListener = this.BC.b;
        if (pBNativeListener != null) {
            pBNativeListener.onClicked();
        }
    }

    @Override // com.win.opensdk.PBNativeListener
    public void onDisplayed() {
        PBNativeListener pBNativeListener = this.BC.b;
        if (pBNativeListener != null) {
            pBNativeListener.onDisplayed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        PBNativeListener pBNativeListener = this.BC.b;
        if (pBNativeListener != null) {
            pBNativeListener.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        PBNativeListener pBNativeListener = this.BC.b;
        if (pBNativeListener != null) {
            pBNativeListener.onLoaded();
        }
    }
}
