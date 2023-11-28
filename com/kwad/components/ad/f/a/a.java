package com.kwad.components.ad.f.a;

import com.kwad.components.core.video.k;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public class a extends Presenter {
    public b mM;
    public k mVideoPlayStateListener;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        this.mM = (b) HU();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.mM.mN.a(this.mVideoPlayStateListener);
    }
}
