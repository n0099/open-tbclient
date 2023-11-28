package com.kwad.components.ad.fullscreen.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.f.h;
import com.kwad.components.ad.reward.presenter.j;
import com.kwad.components.ad.reward.presenter.k;
import com.kwad.components.ad.reward.presenter.l;
import com.kwad.components.ad.reward.presenter.m;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.components.core.e.e.f;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.e.e;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ai;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements g, f {
    public com.kwad.components.ad.fullscreen.b gR;
    public ViewGroup gS;
    public com.kwad.components.core.l.b gT;
    @Nullable
    public r gU;
    public FrameLayout gV;
    public com.kwad.components.ad.reward.presenter.f.b gW;
    public e gX;
    @Nullable
    public com.kwad.components.ad.reward.presenter.e.a gY;
    public com.kwad.components.ad.reward.presenter.f.f gZ;
    public boolean ha = false;

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public b(com.kwad.components.core.l.b bVar, ViewGroup viewGroup, com.kwad.components.ad.fullscreen.b bVar2, com.kwad.components.ad.reward.g gVar) {
        this.gT = bVar;
        this.gR = bVar2;
        this.gS = viewGroup;
        this.qn = gVar;
        bP();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (this.ha) {
            return;
        }
        bVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.qn), true);
        this.ha = true;
    }

    public static boolean a(com.kwad.components.ad.reward.g gVar) {
        if (!d.AM()) {
            com.kwad.components.ad.reward.monitor.b.a(gVar.mAdTemplate, TKRenderFailReason.SWITCH_CLOSE);
            return false;
        } else if (com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.dP(gVar.mAdTemplate))) {
            return false;
        } else {
            AdMatrixInfo.FullScreenInfo db = com.kwad.sdk.core.response.b.b.db(gVar.mAdTemplate);
            if (db != null && db.renderType == 1) {
                return true;
            }
            com.kwad.components.ad.reward.monitor.b.a(gVar.mAdTemplate, TKRenderFailReason.TK_FILE_LOAD_ERROR);
            return false;
        }
    }

    private void bP() {
        if (this.gR == null) {
            return;
        }
        bU();
        AdInfo bH = this.gR.bH();
        boolean cT = com.kwad.sdk.core.response.b.a.cT(bH);
        boolean dS = com.kwad.sdk.core.response.b.b.dS(bH);
        if (cT) {
            this.qn.a(RewardRenderResult.LIVE_TK);
            com.kwad.components.core.webview.tachikoma.d.b.sS().a(bV());
            bR();
        } else if (dS) {
            com.kwad.components.core.webview.tachikoma.d.b.sS().a(bV());
            this.qn.a(RewardRenderResult.TK_IMAGE);
            bS();
        } else if (a(this.qn)) {
            this.qn.a(RewardRenderResult.FULLSCREEN_TK);
            bT();
            com.kwad.components.core.webview.tachikoma.d.b.sS().a(bV());
        } else {
            this.qn.a(RewardRenderResult.DEFAULT);
            bQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ() {
        boolean z;
        com.kwad.components.core.webview.tachikoma.d.b.sS().b(this.gX);
        com.kwad.components.core.e.e.g.oh().a(this);
        AdTemplate adTemplate = this.gR.getAdTemplate();
        AdInfo bH = this.gR.bH();
        if (this.gR.bI() && !ai.isOrientationPortrait()) {
            z = true;
        } else {
            z = false;
        }
        if (this.gR.gt) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.b.a.aP(bH)) {
            a(new com.kwad.components.ad.reward.presenter.d(), true);
        }
        a(new m(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        if (com.kwad.sdk.core.response.b.b.dd(bH)) {
            a(new h(), true);
        }
        if (!z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        if (com.kwad.sdk.core.response.b.b.df(adTemplate)) {
            a(new com.kwad.components.ad.fullscreen.c.a.f(), true);
        }
        if (com.kwad.sdk.core.response.b.a.bd(bH)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        a(new l(), true);
        if (com.kwad.sdk.core.response.b.a.cJ(bH)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new k(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
        }
        r rVar = new r(adTemplate, false, false);
        this.gU = rVar;
        a((Presenter) rVar, true);
        a(new c(), true);
        a(new a(), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, false), true);
        a(new com.kwad.components.ad.reward.presenter.e(bH, this.gS), true);
        a(new j(), true);
    }

    private void bR() {
        com.kwad.components.ad.fullscreen.c.c.c cVar = new com.kwad.components.ad.fullscreen.c.c.c();
        this.gW = cVar;
        a(cVar);
    }

    private void bS() {
        com.kwad.components.ad.fullscreen.c.c.a aVar = new com.kwad.components.ad.fullscreen.c.c.a();
        this.gZ = aVar;
        a(aVar);
    }

    private void bT() {
        a((Presenter) new com.kwad.components.ad.fullscreen.c.c.b(), true);
    }

    private void bU() {
        AdInfo bH = this.gR.bH();
        if (!this.gR.gt) {
            a(this);
        }
        if (com.kwad.sdk.core.response.b.b.dP(bH) && ai.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.gY = aVar;
            a((Presenter) aVar, true);
        }
    }

    private e bV() {
        if (this.gX == null) {
            this.gX = new e() { // from class: com.kwad.components.ad.fullscreen.c.b.1
                @Override // com.kwad.components.core.webview.tachikoma.e.b
                public final void q(String str) {
                    if (!"tk_fullscreen".equals(str) && !"tk_live_video".equals(str)) {
                        if ("tk_image_video".equals(str)) {
                            b bVar = b.this;
                            bVar.a(bVar);
                            b.this.qn.a(RewardRenderResult.DEFAULT);
                            b.this.bQ();
                            return;
                        }
                        return;
                    }
                    b bVar2 = b.this;
                    bVar2.a(bVar2);
                    com.kwad.components.ad.reward.g.a(b.this.getContext(), b.this.qn, b.this.bW());
                    b.this.bQ();
                }
            };
        }
        return this.gX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout bW() {
        if (this.gV == null) {
            this.gV = (FrameLayout) this.gS.findViewById(R.id.obfuscated_res_0x7f091475);
        }
        return this.gV;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qn.b(this);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void bL() {
        this.qn.C(true);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void dismiss() {
        this.qn.D(false);
        this.qn.ft();
    }

    public final boolean onBackPressed() {
        r rVar = this.gU;
        if (rVar != null && rVar.onBackPressed()) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.gY;
        if (aVar != null && aVar.gl() == BackPressHandleResult.HANDLED) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.gW;
        if (bVar != null && bVar.gl() == BackPressHandleResult.HANDLED) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gV = (FrameLayout) this.gS.findViewById(R.id.obfuscated_res_0x7f091475);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.c(this);
        com.kwad.components.core.e.e.g.oh().b(this);
        com.kwad.components.core.webview.tachikoma.d.b.sS().b(this.gX);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void show() {
        this.qn.fu();
        this.qn.D(true);
    }
}
