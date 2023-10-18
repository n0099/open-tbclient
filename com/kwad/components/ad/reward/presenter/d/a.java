package com.kwad.components.ad.reward.presenter.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.i.d;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.k.c;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.t;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements c.a, com.kwad.sdk.core.webview.a.kwai.a, com.kwad.sdk.widget.c {
    public com.kwad.components.ad.reward.i.kwai.a mL;
    public final h mRewardVerifyListener = new h() { // from class: com.kwad.components.ad.reward.presenter.d.a.1
        @Override // com.kwad.components.ad.reward.d.h
        public final void onRewardVerify() {
            if (a.this.ty != null) {
                a.this.ty.iP();
            }
            if (a.this.tz != null) {
                a.this.tz.iP();
            }
        }
    };
    @Nullable
    public t sV;
    @Nullable

    /* renamed from: tv  reason: collision with root package name */
    public ViewGroup f1213tv;
    public ViewGroup tw;
    public e tx;
    public c ty;
    @Nullable
    public c tz;

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        Context context;
        float f;
        if (!ag.cB(getContext())) {
            com.kwad.sdk.core.e.b.d("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.obfuscated_res_0x7f09138c)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f091383);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704fd));
        int size = com.kwad.sdk.core.response.a.c.bH(this.nM.mAdTemplate).size();
        kSFrameLayout.setRatio(0.0f);
        if (size == 0) {
            context = getContext();
            f = 136.0f;
        } else {
            context = getContext();
            f = 155.0f;
        }
        com.kwad.sdk.b.kwai.a.h(kSFrameLayout, com.kwad.sdk.b.kwai.a.a(context, f));
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091382);
        this.tw = viewGroup;
        viewGroup.setClickable(true);
        new f(this.tw, this);
        c cVar = new c(this.tw);
        this.ty = cVar;
        cVar.a(this);
        this.ty.c(this.nM.mAdTemplate, true);
        e eVar = new e((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091381), this.tw, null, this);
        this.tx = eVar;
        eVar.a(this.nM.mAdTemplate, adBaseFrameLayout);
    }

    private void c(View view2, boolean z) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091382 || id == R.id.obfuscated_res_0x7f091275) {
            d(z, 2);
        }
    }

    private void d(boolean z, int i) {
        this.nM.a(getContext(), z ? 1 : 153, i);
    }

    @Override // com.kwad.sdk.core.webview.a.kwai.a
    public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.sdk.core.e.b.d("LandPageOpenTaskPresenter", "onBind");
        if (k.p(this.nM.mAdTemplate)) {
            com.kwad.components.ad.reward.i.kwai.a iA = d.iA();
            this.mL = iA;
            this.nM.mL = iA;
            com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091403);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091275);
            this.f1213tv = viewGroup;
            if (viewGroup != null) {
                viewGroup.setClickable(true);
                this.f1213tv.setVisibility(8);
                new f(this.f1213tv, this);
                c cVar = new c(this.f1213tv);
                this.tz = cVar;
                cVar.a(this);
                this.tz.c(this.nM.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f091400)).setWidthBasedRatio(false);
                t tVar = new t((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0913ff), this.f1213tv, null, this);
                this.sV = tVar;
                tVar.a(this.nM.mAdTemplate, adBaseFrameLayout);
            }
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.components.ad.reward.k.c.a
    public final void c(boolean z, int i) {
        d(z, 1);
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        c(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        if (com.kwad.sdk.core.response.a.c.bF(this.nM.mAdTemplate)) {
            c(view2, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.b.d("LandPageOpenTaskPresenter", "onUnbind");
        e eVar = this.tx;
        if (eVar != null) {
            eVar.iR();
            this.tx = null;
        }
        c cVar = this.tz;
        if (cVar != null) {
            cVar.iO();
        }
        com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
        this.nM.mL = null;
    }
}
