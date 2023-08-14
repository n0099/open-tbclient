package com.kwad.components.ad.e.a;

import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.e.kwai.a {
    public List<Integer> bv;
    public volatile boolean bw = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.bv;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.bv) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.b(this.jL.mAdTemplate, ceil, (JSONObject) null);
                this.bv.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.bv = com.kwad.sdk.core.response.a.a.aF(com.kwad.sdk.core.response.a.d.bQ(this.jL.mAdTemplate));
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.e.a.c.1
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                com.kwad.sdk.core.report.a.ax(c.this.jL.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                c.this.c(j2);
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                c.this.bw = false;
                if (!c.this.jL.mAdTemplate.mPvReported) {
                    c.this.jL.jC.en();
                }
                com.kwad.components.core.m.c.ox().a(c.this.jL.mAdTemplate, null, null);
                com.kwad.sdk.core.report.a.aw(c.this.jL.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlaying() {
                if (c.this.bw) {
                    return;
                }
                c.this.bw = true;
                com.kwad.components.core.j.a.og().a(c.this.jL.mAdTemplate, System.currentTimeMillis(), 1);
            }
        };
        this.mVideoPlayStateListener = hVar;
        this.jL.jM.a(hVar);
    }
}
