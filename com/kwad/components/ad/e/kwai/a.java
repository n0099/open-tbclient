package com.kwad.components.ad.e.kwai;

import com.kwad.components.core.video.g;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes9.dex */
public class a extends Presenter {
    public b jL;
    public g mVideoPlayStateListener;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aq() {
        super.aq();
        this.jL = (b) xR();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.jL.jM.b(this.mVideoPlayStateListener);
    }
}
