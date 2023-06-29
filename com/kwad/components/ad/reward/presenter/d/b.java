package com.kwad.components.ad.reward.presenter.d;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.k.c;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.t;
import com.kwad.components.core.m.f;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes9.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements c.a, f.a, com.kwad.sdk.core.webview.a.kwai.a, com.kwad.sdk.widget.c {
    public static float tB = 0.4548105f;
    public com.kwad.components.ad.reward.i.a.a mK;
    public f pJ;
    @Nullable
    public t sV;
    @Nullable

    /* renamed from: tv  reason: collision with root package name */
    public ViewGroup f1219tv;
    public ViewGroup tw;
    public e tx;
    public c ty;
    @Nullable
    public c tz;
    public int tC = 15;
    public long tD = -1;
    public boolean tE = false;
    public final h mRewardVerifyListener = new h() { // from class: com.kwad.components.ad.reward.presenter.d.b.3
        @Override // com.kwad.components.ad.reward.d.h
        public final void onRewardVerify() {
            if (b.this.ty != null && k.q(b.this.nM.mAdTemplate)) {
                b.this.ty.iP();
            }
            if (b.this.tz != null) {
                b.this.tz.iP();
            }
        }
    };
    public com.kwad.sdk.core.c.c tF = new d() { // from class: com.kwad.components.ad.reward.presenter.d.b.4
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            b.this.X(false);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            b.this.X(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void X(boolean z) {
        com.kwad.components.ad.reward.i.a.a aVar;
        com.kwad.components.ad.reward.i.a.a.a(this.mK, getContext(), this.nM.mAdTemplate);
        if (!this.mK.iI()) {
            if (z) {
                Y(false);
            }
        } else if (!z) {
            this.tD = System.currentTimeMillis();
        } else {
            boolean ij = ij();
            if (ij && (aVar = this.mK) != null) {
                aVar.iH();
                com.kwad.components.ad.reward.c.eZ().notifyRewardVerify();
                this.nM.mAdOpenInteractionListener.onRewardVerify();
            }
            Y(ij);
        }
    }

    private void Y(boolean z) {
        com.kwad.sdk.core.e.b.d("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.tE + " completed: " + z);
        if (this.tE) {
            return;
        }
        com.kwad.sdk.utils.t.d(getContext(), z ? "恭喜！任务达标啦，成功获取奖励~" : "哎呀，差一点就达标啦，再试一次~", 0);
        if (z) {
            this.tE = true;
        }
    }

    private void Z(boolean z) {
        this.nM.a(getContext(), z ? 1 : 153, 1);
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        if (!ag.cB(getContext())) {
            com.kwad.sdk.core.e.b.d("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.obfuscated_res_0x7f091340)).inflate();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091336);
        this.tw = viewGroup;
        viewGroup.setClickable(true);
        new com.kwad.sdk.widget.f(this.tw, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f091337);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704f5));
        final float dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704f0);
        kSFrameLayout.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.d.b.1
            @Override // java.lang.Runnable
            public final void run() {
                kSFrameLayout.getHeight();
            }
        });
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091336);
        this.tw = viewGroup2;
        c cVar = new c(viewGroup2);
        this.ty = cVar;
        cVar.a(this.nM.mApkDownloadHelper);
        this.ty.a(this);
        this.ty.c(this.nM.mAdTemplate, false);
        e eVar = new e((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091335), this.tw, this.nM.mApkDownloadHelper, this);
        this.tx = eVar;
        eVar.a(new com.kwad.components.ad.reward.k.f() { // from class: com.kwad.components.ad.reward.presenter.d.b.2
            @Override // com.kwad.components.ad.reward.k.f
            public final void h(String str, int i) {
                int i2 = com.kwad.sdk.core.response.a.d.bQ(b.this.nM.mAdTemplate).status;
                com.kwad.sdk.core.e.b.d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + i2);
                b.this.ty.i(str, i);
            }
        });
        this.tx.a(this.nM.mAdTemplate, adBaseFrameLayout);
    }

    private boolean ij() {
        com.kwad.sdk.core.e.b.d("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.tD);
        return this.tD >= 0 && System.currentTimeMillis() - this.tD > ((long) (this.tC * 1000));
    }

    @Override // com.kwad.sdk.core.webview.a.kwai.a
    public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.sdk.core.e.b.d("LaunchAppTaskPresenter", "onBind");
        AdTemplate adTemplate = this.nM.mAdTemplate;
        if (com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(com.kwad.sdk.core.response.a.d.bQ(adTemplate)))) {
            this.tC = com.kwad.components.ad.reward.kwai.b.fX();
            com.kwad.sdk.core.c.b.tp();
            com.kwad.sdk.core.c.b.a(this.tF);
            com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
            com.kwad.components.ad.reward.i.a.a iz = com.kwad.components.ad.reward.i.d.iz();
            this.mK = iz;
            this.nM.mK = iz;
            com.kwad.components.ad.reward.i.a.a.a(iz, getContext(), this.nM.mAdTemplate);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0913b7);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091229);
            this.f1219tv = viewGroup;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                c cVar = new c(this.f1219tv);
                this.tz = cVar;
                cVar.a(this.nM.mApkDownloadHelper);
                this.tz.a(this);
                this.tz.c(this.nM.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f0913b4)).setWidthBasedRatio(false);
                t tVar = new t((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0913b3), this.f1219tv, this.nM.mApkDownloadHelper, this);
                this.sV = tVar;
                tVar.a(this.nM.mAdTemplate, adBaseFrameLayout);
            }
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate);
            f fVar = this.pJ;
            if (fVar == null) {
                this.pJ = new f(com.kwad.sdk.core.response.a.a.ag(bQ));
            } else {
                fVar.aw(com.kwad.sdk.core.response.a.a.ag(bQ));
            }
            this.pJ.a(getContext(), this);
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.components.ad.reward.k.c.a
    public final void c(boolean z, int i) {
        this.nM.b(getContext(), z ? 1 : 153, 1);
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        Z(true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        if (com.kwad.sdk.core.response.a.c.bF(this.nM.mAdTemplate)) {
            Z(false);
        }
    }

    @Override // com.kwad.components.core.m.f.a
    public final void gW() {
        k kVar = this.nM;
        if (kVar.mK == null || !k.o(kVar.mAdTemplate)) {
            return;
        }
        this.nM.mK.iF();
        com.kwad.sdk.core.c.b.tp();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            return;
        }
        this.tD = System.currentTimeMillis();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.b.d("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.core.c.b.tp();
        com.kwad.sdk.core.c.b.b(this.tF);
        com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
        f fVar = this.pJ;
        if (fVar != null) {
            fVar.au(getContext());
        }
        e eVar = this.tx;
        if (eVar != null) {
            eVar.iR();
            this.tx = null;
        }
        c cVar = this.tz;
        if (cVar != null) {
            cVar.iO();
        }
        this.nM.mK = null;
    }
}
