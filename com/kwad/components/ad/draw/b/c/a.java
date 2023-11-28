package com.kwad.components.ad.draw.b.c;

import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.draw.a.a {
    public DrawVideoTailFrame cY;
    @Nullable
    public com.kwad.components.ad.k.b ci;
    public k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.c.a.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            if (a.this.ci == null || !a.this.ci.ar()) {
                a.this.aI();
            } else {
                a.this.cY.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aI() {
        this.cY.aR();
        this.cY.setVisibility(0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cY = (DrawVideoTailFrame) findViewById(R.id.obfuscated_res_0x7f091503);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bO.bP.a(this.mVideoPlayStateListener);
        this.cY.release();
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.draw.a.b bVar = this.bO;
        this.ci = bVar.ci;
        this.cY.b(bVar.mAdTemplate);
        this.cY.setAdBaseFrameLayout(this.bO.mRootContainer);
        this.cY.setApkDownloadHelper(this.bO.mApkDownloadHelper);
        this.cY.setVisibility(8);
        this.cY.setAdInteractionListener(this.bO.bN);
        this.bO.bP.b(this.mVideoPlayStateListener);
    }
}
