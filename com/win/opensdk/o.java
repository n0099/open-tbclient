package com.win.opensdk;
/* loaded from: classes7.dex */
public class o implements PBVideoListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBVideo f40377a;

    public o(PBVideo pBVideo) {
        this.f40377a = pBVideo;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBVideoListener pBVideoListener = this.f40377a.f40154c;
        if (pBVideoListener != null) {
            pBVideoListener.onClicked();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        PBVideoListener pBVideoListener = this.f40377a.f40154c;
        if (pBVideoListener != null) {
            pBVideoListener.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        PBVideoListener pBVideoListener = this.f40377a.f40154c;
        if (pBVideoListener != null) {
            pBVideoListener.onLoaded();
        }
    }

    @Override // com.win.opensdk.PBVideoListener
    public void onRewardedAdClosed() {
        PBVideoListener pBVideoListener = this.f40377a.f40154c;
        if (pBVideoListener != null) {
            pBVideoListener.onRewardedAdClosed();
        }
    }

    @Override // com.win.opensdk.PBVideoListener
    public void onRewardedAdOpened() {
        PBVideoListener pBVideoListener = this.f40377a.f40154c;
        if (pBVideoListener != null) {
            pBVideoListener.onRewardedAdOpened();
        }
    }

    @Override // com.win.opensdk.PBVideoListener
    public void onRewardedShowFail(String str) {
        PBVideoListener pBVideoListener = this.f40377a.f40154c;
        if (pBVideoListener != null) {
            pBVideoListener.onRewardedShowFail(str);
        }
    }

    @Override // com.win.opensdk.PBVideoListener
    public void onUserEarnedReward(boolean z, long j) {
        PBVideoListener pBVideoListener = this.f40377a.f40154c;
        if (pBVideoListener != null) {
            pBVideoListener.onUserEarnedReward(z, j);
        }
    }
}
