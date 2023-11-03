package com.kwad.components.ad.draw.a.b;

import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.draw.kwai.a {
    public DrawVideoTailFrame bQ;
    @Nullable
    public com.kwad.components.ad.i.b bb;
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.draw.a.b.a.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            if (a.this.bb == null || !a.this.bb.ay()) {
                a.this.aN();
            } else {
                a.this.bQ.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        this.bQ.aW();
        this.bQ.setVisibility(0);
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.ad.draw.kwai.b bVar = this.aK;
        this.bb = bVar.bb;
        this.bQ.c(bVar.mAdTemplate);
        this.bQ.setAdBaseFrameLayout(this.aK.mRootContainer);
        this.bQ.setApkDownloadHelper(this.aK.mApkDownloadHelper);
        this.bQ.setVisibility(8);
        this.bQ.setAdInteractionListener(this.aK.aJ);
        this.aK.aL.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bQ = (DrawVideoTailFrame) findViewById(R.id.obfuscated_res_0x7f09149b);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aK.aL.b(this.mVideoPlayStateListener);
        this.bQ.release();
    }
}
