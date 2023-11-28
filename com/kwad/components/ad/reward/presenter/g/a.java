package com.kwad.components.ad.reward.presenter.g;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.e;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.core.webview.d.a.a, com.kwad.sdk.widget.c {
    public final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.a.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (a.this.wL != null) {
                a.this.wL.jO();
            }
            if (a.this.wM != null) {
                a.this.wM.jO();
            }
        }
    };
    public com.kwad.components.ad.reward.l.a.a pq;
    @Nullable
    public ViewGroup wH;
    @Nullable
    public q wI;
    public ViewGroup wJ;
    public e wK;
    public c wL;
    @Nullable
    public c wM;

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("LandPageOpenTaskPresenter", "onUnbind");
        e eVar = this.wK;
        if (eVar != null) {
            eVar.jQ();
            this.wK = null;
        }
        c cVar = this.wM;
        if (cVar != null) {
            cVar.jN();
        }
        com.kwad.components.ad.reward.b.fa().b(this.mRewardVerifyListener);
        this.qn.pq = null;
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!ai.Kx()) {
            com.kwad.sdk.core.e.c.d("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.obfuscated_res_0x7f09141b)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f091412);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704fd));
        if (d.dG(this.qn.mAdTemplate).size() == 0) {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.d.a.a.m(kSFrameLayout, com.kwad.sdk.d.a.a.a(getContext(), 136.0f));
        } else {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.d.a.a.m(kSFrameLayout, com.kwad.sdk.d.a.a.a(getContext(), 155.0f));
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091411);
        this.wJ = viewGroup;
        viewGroup.setClickable(true);
        new f(this.wJ, this);
        c cVar = new c(this.wJ);
        this.wL = cVar;
        cVar.a(this);
        this.wL.c(this.qn.mAdTemplate, true);
        e eVar = new e((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091410), this.wJ, null, this);
        this.wK = eVar;
        eVar.a(this.qn.mAdTemplate, adBaseFrameLayout);
    }

    private void c(View view2, boolean z) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091411 || id == R.id.obfuscated_res_0x7f0912db) {
            e(z, 2);
        }
    }

    private void e(boolean z, int i) {
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 153;
        }
        this.qn.a(1, getContext(), i2, i);
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z, int i) {
        e(z, 1);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        c(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (d.dE(this.qn.mAdTemplate)) {
            c(view2, false);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.e.c.d("LandPageOpenTaskPresenter", "onBind");
        if (!g.F(this.qn.mAdTemplate)) {
            return;
        }
        com.kwad.components.ad.reward.l.a.a jx = com.kwad.components.ad.reward.l.d.jx();
        this.pq = jx;
        this.qn.pq = jx;
        com.kwad.components.ad.reward.b.fa().a(this.mRewardVerifyListener);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f09148f);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912db);
        this.wH = viewGroup;
        if (viewGroup != null) {
            viewGroup.setClickable(true);
            this.wH.setVisibility(8);
            new f(this.wH, this);
            c cVar = new c(this.wH);
            this.wM = cVar;
            cVar.a(this);
            this.wM.c(this.qn.mAdTemplate, false);
            ((KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f09148c)).setWidthBasedRatio(false);
            q qVar = new q((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09148b), this.wH, null, this);
            this.wI = qVar;
            qVar.a(this.qn.mAdTemplate, adBaseFrameLayout);
        }
        a(adBaseFrameLayout);
    }
}
