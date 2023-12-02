package com.kwad.components.ad.reward;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.t;
import com.kwad.components.ad.reward.presenter.u;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ai;
/* loaded from: classes10.dex */
public final class m extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.e.g, com.kwad.components.core.e.e.f {
    public ViewGroup gS;
    public com.kwad.components.core.l.b gT;
    @Nullable
    public r gU;
    public FrameLayout gV;
    public com.kwad.components.ad.reward.presenter.f.b gW;
    @Nullable
    public com.kwad.components.ad.reward.presenter.e.a gY;
    public com.kwad.components.ad.reward.presenter.f.f gZ;
    public boolean ha = false;
    public com.kwad.components.core.webview.tachikoma.e.e jR = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.reward.m.1
        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void q(String str) {
            if (!"tk_reward".equals(str) && !"tk_live_video".equals(str)) {
                if ("tk_image_video".equals(str)) {
                    m mVar = m.this;
                    mVar.a(mVar);
                    m.this.qn.a(RewardRenderResult.DEFAULT);
                    m mVar2 = m.this;
                    mVar2.a(mVar2.gT, m.this.mModel);
                    return;
                }
                return;
            }
            m mVar3 = m.this;
            mVar3.a(mVar3);
            g.a(m.this.getContext(), m.this.qn, m.this.bW());
            m.this.qn.a(RewardRenderResult.DEFAULT);
            m mVar4 = m.this;
            mVar4.a(mVar4.gT, m.this.mModel);
        }
    };
    public Context mContext;
    public com.kwad.components.ad.reward.model.c mModel;
    public g qn;
    @Nullable
    public a qo;

    /* loaded from: classes10.dex */
    public interface a {
        void onUnbind();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public m(com.kwad.components.core.l.b bVar, Context context, ViewGroup viewGroup, com.kwad.components.ad.reward.model.c cVar, g gVar) {
        boolean z;
        boolean z2 = false;
        this.mContext = context;
        this.gS = viewGroup;
        this.mModel = cVar;
        this.qn = gVar;
        this.gT = bVar;
        a(cVar);
        AdInfo bH = cVar.bH();
        boolean dS = com.kwad.sdk.core.response.b.b.dS(bH);
        if ((!com.kwad.sdk.core.response.b.a.cJ(bH) || !a(this.qn.mAdResultData.adGlobalConfigInfo)) && !com.kwad.sdk.core.response.b.a.bd(bH) && !g.G(cVar.getAdTemplate())) {
            z = false;
        } else {
            z = true;
        }
        if (com.kwad.sdk.core.response.b.a.cT(bH) && a(this.qn.mAdResultData.adGlobalConfigInfo)) {
            z2 = true;
        }
        com.kwad.sdk.core.e.c.d("RewardPresenter", "notFullTk: " + z + ", mLoadStrategy: " + this.qn.pA);
        if (z2) {
            com.kwad.components.core.webview.tachikoma.d.b.sS().a(this.jR);
            gVar.a(RewardRenderResult.LIVE_TK);
            bR();
        } else if (dS) {
            com.kwad.components.core.webview.tachikoma.d.b.sS().a(this.jR);
            gVar.a(RewardRenderResult.TK_IMAGE);
            bS();
        } else if (!z && this.qn.pA.equals(LoadStrategy.FULL_TK)) {
            com.kwad.components.core.webview.tachikoma.d.b.sS().a(this.jR);
            gVar.a(RewardRenderResult.NEO_TK);
            gk();
        } else {
            gVar.a(RewardRenderResult.DEFAULT);
            a(bVar, cVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (this.ha) {
            return;
        }
        mVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.qn), true);
        this.ha = true;
    }

    private void a(com.kwad.components.ad.reward.model.c cVar) {
        AdInfo bH = cVar.bH();
        if (!cVar.gt) {
            a(this);
        }
        if (g.g(bH)) {
            a(new com.kwad.components.ad.reward.presenter.g());
        }
        if (com.kwad.sdk.core.response.b.a.aO(bH) && ai.Kx()) {
            a(new com.kwad.components.ad.reward.presenter.h.a());
        }
        if (com.kwad.sdk.core.response.b.b.dd(bH)) {
            a(new com.kwad.components.ad.reward.presenter.f.h());
        }
        if (com.kwad.sdk.core.response.b.b.dP(bH) && ai.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.gY = aVar;
            a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.components.core.l.b bVar, com.kwad.components.ad.reward.model.c cVar) {
        boolean z;
        if (this.mModel == null) {
            return;
        }
        com.kwad.components.core.e.e.g.oh().a(this);
        AdInfo bH = this.mModel.bH();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        if (cVar.gt) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.b.a.aP(bH)) {
            a(new com.kwad.components.ad.reward.presenter.d(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.m(), true);
        a(new com.kwad.components.ad.reward.presenter.h(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.a.e(), true);
        boolean hg = cVar.hg();
        boolean hh = cVar.hh();
        if (cVar.bI() && !ai.isOrientationPortrait()) {
            z = true;
        } else {
            z = false;
        }
        if (!hg && !hh && !z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.n(), true);
        a(new com.kwad.components.ad.reward.presenter.c(bH), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, true), true);
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        a(new u(), true);
        a(new com.kwad.components.ad.reward.presenter.e(bH, this.gS), true);
        r rVar = new r(adTemplate);
        this.gU = rVar;
        a((Presenter) rVar, true);
        a(new com.kwad.components.ad.reward.presenter.l(), true);
        g gVar = this.qn;
        if (gVar.oX && com.kwad.components.ad.reward.d.a.b(gVar.mContext, com.kwad.sdk.core.response.b.e.dP(adTemplate))) {
            a(new com.kwad.components.ad.reward.presenter.a.a(), true);
        }
        if (com.kwad.sdk.core.response.b.b.dg(adTemplate)) {
            a(new t(), true);
        }
        if (com.kwad.sdk.core.response.b.a.bd(bH)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        if (com.kwad.sdk.core.response.b.a.cJ(bH)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new com.kwad.components.ad.reward.presenter.k(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.j(), true);
    }

    public static boolean a(AdGlobalConfigInfo adGlobalConfigInfo) {
        if (adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType != 1) {
            return true;
        }
        return false;
    }

    private void bR() {
        com.kwad.components.ad.reward.presenter.f.b bVar = new com.kwad.components.ad.reward.presenter.f.b();
        this.gW = bVar;
        a(bVar);
    }

    private void bS() {
        com.kwad.components.ad.reward.presenter.f.c cVar = new com.kwad.components.ad.reward.presenter.f.c();
        this.gZ = cVar;
        a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout bW() {
        if (this.gV == null) {
            this.gV = (FrameLayout) this.gS.findViewById(R.id.obfuscated_res_0x7f091476);
        }
        return this.gV;
    }

    private void gk() {
        com.kwad.components.ad.reward.presenter.f.f fVar = new com.kwad.components.ad.reward.presenter.f.f();
        this.gZ = fVar;
        a(fVar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qn.b(this);
        com.kwad.components.ad.reward.c.a.gJ().setCallerContext(this.qn);
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

    public final BackPressHandleResult gl() {
        r rVar = this.gU;
        if (rVar != null && rVar.onBackPressed()) {
            return BackPressHandleResult.HANDLED;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.gY;
        if (aVar != null) {
            BackPressHandleResult gl = aVar.gl();
            BackPressHandleResult backPressHandleResult = BackPressHandleResult.HANDLED;
            if (gl == backPressHandleResult) {
                return backPressHandleResult;
            }
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.gW;
        if (bVar != null) {
            return bVar.gl();
        }
        com.kwad.components.ad.reward.presenter.f.f fVar = this.gZ;
        if (fVar != null) {
            return fVar.gl();
        }
        return BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gV = (FrameLayout) this.gS.findViewById(R.id.obfuscated_res_0x7f091476);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.gT = null;
        com.kwad.components.core.webview.tachikoma.d.b.sS().b(this.jR);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.c(this);
        a aVar = this.qo;
        if (aVar != null) {
            aVar.onUnbind();
        }
        com.kwad.components.core.e.e.g.oh().b(this);
        com.kwad.components.ad.reward.c.a.gJ().reset();
    }

    @Override // com.kwad.components.core.e.e.f
    public final void show() {
        this.qn.fu();
        this.qn.D(true);
    }

    public final void a(@Nullable a aVar) {
        this.qo = aVar;
    }
}
