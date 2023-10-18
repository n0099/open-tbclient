package com.kwad.components.ad.reward.presenter.c;

import android.content.DialogInterface;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h.c;
import com.kwad.components.ad.reward.h.d;
import com.kwad.components.ad.reward.h.f;
import com.kwad.components.ad.reward.h.g;
import com.kwad.components.ad.reward.h.h;
import com.kwad.components.ad.reward.h.j;
import com.kwad.components.ad.reward.h.kwai.e;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.b.a.g;
import com.kwad.components.core.webview.b.a.k;
import com.kwad.components.core.webview.b.a.m;
import com.kwad.components.core.webview.b.a.n;
import com.kwad.components.core.webview.b.a.q;
import com.kwad.components.core.webview.b.a.s;
import com.kwad.components.core.webview.b.kwai.i;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
/* loaded from: classes10.dex */
public abstract class a extends com.kwad.components.ad.reward.presenter.a implements DialogInterface.OnDismissListener, e {
    public com.kwad.components.ad.reward.j.a eF;
    public com.kwad.components.ad.reward.h.kwai.d sW;
    public j sX;
    public i sY;
    public h sZ;
    public com.kwad.components.ad.reward.h.i ta;
    public s tb;
    public boolean tc;
    public final h.a dv = new h.a() { // from class: com.kwad.components.ad.reward.presenter.c.a.4
        @Override // com.kwad.sdk.utils.h.a
        public final void bk() {
            if (a.this.sY != null) {
                com.kwad.components.core.webview.b.a.i iVar = new com.kwad.components.core.webview.b.a.i();
                iVar.NR = true;
                a.this.sY.c(iVar);
            }
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void bl() {
        }
    };
    public final com.kwad.components.ad.reward.d.h mRewardVerifyListener = new com.kwad.components.ad.reward.d.h() { // from class: com.kwad.components.ad.reward.presenter.c.a.5
        @Override // com.kwad.components.ad.reward.d.h
        public final void onRewardVerify() {
            if (a.this.sZ != null) {
                g gVar = new g();
                gVar.NO = 1;
                a.this.sZ.a(gVar);
            }
        }
    };
    public final com.kwad.components.ad.reward.d.e mPlayEndPageListener = new com.kwad.components.ad.reward.d.e() { // from class: com.kwad.components.ad.reward.presenter.c.a.6
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            if (a.this.ta != null) {
                bd.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.6.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        k kVar = new k();
                        kVar.NS = 1;
                        a.this.ta.a(kVar);
                    }
                }, 0L);
            }
        }
    };
    public final com.kwad.components.core.video.h td = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.reward.presenter.c.a.7
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayCompleted() {
            if (a.this.nM.mC) {
                a.this.ib();
            } else {
                a.this.ia();
            }
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayError(int i, int i2) {
            a.this.ib();
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            a.this.b(j, j2);
            a.this.d(j2);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayStart() {
            a.this.d(0.0d);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPreparing() {
            a.this.d(0.0d);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2) {
        long min = Math.min(com.kwad.sdk.core.response.a.a.T(this.nM.mAdTemplate.adInfoList.get(0)), j);
        if (j2 < min - 800) {
            this.nM.mM = (int) ((((float) (min - j2)) / 1000.0f) + 0.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(double d) {
        s sVar = this.tb;
        sVar.NZ = false;
        sVar.Oa = false;
        sVar.kD = (int) ((d / 1000.0d) + 0.5d);
        ic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hV() {
        com.kwad.components.ad.reward.k kVar = this.nM;
        com.kwad.sdk.core.report.a.c(kVar.mAdTemplate, 17, kVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hW() {
        com.kwad.components.ad.reward.k kVar = this.nM;
        com.kwad.sdk.core.report.a.c(kVar.mAdTemplate, 18, kVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hX() {
        com.kwad.components.ad.reward.k kVar = this.nM;
        com.kwad.sdk.core.report.a.a(kVar.mAdTemplate, 39, kVar.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
        this.nM.mAdOpenInteractionListener.bB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hY() {
        com.kwad.components.ad.reward.k kVar = this.nM;
        com.kwad.sdk.core.report.a.a(kVar.mAdTemplate, 40, kVar.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
        this.nM.mAdOpenInteractionListener.bB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hZ() {
        com.kwad.components.ad.reward.k kVar = this.nM;
        com.kwad.sdk.core.report.a.a(kVar.mAdTemplate, 41, kVar.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
        this.nM.mAdOpenInteractionListener.bB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia() {
        s sVar = this.tb;
        sVar.Oa = true;
        sVar.NZ = false;
        sVar.kD = com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate));
        ic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ib() {
        s sVar = this.tb;
        sVar.NZ = true;
        sVar.Oa = false;
        ic();
    }

    private void ic() {
        s sVar;
        j jVar = this.sX;
        if (jVar == null || (sVar = this.tb) == null) {
            return;
        }
        jVar.a(sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        this.nM.mAdOpenInteractionListener.onRewardVerify();
    }

    public final void a(com.kwad.components.ad.reward.b.b bVar) {
        com.kwad.components.ad.reward.k kVar = this.nM;
        if (kVar != null) {
            kVar.b(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(q qVar) {
        com.kwad.components.ad.reward.k kVar = this.nM;
        com.kwad.components.ad.reward.presenter.e.a(kVar, false, (e.a) kVar.fC());
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(i iVar) {
        this.sY = iVar;
        this.eF.a(this.dv);
        bd.runOnUiThreadDelay(com.kwad.components.core.m.b.at(getContext()).ov() ? new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.2
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.webview.b.a.i iVar2 = new com.kwad.components.core.webview.b.a.i();
                iVar2.NR = true;
                a.this.sY.c(iVar2);
            }
        } : new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.webview.b.a.i iVar2 = new com.kwad.components.core.webview.b.a.i();
                iVar2.NR = !a.this.nM.mVideoPlayConfig.isVideoSoundEnable();
                a.this.sY.c(iVar2);
            }
        }, 0L);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(j jVar) {
        this.sX = jVar;
        this.eF.a(this.td);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(aa aaVar) {
    }

    @Override // com.kwad.components.core.webview.b.e
    public void a(com.kwad.sdk.components.h hVar, com.kwad.sdk.core.webview.b bVar) {
        com.kwad.components.ad.reward.h.j jVar = new com.kwad.components.ad.reward.h.j();
        jVar.a(new j.a() { // from class: com.kwad.components.ad.reward.presenter.c.a.1
            @Override // com.kwad.components.ad.reward.h.j.a
            public final void d(n nVar) {
                com.kwad.components.ad.reward.d.fc().c(nVar);
            }
        });
        hVar.c(jVar);
        long j = this.nM.mO;
        hVar.c(new f(j > 0 ? ((int) j) / 1000 : 0));
        com.kwad.components.ad.reward.h.h hVar2 = new com.kwad.components.ad.reward.h.h();
        this.sZ = hVar2;
        hVar.c(hVar2);
        com.kwad.components.ad.reward.h.i iVar = new com.kwad.components.ad.reward.h.i();
        this.ta = iVar;
        hVar.c(iVar);
        com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
        this.nM.a(this.mPlayEndPageListener);
        hVar.c(new com.kwad.components.core.webview.jshandler.q(new q.b() { // from class: com.kwad.components.ad.reward.presenter.c.a.8
            @Override // com.kwad.components.core.webview.jshandler.q.b
            public final void a(q.a aVar) {
                a.this.ca().setVisibility(8);
            }
        }));
        com.kwad.components.ad.reward.h.c cVar = new com.kwad.components.ad.reward.h.c();
        cVar.a(new c.a() { // from class: com.kwad.components.ad.reward.presenter.c.a.9
            @Override // com.kwad.components.ad.reward.h.c.a
            public final void a(final m mVar) {
                com.kwad.components.core.c.a.a.a(new a.C0619a(a.this.getContext()).L(a.this.nM.mAdTemplate).b(a.this.nM.mApkDownloadHelper).ae(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.c.a.9.1
                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        if (mVar.NU) {
                            a.this.hX();
                        } else {
                            a.this.hY();
                        }
                    }
                }));
            }
        });
        hVar.c(cVar);
        com.kwad.components.ad.reward.h.d dVar = new com.kwad.components.ad.reward.h.d();
        dVar.a(new d.a() { // from class: com.kwad.components.ad.reward.presenter.c.a.10
            @Override // com.kwad.components.ad.reward.h.d.a
            public final void id() {
                com.kwad.components.core.c.a.a.a(new a.C0619a(a.this.getContext()).L(a.this.nM.mAdTemplate).b(a.this.nM.mApkDownloadHelper).ae(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.c.a.10.1
                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        a.this.hZ();
                    }
                }));
            }
        });
        hVar.c(dVar);
        hVar.c(new com.kwad.components.ad.reward.h.g(new g.a() { // from class: com.kwad.components.ad.reward.presenter.c.a.11
            @Override // com.kwad.components.ad.reward.h.g.a
            public final void id() {
                if (com.kwad.components.ad.reward.k.q(a.this.nM.mAdTemplate)) {
                    if (!com.kwad.components.ad.reward.k.o(a.this.nM.mAdTemplate) || a.this.nM.mK == null) {
                        if (com.kwad.components.ad.reward.k.p(a.this.nM.mAdTemplate) && a.this.nM.mL != null && !a.this.nM.mL.iC()) {
                            a.this.nM.mL.iB();
                        }
                    } else if (!a.this.nM.mK.iC()) {
                        a.this.nM.mK.iB();
                    }
                }
                a.this.notifyRewardVerify();
            }
        }));
        hVar.c(new com.kwad.components.ad.reward.h.b() { // from class: com.kwad.components.ad.reward.presenter.c.a.12
            @Override // com.kwad.components.ad.reward.h.b
            public final void ie() {
                super.ie();
                a.this.hW();
            }
        });
        hVar.c(new com.kwad.components.ad.reward.h.e() { // from class: com.kwad.components.ad.reward.presenter.c.a.13
            @Override // com.kwad.components.ad.reward.h.e
            public final void ie() {
                super.ie();
                com.kwad.components.ad.reward.presenter.e.b(a.this.nM, a.this.nM.fC());
            }
        });
        hVar.c(new com.kwad.components.ad.reward.h.a() { // from class: com.kwad.components.ad.reward.presenter.c.a.14
            @Override // com.kwad.components.ad.reward.h.a
            public final void ie() {
                super.ie();
                a.this.hV();
            }
        });
        hVar.c(new com.kwad.components.ad.reward.f.b(getContext(), this.nM.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public void aq() {
        super.aq();
        boolean cc = cc();
        this.tc = cc;
        if (cc) {
            this.nM.a(this);
            if (this.sW == null) {
                this.sW = new com.kwad.components.ad.reward.h.kwai.d(this.nM, -1L, getContext());
            }
            if (this.tb == null) {
                this.tb = new s();
            }
            com.kwad.components.ad.reward.k kVar = this.nM;
            this.eF = kVar.eF;
            this.sW.a(kVar.getActivity(), this.nM.mAdTemplate, this);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(com.kwad.components.core.webview.b.a.i iVar) {
        com.kwad.components.ad.reward.j.a aVar = this.eF;
        if (aVar != null) {
            aVar.c(!iVar.NR, true);
        }
    }

    public abstract boolean cc();

    @Override // com.kwad.components.core.webview.b.e
    public final com.kwad.sdk.widget.e dD() {
        return this.nM.mRootContainer;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dE() {
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dF() {
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dI() {
    }

    @Override // com.kwad.components.core.webview.b.e
    public final com.kwad.sdk.core.webview.a.kwai.a getClickListener() {
        return new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.c.a.15
            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
                a.this.nM.mAdOpenInteractionListener.bB();
            }
        };
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.kwad.components.ad.reward.h.kwai.d dVar = this.sW;
        if (dVar == null || dVar.iq() == null) {
            return;
        }
        this.sW.iq().gu();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (this.tc) {
            this.nM.b(this);
            this.sW.pF();
            this.eF.b(this.td);
            this.eF.b(this.dv);
            com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
            this.nM.b(this.mPlayEndPageListener);
        }
    }
}
