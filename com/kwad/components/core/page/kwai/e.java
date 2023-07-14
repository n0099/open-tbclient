package com.kwad.components.core.page.kwai;

import android.app.Activity;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
/* loaded from: classes10.dex */
public final class e extends c {
    public com.kwad.components.core.page.a.a mPlayModule;
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.core.page.kwai.e.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayCompleted() {
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayError(int i, int i2) {
            Activity activity = e.this.Gi.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayStart() {
        }
    };

    @Override // com.kwad.components.core.page.kwai.c, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.core.page.a.a aVar = this.Gi.mPlayModule;
        this.mPlayModule = aVar;
        aVar.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mPlayModule.b(this.mVideoPlayStateListener);
    }
}
