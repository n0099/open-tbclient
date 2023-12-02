package com.kwad.components.ad.reward.presenter.e;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public final class a extends g implements com.kwad.components.ad.reward.k.a {
    public AdMatrixInfo.PreLandingPageTKInfo vX;
    public aw vY;
    public boolean nW = false;
    public com.kwad.components.ad.reward.e.g vZ = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.e.a.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            c.d("TKPreFormPresenter", "handleToSkip PlayEndPageListener onPlayEndPageShow: " + a.this.qn.pc);
            if (!a.this.qn.pc) {
                a.this.iG();
            }
        }
    };

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_pre_landing_page";
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int hK() {
        return R.id.obfuscated_res_0x7f091402;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iG() {
        if (this.nW && this.vX != null) {
            c.d("TKPreFormPresenter", "handleToSkip handleToPlayEnd isPlayEndShow: " + this.vX.isPlayEndShow());
            if (this.vX.isPlayEndShow()) {
                S(true);
            }
        }
    }

    private void iH() {
        if (this.nW && this.vX != null) {
            c.d("TKPreFormPresenter", "handleToSkip mPreLandingPageData isSkipShow: " + this.vX.isSkipShow());
            if (this.vX.isSkipShow()) {
                S(true);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.vX = b.dh(this.qn.mAdTemplate);
        this.qn.b(this.vZ);
        this.qn.a((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        super.bF();
        c.d("TKPreFormPresenter", "onTkLoadSuccess");
        this.nW = true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return b.dy(this.qn.mAdTemplate);
    }

    public final BackPressHandleResult gl() {
        KSFrameLayout kSFrameLayout;
        if (this.wj != null && (kSFrameLayout = this.wC) != null) {
            if (kSFrameLayout.getVisibility() == 0) {
                return this.wj.gl();
            }
            return BackPressHandleResult.NOT_HANDLED;
        }
        return BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void iI() {
        c.d("TKPreFormPresenter", "onPlayComplete: ");
        iG();
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void iJ() {
        c.d("TKPreFormPresenter", "onSkipClick: ");
        iH();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.c(this.vZ);
        this.qn.b((com.kwad.components.ad.reward.k.a) this);
    }

    private void S(final boolean z) {
        c.d("TKPreFormPresenter", "switchPreForm: " + z);
        this.wC.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.e.a.2
            @Override // java.lang.Runnable
            public final void run() {
                int i;
                KSFrameLayout kSFrameLayout = a.this.wC;
                if (z) {
                    i = 0;
                } else {
                    i = 4;
                }
                kSFrameLayout.setVisibility(i);
                a.this.wC.setClickable(z);
                if (a.this.vY != null) {
                    if (z) {
                        a.this.vY.sg();
                        a.this.vY.sh();
                        return;
                    }
                    a.this.vY.si();
                    a.this.vY.sj();
                }
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final void a(FrameLayout frameLayout) {
        frameLayout.setVisibility(4);
        frameLayout.setClickable(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aI = com.kwad.sdk.d.a.a.aI(getContext());
        aVar.width = (int) ((bi.getScreenWidth(getContext()) / aI) + 0.5f);
        aVar.height = (int) ((bi.getScreenHeight(getContext()) / aI) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.vY = awVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        this.nW = false;
        c.d("TKPreFormPresenter", "onTkLoadFailed");
        S(false);
    }
}
