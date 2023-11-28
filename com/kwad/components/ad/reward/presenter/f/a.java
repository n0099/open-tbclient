package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.sdk.components.p;
/* loaded from: classes10.dex */
public abstract class a extends d {
    public o wc;

    @Override // com.kwad.components.ad.reward.presenter.f.d
    public final boolean iK() {
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.wc = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.reward.presenter.f.a.1
            @Override // com.kwad.components.core.webview.tachikoma.a.o.a
            public final boolean isMuted() {
                if (a.this.qn.mVideoPlayConfig.isVideoSoundEnable() && !com.kwad.components.core.s.a.ah(a.this.getContext()).qJ()) {
                    return false;
                }
                return true;
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aI = com.kwad.sdk.d.a.a.aI(getContext());
        aVar.width = (int) ((com.kwad.sdk.d.a.a.getScreenWidth(getContext()) / aI) + 0.5f);
        aVar.height = (int) ((com.kwad.sdk.d.a.a.getScreenHeight(getContext()) / aI) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public void a(p pVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(pVar, bVar);
        pVar.c(new v() { // from class: com.kwad.components.ad.reward.presenter.f.a.2
            @Override // com.kwad.components.core.webview.jshandler.v
            public final void a(x xVar) {
                super.a(xVar);
                a.this.qn.oH.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.c.b(a.this.qn.oX, a.this.qn.mAdTemplate, a.this.qn.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void d(x xVar) {
                super.d(xVar);
                a.this.qn.mAdTemplate.setmCurPlayTime(xVar.nD);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void b(x xVar) {
                super.b(xVar);
                long sK = xVar.sK();
                a.this.qn.oH.onVideoPlayError(xVar.errorCode, (int) sK);
                com.kwad.components.ad.reward.monitor.c.a(a.this.qn.oX, a.this.qn.mAdTemplate, a.this.qn.pu, xVar.errorCode, sK);
                com.kwad.components.ad.reward.monitor.b.c(a.this.qn.oX, a.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void c(x xVar) {
                super.c(xVar);
                a.this.qn.oH.onVideoPlayEnd();
                a.this.qn.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.s(a.this.qn);
                if (xVar.sI()) {
                    com.kwad.components.ad.reward.g unused = a.this.qn;
                    com.kwad.components.ad.reward.g.a(a.this.qn.oQ, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.a.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.g.a
                        /* renamed from: c */
                        public void accept(com.kwad.components.ad.reward.k.a aVar) {
                            com.kwad.components.ad.reward.g unused2 = a.this.qn;
                            aVar.iI();
                        }
                    });
                }
            }
        });
    }
}
