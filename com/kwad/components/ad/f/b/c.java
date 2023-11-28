package com.kwad.components.ad.f.b;

import android.view.View;
import com.kwad.components.core.video.l;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.f.a.a {
    public List<Integer> cB;
    public volatile boolean cC = false;

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.cB = com.kwad.sdk.core.response.b.a.bm(com.kwad.sdk.core.response.b.e.dP(this.mM.mAdTemplate));
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.c.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                com.kwad.sdk.core.report.a.bO(c.this.mM.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                if (c.this.cC) {
                    return;
                }
                c.this.cC = true;
                com.kwad.components.core.o.a.pX().b(c.this.mM.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j, long j2) {
                c.this.c(j2);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                c.this.cC = false;
                if (!c.this.mM.mAdTemplate.mPvReported) {
                    c.this.mM.mv.eq();
                }
                com.kwad.sdk.core.report.j jVar = new com.kwad.sdk.core.report.j();
                View view2 = (View) c.this.mM.mH.getParent();
                if (view2 != null) {
                    jVar.x(view2.getHeight(), view2.getWidth());
                }
                com.kwad.components.core.s.b.qL().a(c.this.mM.mAdTemplate, null, jVar);
                com.kwad.sdk.core.report.a.bN(c.this.mM.mAdTemplate);
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mM.mN.b((com.kwad.components.core.video.k) lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cB;
        if (list != null && !list.isEmpty()) {
            for (Integer num : this.cB) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.a(this.mM.mAdTemplate, ceil, (JSONObject) null);
                    this.cB.remove(num);
                    return;
                }
            }
        }
    }
}
