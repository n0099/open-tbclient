package com.kwad.components.ad.reward.presenter.f;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.k.d;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.h;
import com.kwad.components.ad.reward.k.i;
import com.kwad.components.ad.reward.k.j;
import com.kwad.components.ad.reward.k.k;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.be;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.h;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.a.y;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.q;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.h;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class d extends com.kwad.components.ad.reward.presenter.b implements DialogInterface.OnDismissListener, com.kwad.components.ad.reward.k.a.e, y.a {
    public com.kwad.components.ad.reward.k.a.d wj;
    public p wk;
    public o wl;
    public i wm;
    public j wn;
    public com.kwad.components.core.webview.tachikoma.b.y wo;
    public boolean wp;
    public com.kwad.components.core.webview.tachikoma.a.h wq;
    @Nullable
    public e wr;
    public be.b ws = new be.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.1
        @Override // com.kwad.components.core.webview.jshandler.be.b
        public final void Q(int i) {
            com.kwad.sdk.core.report.j d = new com.kwad.sdk.core.report.j().cA(i).d(d.this.qn.mRootContainer.getTouchCoords());
            com.kwad.components.core.e.d.a.a(new a.C0644a(d.this.getContext()).aq(d.this.qn.mAdTemplate).b(d.this.qn.mApkDownloadHelper).ao(false));
            com.kwad.components.ad.reward.j.b.a(d.this.qn.mAdTemplate, d.this.iT(), (String) null, d, (JSONObject) null);
        }
    };
    public final h.a hq = new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.5
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (d.this.wl != null && !com.kwad.components.ad.reward.a.b.gq()) {
                m mVar = new m();
                mVar.aaa = true;
                d.this.wl.c(mVar);
            }
        }
    };
    public final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.f.d.6
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (d.this.wm != null) {
                com.kwad.components.core.webview.tachikoma.b.h hVar = new com.kwad.components.core.webview.tachikoma.b.h();
                hVar.ZV = 1;
                d.this.wm.a(hVar);
            }
        }
    };
    public final com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.7
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            if (d.this.wn != null) {
                bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.d.7.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.components.core.webview.tachikoma.b.o oVar = new com.kwad.components.core.webview.tachikoma.b.o();
                        oVar.scene = 1;
                        d.this.wn.a(oVar);
                        if (d.this.wq != null) {
                            d.this.wq.aU(d.this.qn.pz);
                        }
                    }
                }, 0L);
            }
        }
    };
    public final com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.f.d.8
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            d.this.hu();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.g(0.0d);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPreparing() {
            d.this.g(0.0d);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i, int i2) {
            d.this.iR();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            d.this.a(j, j2);
        }
    };

    public void a(WebCloseStatus webCloseStatus) {
    }

    public void bG() {
    }

    public boolean iK() {
        return false;
    }

    public d() {
        if (iK()) {
            this.wr = new e();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        this.wp = true;
        if (1 == 0) {
            return;
        }
        this.qn.a(this);
        if (this.wj == null) {
            this.wj = new com.kwad.components.ad.reward.k.a.d(this.qn, -1L, getContext());
        }
        if (this.wo == null) {
            this.wo = new com.kwad.components.core.webview.tachikoma.b.y();
        }
        this.wj.a(this.qn.getActivity(), this.qn.mAdResultData, this);
        e eVar = this.wr;
        if (eVar != null) {
            eVar.y(this.qn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (!this.wp) {
            return;
        }
        e eVar = this.wr;
        if (eVar != null) {
            eVar.z(this.qn);
        }
        this.qn.b(this);
        this.wj.jn();
        com.kwad.components.ad.reward.m.e eVar2 = this.qn.oI;
        if (eVar2 != null) {
            eVar2.b(this.gO);
            this.qn.oI.b(this.hq);
        }
        com.kwad.components.ad.reward.b.fa().b(this.mRewardVerifyListener);
        this.qn.c(this.mPlayEndPageListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(double d) {
        com.kwad.components.core.webview.tachikoma.b.y yVar = this.wo;
        yVar.aak = false;
        yVar.aag = false;
        yVar.nD = (int) ((d / 1000.0d) + 0.5d);
        iS();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.kwad.components.ad.reward.k.a.d dVar = this.wj;
        if (dVar != null && dVar.jl() != null) {
            this.wj.jl().gO();
        }
    }

    private void d(long j, long j2) {
        long min = Math.min(com.kwad.sdk.core.response.b.a.ag(this.qn.mAdTemplate.adInfoList.get(0)), j);
        if (j2 < min - 800) {
            this.qn.pr = (int) ((((float) (min - j2)) / 1000.0f) + 0.5f);
        }
    }

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.g gVar = this.qn;
        if (gVar != null) {
            gVar.b(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu() {
        if (this.qn.pc) {
            iR();
        } else {
            iQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iL() {
        com.kwad.components.ad.reward.g gVar = this.qn;
        com.kwad.sdk.core.report.a.b(gVar.mAdTemplate, 17, gVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM() {
        this.qn.x(iT());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iN() {
        com.kwad.components.ad.reward.j.b.a(this.qn.mAdTemplate, iT(), "endTopBar", new com.kwad.sdk.core.report.j().cA(39).d(this.qn.mRootContainer.getTouchCoords()), this.qn.mReportExtData);
        this.qn.oH.bJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iO() {
        com.kwad.components.ad.reward.j.b.a(this.qn.mAdTemplate, iT(), (String) null, new com.kwad.sdk.core.report.j().cA(40).d(this.qn.mRootContainer.getTouchCoords()), this.qn.mReportExtData);
        this.qn.oH.bJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iP() {
        com.kwad.components.ad.reward.j.b.a(this.qn.mAdTemplate, iT(), (String) null, new com.kwad.sdk.core.report.j().cA(41).d(this.qn.mRootContainer.getTouchCoords()), this.qn.mReportExtData);
        this.qn.oH.bJ();
    }

    private void iQ() {
        com.kwad.components.core.webview.tachikoma.b.y yVar = this.wo;
        yVar.aag = true;
        yVar.aak = false;
        yVar.nD = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate));
        iS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR() {
        com.kwad.components.core.webview.tachikoma.b.y yVar = this.wo;
        yVar.aak = true;
        yVar.aag = false;
        iS();
    }

    private void iS() {
        com.kwad.components.core.webview.tachikoma.b.y yVar;
        p pVar = this.wk;
        if (pVar != null && (yVar = this.wo) != null) {
            pVar.a(yVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iT() {
        com.kwad.components.ad.reward.k.a.d dVar = this.wj;
        if (dVar == null) {
            return null;
        }
        return dVar.getTkTemplateId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        this.qn.oH.onRewardVerify();
    }

    public void bF() {
        e eVar = this.wr;
        if (eVar != null) {
            eVar.bF();
        }
    }

    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.qn.mRootContainer;
    }

    public final void a(long j, long j2) {
        d(j, j2);
        g(j2);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0664a c0664a) {
        if (c0664a.VE.equals("adClickCallback")) {
            this.qn.oH.bJ();
        }
    }

    public void a(aw awVar) {
        e eVar = this.wr;
        if (eVar != null) {
            eVar.b(awVar);
        }
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.wr;
        if (eVar != null) {
            eVar.iX();
        }
    }

    public void a(o oVar) {
        this.wl = oVar;
        com.kwad.components.ad.reward.m.e eVar = this.qn.oI;
        if (eVar != null) {
            eVar.a(this.hq);
        }
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.d.4
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                if (!com.kwad.components.core.s.a.ah(d.this.getContext()).qJ() && d.this.qn.mVideoPlayConfig.isVideoSoundEnable()) {
                    z = false;
                } else {
                    z = true;
                }
                m mVar = new m();
                mVar.aaa = z;
                d.this.wl.c(mVar);
                if (d.this.qn.oI != null) {
                    d.this.qn.oI.setAudioEnabled(!z, false);
                }
            }
        });
    }

    public void a(p pVar) {
        this.wk = pVar;
        com.kwad.components.ad.reward.m.e eVar = this.qn.oI;
        if (eVar != null) {
            eVar.a(this.gO);
        }
    }

    public void a(m mVar) {
        com.kwad.components.ad.reward.m.e eVar = this.qn.oI;
        if (eVar != null) {
            eVar.setAudioEnabled(!mVar.aaa, true);
        }
    }

    public void a(t tVar) {
        com.kwad.components.ad.reward.presenter.f.a(this.qn, false);
    }

    public void a(com.kwad.sdk.components.p pVar, com.kwad.sdk.core.webview.b bVar) {
        int i;
        k kVar = new k();
        kVar.a(new k.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.9
            @Override // com.kwad.components.ad.reward.k.k.a
            public final void d(q qVar) {
                com.kwad.components.ad.reward.c.fd().c(qVar);
            }
        });
        pVar.c(kVar);
        long j = this.qn.pt;
        if (j > 0) {
            i = ((int) j) / 1000;
        } else {
            i = 0;
        }
        pVar.c(new com.kwad.components.ad.reward.k.g(i));
        i iVar = new i();
        this.wm = iVar;
        pVar.c(iVar);
        j jVar = new j();
        this.wn = jVar;
        pVar.c(jVar);
        com.kwad.components.ad.reward.b.fa().a(this.mRewardVerifyListener);
        this.qn.b(this.mPlayEndPageListener);
        pVar.c(new ai(new ai.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.10
            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(ai.a aVar) {
                d.this.getTKContainer().setVisibility(8);
            }
        }));
        com.kwad.components.ad.reward.k.d dVar = new com.kwad.components.ad.reward.k.d();
        dVar.a(new d.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.11
            @Override // com.kwad.components.ad.reward.k.d.a
            public final void a(final com.kwad.components.core.webview.tachikoma.b.p pVar2) {
                com.kwad.components.core.e.d.a.a(new a.C0644a(d.this.getContext()).aq(d.this.qn.mAdTemplate).b(d.this.qn.mApkDownloadHelper).an(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (!pVar2.aac) {
                            d.this.iO();
                        } else {
                            d.this.iN();
                        }
                    }
                }));
            }
        });
        pVar.c(dVar);
        com.kwad.components.ad.reward.k.e eVar = new com.kwad.components.ad.reward.k.e();
        eVar.a(new e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.12
            @Override // com.kwad.components.ad.reward.k.e.a
            public final void iU() {
                com.kwad.components.core.e.d.a.a(new a.C0644a(d.this.getContext()).aq(d.this.qn.mAdTemplate).b(d.this.qn.mApkDownloadHelper).an(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.12.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        d.this.iP();
                    }
                }));
            }
        });
        pVar.c(eVar);
        pVar.c(new com.kwad.components.ad.reward.k.h(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.13
            @Override // com.kwad.components.ad.reward.k.h.a
            public final void R(int i2) {
                if (com.kwad.components.ad.reward.g.G(d.this.qn.mAdTemplate)) {
                    if (com.kwad.components.ad.reward.g.E(d.this.qn.mAdTemplate) && d.this.qn.pp != null) {
                        if (!d.this.qn.pp.jz()) {
                            d.this.qn.pp.jy();
                        }
                    } else if (com.kwad.components.ad.reward.g.F(d.this.qn.mAdTemplate) && d.this.qn.pq != null && !d.this.qn.pq.jz()) {
                        d.this.qn.pq.jy();
                    }
                }
                if (d.this.qn.fI() != RewardRenderResult.DEFAULT) {
                    d.this.qn.pf = i2;
                }
                d.this.notifyRewardVerify();
            }
        }));
        pVar.c(new com.kwad.components.ad.reward.k.c() { // from class: com.kwad.components.ad.reward.presenter.f.d.14
            @Override // com.kwad.components.ad.reward.k.c
            public final void iV() {
                super.iV();
                d.this.iM();
            }
        });
        pVar.c(new com.kwad.components.ad.reward.k.f() { // from class: com.kwad.components.ad.reward.presenter.f.d.15
            @Override // com.kwad.components.ad.reward.k.f
            public final void U(boolean z) {
                super.U(z);
                com.kwad.components.ad.reward.presenter.f.t(d.this.qn);
            }
        });
        pVar.c(new com.kwad.components.ad.reward.k.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.16
            @Override // com.kwad.components.ad.reward.k.b
            public final void iV() {
                super.iV();
                d.this.iL();
            }
        });
        pVar.c(new com.kwad.components.core.webview.tachikoma.a.q() { // from class: com.kwad.components.ad.reward.presenter.f.d.2
            @Override // com.kwad.components.core.webview.tachikoma.a.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.s.j.e(d.this.getContext(), d.this.qn.mAdTemplate);
            }
        });
        pVar.c(new com.kwad.components.ad.reward.i.b(getContext(), this.qn.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        com.kwad.components.core.webview.tachikoma.a.h hVar = new com.kwad.components.core.webview.tachikoma.a.h();
        this.wq = hVar;
        hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.3
            @Override // com.kwad.components.core.webview.tachikoma.a.h.a
            public final void a(com.kwad.components.core.webview.tachikoma.a.h hVar2) {
                hVar2.aU(d.this.qn.pz);
            }
        });
        pVar.c(this.wq);
        pVar.c(new af());
        pVar.c(new be(bVar, this.qn.mApkDownloadHelper, this.ws));
        pVar.c(new y(this));
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.y.a
    public final void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo) {
        this.qn.mAdTemplate.tkLiveShopItemInfo = tKAdLiveShopItemInfo;
    }

    public void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        this.qn.oH.bJ();
    }
}
