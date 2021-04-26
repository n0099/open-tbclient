package com.win.opensdk;
/* loaded from: classes6.dex */
public class f implements PBNativeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBNative f37862a;

    public f(PBNative pBNative) {
        this.f37862a = pBNative;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBNativeListener pBNativeListener = this.f37862a.f37728b;
        if (pBNativeListener != null) {
            pBNativeListener.onClicked();
        }
    }

    @Override // com.win.opensdk.PBNativeListener
    public void onDisplayed() {
        PBNativeListener pBNativeListener = this.f37862a.f37728b;
        if (pBNativeListener != null) {
            pBNativeListener.onDisplayed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        PBNativeListener pBNativeListener = this.f37862a.f37728b;
        if (pBNativeListener != null) {
            pBNativeListener.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        PBNativeListener pBNativeListener = this.f37862a.f37728b;
        if (pBNativeListener != null) {
            pBNativeListener.onLoaded();
        }
    }
}
