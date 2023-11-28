package com.kwad.components.ad.draw.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.j.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.l;
/* loaded from: classes10.dex */
public final class a extends b {
    public com.kwad.components.core.widget.a.b bQ;
    public long dc;
    public com.kwad.sdk.contentalliance.a.a.a dd;
    public boolean de;
    public final c df;
    public Context mContext;

    public a(@NonNull AdTemplate adTemplate, @NonNull com.kwad.components.core.widget.a.b bVar, @NonNull DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        this.df = new c() { // from class: com.kwad.components.ad.draw.c.a.2
            @Override // com.kwad.sdk.core.h.c
            public final void aM() {
                if (a.this.dd == null) {
                    a aVar = a.this;
                    aVar.dd = com.kwad.sdk.contentalliance.a.a.a.bE(aVar.mAdTemplate);
                    a.this.Hr.a(a.this.dd);
                }
                if (a.this.de) {
                    return;
                }
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.h.c
            public final void aN() {
                a.this.pause();
            }
        };
        this.dc = com.kwad.sdk.core.response.b.a.ab(e.dP(this.mAdTemplate));
        this.bQ = bVar;
        this.mContext = detailVideoView.getContext();
        aL();
        this.Hr.a(new c.e() { // from class: com.kwad.components.ad.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.start(l.el(a.this.mAdTemplate));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(long j) {
        if (this.bQ.dW()) {
            this.Hr.a(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, j));
            this.Hr.start();
        }
    }

    public final void f(boolean z) {
        this.de = z;
    }

    private void aL() {
        this.Hr.a(new b.a(this.mAdTemplate).cD(e.dR(this.mAdTemplate)).cE(h.b(e.dQ(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).Ah(), this.mDetailVideoView);
        this.Hr.prepareAsync();
    }

    public final void aJ() {
        long el = l.el(this.mAdTemplate);
        if (this.Hr.rf() == null) {
            aL();
        }
        start(el);
        this.bQ.a(this.df);
    }

    public final void aK() {
        this.dd = null;
        this.bQ.b(this.df);
        this.Hr.release();
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final void resume() {
        super.resume();
        com.kwad.components.core.s.a.ah(this.mContext).aM(false);
    }
}
