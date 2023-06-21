package com.kwad.components.ad.reward.presenter.b;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.k.t;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes9.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements p.a, com.kwad.sdk.core.webview.a.kwai.a {
    public KsAdWebView bF;
    public KSFrameLayout sT;
    public View sU;
    public t sV;
    public q sz;

    private void initView() {
        this.bF = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0913a3);
        this.sT = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f0913a4);
        this.sU = findViewById(R.id.obfuscated_res_0x7f0912f9);
    }

    @Override // com.kwad.sdk.core.webview.a.kwai.a
    public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        initView();
        boolean z = !ag.cB(getContext()) && d.cd(this.nM.mAdTemplate);
        b.d("PlayableHorizontalPresenter", "onBind enable: " + z);
        if (z) {
            this.sz.e((ViewGroup) getRootView());
            this.sz.b(u.D(this.nM.mAdTemplate));
            this.sT.setWidthBasedRatio(false);
            if (this.sV == null) {
                this.sV = new t(this.bF, this.sU, this.nM.mApkDownloadHelper, this);
            }
            this.sV.a(this.nM.mAdTemplate, (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0913a7));
        }
    }

    @Override // com.kwad.components.ad.reward.k.p.a
    public final void hs() {
    }

    @Override // com.kwad.components.ad.reward.k.p.a
    public final void ht() {
        com.kwad.components.ad.reward.b.eV().c(PlayableSource.ACTIONBAR_CLICK, new com.kwad.components.ad.reward.f.a(getContext()));
        com.kwad.sdk.core.report.a.r(this.nM.mAdTemplate, 67);
    }

    @Override // com.kwad.components.ad.reward.k.p.a
    public final void hu() {
        this.nM.a(getContext(), 1, 1);
    }

    @Override // com.kwad.components.ad.reward.k.p.a
    public final void hv() {
        this.nM.a(getContext(), 1, 2);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        q qVar = new q(-1);
        this.sz = qVar;
        qVar.a(this);
    }
}
