package com.kwad.components.ad.draw.b;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.components.core.widget.kwai.b;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.k;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.h.a {
    public b aM;
    public long bU;
    public com.kwad.sdk.contentalliance.kwai.kwai.a bV;
    public boolean bW;
    public final com.kwad.sdk.core.h.b bX;
    public Context mContext;

    public a(@NonNull AdTemplate adTemplate, @NonNull b bVar, @NonNull DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        this.bX = new com.kwad.sdk.core.h.b() { // from class: com.kwad.components.ad.draw.b.a.2
            @Override // com.kwad.sdk.core.h.b
            public final void aR() {
                if (a.this.bV == null) {
                    a aVar = a.this;
                    aVar.bV = com.kwad.sdk.contentalliance.kwai.kwai.a.al(aVar.mAdTemplate);
                    a.this.BL.a(a.this.bV);
                }
                if (a.this.bW) {
                    return;
                }
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.h.b
            public final void aS() {
                a.this.pause();
            }
        };
        this.bU = com.kwad.sdk.core.response.a.a.O(d.bQ(this.mAdTemplate));
        this.aM = bVar;
        this.mContext = detailVideoView.getContext();
        aQ();
        this.BL.a(new c.e() { // from class: com.kwad.components.ad.draw.b.a.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                a.this.start(k.ck(a.this.mAdTemplate));
            }
        });
    }

    private void aQ() {
        this.BL.a(new b.a(this.mAdTemplate).bk(d.bS(this.mAdTemplate)).bl(f.b(d.bR(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).rC(), this.mDetailVideoView);
        this.BL.prepareAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(long j) {
        if (this.aM.dK()) {
            this.BL.a(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, j));
            this.BL.start();
        }
    }

    @MainThread
    public final void a(g gVar) {
        if (gVar == null) {
            return;
        }
        this.BL.c(gVar);
    }

    public final void aO() {
        long ck = k.ck(this.mAdTemplate);
        if (this.BL.oT() == null) {
            aQ();
        }
        start(ck);
        this.aM.a(this.bX);
    }

    public final void aP() {
        this.bV = null;
        this.aM.b(this.bX);
        this.BL.release();
    }

    @MainThread
    public final void b(g gVar) {
        if (gVar == null) {
            return;
        }
        this.BL.d(gVar);
    }

    public final void f(boolean z) {
        this.bW = z;
    }

    public final void pause() {
        this.BL.pause();
    }

    @Override // com.kwad.components.ad.h.a
    @MainThread
    public final void release() {
        super.release();
        com.kwad.components.core.video.b bVar = this.BL;
        if (bVar != null) {
            bVar.clear();
            this.BL.release();
        }
    }

    public final void resume() {
        this.BL.resume();
        com.kwad.components.core.m.b.at(this.mContext).ay(false);
    }
}
