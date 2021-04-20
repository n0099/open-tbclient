package com.win.opensdk;
/* loaded from: classes7.dex */
public class f implements PBNativeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBNative f40218a;

    public f(PBNative pBNative) {
        this.f40218a = pBNative;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBNativeListener pBNativeListener = this.f40218a.f40048b;
        if (pBNativeListener != null) {
            pBNativeListener.onClicked();
        }
    }

    @Override // com.win.opensdk.PBNativeListener
    public void onDisplayed() {
        PBNativeListener pBNativeListener = this.f40218a.f40048b;
        if (pBNativeListener != null) {
            pBNativeListener.onDisplayed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        PBNativeListener pBNativeListener = this.f40218a.f40048b;
        if (pBNativeListener != null) {
            pBNativeListener.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        PBNativeListener pBNativeListener = this.f40218a.f40048b;
        if (pBNativeListener != null) {
            pBNativeListener.onLoaded();
        }
    }
}
