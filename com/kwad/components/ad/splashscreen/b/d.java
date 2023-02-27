package com.kwad.components.ad.splashscreen.b;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class d extends e {
    public List<Integer> bv;
    public final com.kwad.components.core.video.g mVideoPlayStateListener = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.splashscreen.b.d.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayCompleted() {
            d.this.ke();
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            d.this.c(j2);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayStart() {
            d.this.kd();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.bv;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.bv.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.b(this.yF.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        com.kwad.sdk.core.report.a.aw(this.yF.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ke() {
        com.kwad.sdk.core.report.a.ax(this.yF.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.bv = com.kwad.sdk.core.response.a.a.aF(com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate));
        com.kwad.components.ad.splashscreen.c.a aVar = this.yF.yc;
        if (aVar != null) {
            aVar.a(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.c.a aVar = this.yF.yc;
        if (aVar != null) {
            aVar.b(this.mVideoPlayStateListener);
        }
    }
}
