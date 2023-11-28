package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class r extends b implements com.kwad.components.ad.reward.e.g, com.kwad.components.ad.reward.e.j, aq.b {
    public com.kwad.components.core.webview.tachikoma.e.e gX;
    public float sB;
    public boolean sQ;
    @Nullable
    public a sR;
    @Nullable
    public q sS;
    @Nullable
    public o sT;
    public p sU;
    public int sV;
    public boolean sW;
    public boolean sX;
    public boolean sY;

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    /* loaded from: classes10.dex */
    public class a extends com.kwad.components.core.video.l {
        public long ta;
        public long videoDuration;

        public a() {
        }

        public /* synthetic */ a(r rVar, byte b) {
            this();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            this.ta = j2;
            this.videoDuration = j;
            if (r.this.qn.fw()) {
                return;
            }
            r.this.a(j, j2, false);
        }
    }

    public r(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }

    public r(AdTemplate adTemplate, boolean z, boolean z2) {
        this.sV = 0;
        this.sW = false;
        this.sX = true;
        this.sY = true;
        this.sX = z;
        this.sY = z2;
        if (com.kwad.sdk.core.response.b.a.bH(com.kwad.sdk.core.response.b.e.dP(adTemplate))) {
            p pVar = new p();
            this.sU = pVar;
            a(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, boolean z) {
        boolean z2;
        q qVar;
        if (hD() && j2 >= 10000 && ((float) j2) >= ((float) j) * this.sB) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return;
        }
        if (com.kwad.components.ad.reward.a.b.gv()) {
            if (!this.sW && (qVar = this.sS) != null) {
                qVar.hy();
                this.sV = 1;
                this.sW = true;
                return;
            }
            return;
        }
        o oVar = this.sT;
        if (oVar != null) {
            oVar.H(!z);
            this.sV = 2;
        }
    }

    private com.kwad.components.core.webview.tachikoma.e.e bV() {
        if (this.gX == null) {
            this.gX = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.reward.presenter.r.2
                @Override // com.kwad.components.core.webview.tachikoma.e.b
                public final void q(String str) {
                    r.this.hC();
                }
            };
        }
        return this.gX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC() {
        if (this.sY) {
            q qVar = new q(this);
            this.sS = qVar;
            a((Presenter) qVar, true);
        }
        if (this.sX) {
            o oVar = new o(this);
            this.sT = oVar;
            a((Presenter) oVar, true);
        }
    }

    private boolean hD() {
        return this.sQ;
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void bL() {
        RewardActionBarControl.ShowActionBarResult ie = this.qn.oL.ie();
        if (ie != null) {
            ie.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.sU != null && !this.qn.fG()) {
            if (hD()) {
                this.sU.e(PlayableSource.PLAY_FINISHED_NORMAL);
            } else {
                this.sU.hx();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        this.qn.z(false);
        a aVar = this.sR;
        if (aVar != null && this.sV == 2) {
            a(aVar.videoDuration, this.sR.ta, true);
        }
    }

    public final boolean onBackPressed() {
        boolean fJ = this.qn.fJ();
        if (!this.qn.fw() || fJ) {
            return false;
        }
        com.kwad.components.ad.reward.a.eW().eX();
        this.qn.z(false);
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.components.ad.reward.m.e eVar;
        super.onUnbind();
        this.qn.c(this);
        com.kwad.components.core.playable.a aVar = this.qn.oK;
        if (aVar != null) {
            aVar.b(this);
        }
        a aVar2 = this.sR;
        if (aVar2 != null && (eVar = this.qn.oI) != null) {
            eVar.b(aVar2);
        }
        com.kwad.components.ad.reward.a.eW().b(this);
        com.kwad.components.core.webview.tachikoma.d.b.sS().b(this.gX);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        o oVar;
        q qVar;
        this.qn.z(true);
        if (this.sV == 1 && (qVar = this.sS) != null) {
            qVar.hz();
        } else if (this.sV == 2 && (oVar = this.sT) != null) {
            oVar.hide();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.aq.b
    public final void a(aq.a aVar) {
        a aVar2;
        boolean isSuccess = aVar.isSuccess();
        this.sQ = isSuccess;
        if (isSuccess && (aVar2 = this.sR) != null) {
            a(aVar2.videoDuration, this.sR.ta, false);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bH(dP)) {
            if (!this.qn.oY) {
                bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.r.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.this.hC();
                    }
                }, 100L);
            } else {
                com.kwad.components.core.webview.tachikoma.d.b.sS().a(bV());
            }
        } else if (!com.kwad.sdk.core.response.b.a.bK(dP)) {
            com.kwad.components.core.o.a.pX().av(this.qn.mAdTemplate);
        }
        this.qn.b(this);
        com.kwad.components.core.playable.a aVar = this.qn.oK;
        if (aVar != null) {
            aVar.a(this);
        }
        boolean gu = com.kwad.components.ad.reward.a.b.gu();
        this.sB = com.kwad.components.ad.reward.a.b.gt();
        if (gu) {
            a aVar2 = new a(this, (byte) 0);
            this.sR = aVar2;
            com.kwad.components.ad.reward.m.e eVar = this.qn.oI;
            if (eVar != null) {
                eVar.a(aVar2);
            }
        }
        com.kwad.components.ad.reward.a.eW().a(this);
    }
}
