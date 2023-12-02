package com.kwad.components.ad.reward.presenter.g;

import android.text.TextUtils;
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
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.b.a, com.kwad.sdk.core.webview.d.a.a, com.kwad.sdk.widget.c {
    public static float wO = 0.4548105f;
    public AdInfo mAdInfo;
    public com.kwad.components.ad.reward.l.b.a pp;
    @Nullable
    public ViewGroup wH;
    @Nullable
    public q wI;
    public ViewGroup wJ;
    public e wK;
    public c wL;
    @Nullable
    public c wM;
    public int wP = 15;
    public long wQ = -1;
    public boolean wR = false;
    public final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.b.3
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (b.this.wL != null && g.G(b.this.qn.mAdTemplate)) {
                b.this.wL.jO();
            }
            if (b.this.wM != null) {
                b.this.wM.jO();
            }
        }
    };
    public com.kwad.sdk.core.c.c wS = new d() { // from class: com.kwad.components.ad.reward.presenter.g.b.4
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            b.this.W(false);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            b.this.W(true);
        }
    };

    @Override // com.kwad.sdk.b.a
    public final void O(String str) {
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    private boolean jb() {
        com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.wQ);
        if (this.wQ < 0 || System.currentTimeMillis() - this.wQ <= this.wP * 1000) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(boolean z) {
        com.kwad.components.ad.reward.l.b.a aVar;
        com.kwad.components.ad.reward.l.b.a.a(this.pp, getContext(), this.qn.mAdTemplate);
        if (this.pp.jE()) {
            if (z) {
                boolean jb = jb();
                if (jb && (aVar = this.pp) != null) {
                    aVar.jD();
                    com.kwad.components.ad.reward.b.fa().notifyRewardVerify();
                    this.qn.oH.onRewardVerify();
                }
                X(jb);
                return;
            }
            this.wQ = System.currentTimeMillis();
        } else if (z) {
            X(false);
        }
    }

    private void X(boolean z) {
        String str;
        com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.wR + " completed: " + z);
        if (this.wR) {
            return;
        }
        if (z) {
            str = "恭喜！任务达标啦，成功获取奖励~";
        } else {
            str = "哎呀，差一点就达标啦，再试一次~";
        }
        v.c(getContext(), str, 0);
        if (z) {
            this.wR = true;
        }
    }

    private void Y(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 153;
        }
        this.qn.a(1, getContext(), i, 1);
    }

    @Override // com.kwad.sdk.b.a
    public final void N(String str) {
        if (!TextUtils.equals(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo), str)) {
            return;
        }
        g gVar = this.qn;
        if (gVar.pp != null && g.E(gVar.mAdTemplate)) {
            this.qn.pp.jB();
            com.kwad.sdk.core.c.b.Ct();
            if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
                this.wQ = System.currentTimeMillis();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z, int i) {
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 153;
        }
        this.qn.b(1, getContext(), i2, 1);
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!ai.Kx()) {
            com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.obfuscated_res_0x7f09141c)).inflate();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091412);
        this.wJ = viewGroup;
        viewGroup.setClickable(true);
        new f(this.wJ, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f091413);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704fe));
        final float dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704f8);
        kSFrameLayout.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.g.b.1
            @Override // java.lang.Runnable
            public final void run() {
                kSFrameLayout.getHeight();
            }
        });
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091412);
        this.wJ = viewGroup2;
        c cVar = new c(viewGroup2);
        this.wL = cVar;
        cVar.a(this.qn.mApkDownloadHelper);
        this.wL.a(this);
        this.wL.c(this.qn.mAdTemplate, false);
        e eVar = new e((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091411), this.wJ, this.qn.mApkDownloadHelper, this);
        this.wK = eVar;
        eVar.a(new com.kwad.components.ad.reward.n.f() { // from class: com.kwad.components.ad.reward.presenter.g.b.2
            @Override // com.kwad.components.ad.reward.n.f
            public final void j(String str, int i) {
                int i2 = com.kwad.sdk.core.response.b.e.dP(b.this.qn.mAdTemplate).status;
                com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + i2);
                b.this.wL.k(str, i);
            }
        });
        this.wK.a(this.qn.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        Y(true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (com.kwad.sdk.core.response.b.d.dE(this.qn.mAdTemplate)) {
            Y(false);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "onBind");
        if (!g.E(this.qn.mAdTemplate)) {
            return;
        }
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate);
        this.wP = com.kwad.components.ad.reward.a.b.gp();
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.a(this.wS);
        com.kwad.components.ad.reward.b.fa().a(this.mRewardVerifyListener);
        com.kwad.components.ad.reward.l.b.a jw = com.kwad.components.ad.reward.l.d.jw();
        this.pp = jw;
        this.qn.pp = jw;
        com.kwad.components.ad.reward.l.b.a.a(jw, getContext(), this.qn.mAdTemplate);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091490);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912dc);
        this.wH = viewGroup;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            c cVar = new c(this.wH);
            this.wM = cVar;
            cVar.a(this.qn.mApkDownloadHelper);
            this.wM.a(this);
            this.wM.c(this.qn.mAdTemplate, false);
            ((KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f09148d)).setWidthBasedRatio(false);
            q qVar = new q((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09148c), this.wH, this.qn.mApkDownloadHelper, this);
            this.wI = qVar;
            qVar.a(this.qn.mAdTemplate, adBaseFrameLayout);
        }
        com.kwad.sdk.b.b.zt().a(this);
        a(adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.b(this.wS);
        com.kwad.components.ad.reward.b.fa().b(this.mRewardVerifyListener);
        com.kwad.sdk.b.b.zt().b(this);
        e eVar = this.wK;
        if (eVar != null) {
            eVar.jQ();
            this.wK = null;
        }
        c cVar = this.wM;
        if (cVar != null) {
            cVar.jN();
        }
        this.qn.pp = null;
    }
}
