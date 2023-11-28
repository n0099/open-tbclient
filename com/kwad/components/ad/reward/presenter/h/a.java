package com.kwad.components.ad.reward.presenter.h;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.a.d;
import com.kwad.components.ad.reward.m.e;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.ad.reward.presenter.i;
import com.kwad.components.core.l.a.b;
import com.kwad.components.core.proxy.c;
import com.kwad.components.core.video.l;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.v;
import com.kwad.components.core.webview.tachikoma.f;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class a extends g implements j {
    public AdInfo mAdInfo;
    public boolean tI;
    public boolean tJ;
    public boolean wW;
    public f wX;
    public long wY;
    public d wj;
    public g.b tK = new g.b() { // from class: com.kwad.components.ad.reward.presenter.h.a.1
        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            if (a.this.wC != null && a.this.wC.getVisibility() == 0) {
                return true;
            }
            return false;
        }
    };
    public final com.kwad.components.core.l.a.a sm = new b() { // from class: com.kwad.components.ad.reward.presenter.h.a.2
        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void d(c cVar) {
            super.d(cVar);
            a.this.wW = true;
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void c(c cVar) {
            a.this.wW = false;
            if (a.this.wX == null) {
                return;
            }
            v vVar = new v();
            if (com.kwad.components.core.q.a.qu().qA()) {
                com.kwad.components.core.q.a.qu().aL(false);
                if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 0) {
                    vVar.aah = 1;
                    a.this.wX.b(vVar);
                } else if (com.kwad.components.core.q.a.qu().qw()) {
                    vVar.aah = 1;
                    a.this.wX.b(vVar);
                } else {
                    vVar.aah = 0;
                    a.this.wX.b(vVar);
                }
            } else if (com.kwad.components.core.q.a.qu().qy() && com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                if (com.kwad.components.core.q.a.qu().qz() == 1) {
                    if (ak.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                        vVar.aah = 2;
                        com.kwad.components.core.q.a.qu().aE(2);
                        a.this.wX.b(vVar);
                        return;
                    }
                    vVar.aah = 0;
                    a.this.wX.b(vVar);
                } else if (com.kwad.components.core.q.a.qu().qz() == 3) {
                    vVar.aah = 1;
                    com.kwad.components.core.q.a.qu().aE(0);
                    a.this.wX.b(vVar);
                }
            }
        }
    };
    public final l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.h.a.3
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            long a = com.kwad.components.ad.reward.g.a(j, a.this.mAdInfo);
            long aM = com.kwad.sdk.core.response.b.a.aM(a.this.mAdInfo) * 1000;
            if (j2 <= a.this.wY || a - j2 <= aM || a.this.tI) {
                return;
            }
            if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                if (ak.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                    return;
                }
            } else if (a.this.qn.fP) {
                return;
            }
            a.b(a.this, true);
            a.this.wj.a(a.this.qn.getActivity(), a.this.qn.mAdResultData, a.this);
            a.this.jc();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_reward_task_card";
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int hK() {
        return R.id.obfuscated_res_0x7f0913a0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jc() {
        this.wC.setVisibility(0);
        e eVar = this.qn.oI;
        if (eVar != null) {
            eVar.pause();
        }
        this.tJ = true;
    }

    private f jd() {
        return new f() { // from class: com.kwad.components.ad.reward.presenter.h.a.5
            @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
            }
        };
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dp(this.qn.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.qn.mRootContainer;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.tI = true;
        return true;
    }

    private void hu() {
        boolean x = i.x(this.qn);
        com.kwad.sdk.core.e.c.d("jky", "onPlayCompleted: " + x);
        if (x) {
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.h.a.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.qn.oH != null) {
                        a.this.qn.oH.onRewardVerify();
                    }
                    a.this.qn.oI.pause();
                    a.this.qn.fA();
                }
            }, 200L);
            return;
        }
        com.kwad.components.ad.reward.e.b bVar = this.qn.oH;
        if (bVar != null) {
            bVar.onRewardVerify();
        }
        this.qn.oI.pause();
        this.qn.fA();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        e eVar = this.qn.oI;
        if (eVar != null) {
            eVar.b(this.gO);
        }
        this.qn.b(this.tK);
        this.qn.Mm.remove(this.sm);
        this.wj.jn();
        this.wj = null;
        this.wC.setVisibility(8);
        com.kwad.components.core.q.a.qu().clear();
        this.tI = false;
        this.tJ = false;
        this.wW = false;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.e.c.d("TkRewardVideoTaskPresenter", "onTkLoadFailed: ");
        this.wC.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aI = com.kwad.sdk.d.a.a.aI(getContext());
        aVar.width = (int) ((bi.getScreenWidth(getContext()) / aI) + 0.5f);
        aVar.height = (int) ((bi.getScreenHeight(getContext()) / aI) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        boolean z;
        com.kwad.components.ad.reward.g gVar = this.qn;
        boolean z2 = false;
        if (webCloseStatus != null && webCloseStatus.interactSuccess) {
            z = true;
        } else {
            z = false;
        }
        gVar.pa = z;
        int qv = com.kwad.components.core.q.a.qu().qv();
        com.kwad.components.ad.reward.g gVar2 = this.qn;
        e eVar = gVar2.oI;
        if (eVar != null) {
            if (gVar2.pa) {
                eVar.jH();
                if (qv == 1) {
                    hu();
                    z2 = true;
                }
            }
            if (this.tJ && !this.wW && !z2) {
                this.qn.oI.resume();
            }
        }
        this.wC.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.components.p pVar, com.kwad.sdk.core.webview.b bVar) {
        f jd = jd();
        this.wX = jd;
        pVar.c(jd);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        this.qn.oH.bJ();
        com.kwad.sdk.core.e.c.d("jky", "onAdClicked convertPageType: " + aVar.aDH);
        if (com.kwad.sdk.core.response.b.a.aO(this.mAdInfo)) {
            com.kwad.components.core.q.a.qu().aD(aVar.aDH);
            if (aVar.aDH == -1) {
                com.kwad.components.core.q.a.qu().aL(false);
                com.kwad.components.core.q.a.qu().aE(0);
            } else if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
                if (com.kwad.components.core.q.a.qu().qz() == 2) {
                    com.kwad.components.core.q.a.qu().aE(3);
                } else {
                    com.kwad.components.core.q.a.qu().aE(1);
                }
            } else {
                com.kwad.components.core.q.a.qu().aL(true);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        getContext();
        if (!ai.Kx()) {
            return;
        }
        this.wW = false;
        com.kwad.sdk.core.e.c.d("TkRewardVideoTaskPresenter", "onBind: ");
        if (this.wj == null) {
            this.wj = new d(this.qn, -1L, getContext(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.presenter.h.a.4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.wX == null) {
                        return;
                    }
                    v vVar = new v();
                    if (com.kwad.components.core.q.a.qu().qA()) {
                        com.kwad.components.core.q.a.qu().aL(false);
                        if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 0) {
                            vVar.aah = 1;
                            a.this.wX.b(vVar);
                        } else if (com.kwad.components.core.q.a.qu().qw()) {
                            vVar.aah = 1;
                            a.this.wX.b(vVar);
                        } else {
                            vVar.aah = 0;
                            a.this.wX.b(vVar);
                        }
                    } else if (com.kwad.components.core.q.a.qu().qy() && com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                        if (com.kwad.components.core.q.a.qu().qz() == 1) {
                            if (!ak.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                                vVar.aah = 0;
                                a.this.wX.b(vVar);
                            }
                        } else if (com.kwad.components.core.q.a.qu().qz() == 3) {
                            vVar.aah = 1;
                            com.kwad.components.core.q.a.qu().aE(0);
                            a.this.wX.b(vVar);
                        }
                    }
                }
            });
        }
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate);
        this.mAdInfo = dP;
        this.wY = com.kwad.sdk.core.response.b.a.aL(dP) * 1000;
        e eVar = this.qn.oI;
        if (eVar != null) {
            eVar.a(this.gO);
        }
        this.qn.a(this.tK);
        this.qn.Mm.add(this.sm);
    }
}
