package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.br;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, br.a {
    public static final String[] vg = {"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
    public TextView hf;
    public br hh;
    public boolean hi;
    public long hj;
    public AdInfo mAdInfo;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public TextView vc;
    public ImageView vd;
    public View ve;
    public boolean vf = false;
    public boolean vh = false;
    public final l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (!a.this.hi) {
                a.this.hh.sendEmptyMessageDelayed(1, 500L);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            long a = g.a(j, a.this.mAdInfo);
            a.this.hj = j2;
            a.this.a(a, j2);
        }
    };
    public final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.2
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            a.a(a.this, true);
            a.this.vc.setText(a.vg[2]);
        }
    };

    private void ij() {
        com.kwad.components.ad.reward.e.d dVar = this.qn.mAdRewardStepListener;
        if (dVar != null) {
            dVar.ff();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", "playTopBar-style1", new j().d(this.qn.mRootContainer.getTouchCoords()).cA(41), this.qn.mReportExtData);
        this.qn.oH.bJ();
    }

    private void notifyRewardVerify() {
        this.qn.oH.onRewardVerify();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.hh = new br(this);
        ca();
        if (this.qn.oI.jK()) {
            x((int) (((float) com.kwad.sdk.core.response.b.a.ag(this.mAdInfo)) / 1000.0f));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hf = (TextView) findViewById(R.id.obfuscated_res_0x7f0914f1);
        this.vd = (ImageView) findViewById(R.id.obfuscated_res_0x7f09134a);
        this.vc = (TextView) findViewById(R.id.obfuscated_res_0x7f091423);
        this.ve = findViewById(R.id.obfuscated_res_0x7f091348);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.fa().b(this.mRewardVerifyListener);
        this.qn.oI.b(this.gO);
        this.vd.setVisibility(8);
        this.ve.setVisibility(8);
        this.vf = false;
        this.vh = false;
        this.hi = false;
    }

    private void x(int i) {
        this.qn.pr = i;
        if (g.G(this.mAdTemplate)) {
            if (!this.vh) {
                this.vc.setText(String.format(vg[0], Integer.valueOf(i)));
                return;
            }
            return;
        }
        this.hf.setText(String.valueOf(i));
    }

    private void a(long j, long j2, long j3) {
        com.kwad.components.ad.reward.l.a.a aVar;
        com.kwad.components.ad.reward.l.b.a aVar2;
        if (j < (j2 - 800) - j3) {
            int floor = (int) Math.floor(((float) (j2 - j)) / 1000.0f);
            x(floor);
            p pVar = this.qn.ph;
            if (pVar != null) {
                pVar.T(floor);
                return;
            }
            return;
        }
        this.qn.pd = true;
        if (g.G(this.mAdTemplate)) {
            if (g.E(this.mAdTemplate) && (aVar2 = this.qn.pp) != null) {
                if (!aVar2.jz()) {
                    this.qn.pp.jy();
                }
            } else if (g.F(this.mAdTemplate) && (aVar = this.qn.pq) != null && !aVar.jz()) {
                this.qn.pq.jy();
            }
            if (!this.vh) {
                this.vc.setText(vg[1]);
                ij();
                return;
            }
            return;
        }
        notifyRewardVerify();
        ii();
        p pVar2 = this.qn.ph;
        if (pVar2 != null) {
            pVar2.T(0);
        }
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.vh = true;
        return true;
    }

    private void ca() {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        this.mAdInfo = dP;
        this.mApkDownloadHelper = this.qn.mApkDownloadHelper;
        long a = g.a(com.kwad.sdk.core.response.b.a.M(dP), this.mAdInfo) / 1000;
        if (g.G(this.mAdTemplate)) {
            this.ve.setVisibility(0);
            this.ve.setOnClickListener(this);
            this.vc.setText(String.format(vg[0], Long.valueOf(a)));
            this.hf.setVisibility(8);
        } else {
            this.ve.setVisibility(8);
            this.hf.setText(String.valueOf(a));
            this.hf.setVisibility(0);
            this.hf.setAlpha(1.0f);
        }
        com.kwad.components.ad.reward.b.fa().a(this.mRewardVerifyListener);
        this.qn.oI.a(this.gO);
    }

    private void ii() {
        if (this.vf) {
            return;
        }
        this.vf = true;
        this.vd.setAlpha(0.0f);
        this.vd.setVisibility(0);
        this.vd.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.hf.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.hf.setAlpha(1.0f - floatValue);
                a.this.vd.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    public final void a(long j, long j2) {
        boolean z;
        int aK;
        int i = 0;
        if (com.kwad.sdk.core.response.b.a.aO(this.mAdInfo) && com.kwad.components.core.q.a.qu().qv() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            aK = com.kwad.sdk.core.response.b.a.aM(this.mAdInfo);
        } else {
            aK = com.kwad.sdk.core.response.b.a.aK(this.mAdInfo);
        }
        if (this.qn.pa) {
            i = 1000;
        }
        long j3 = aK * i;
        com.kwad.components.ad.reward.l.a(this.qn, j2, j, j3);
        a(j2, j, j3);
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (!this.qn.fK() && !this.qn.fJ()) {
                this.hj += 500;
                a(com.kwad.sdk.core.response.b.a.ag(this.mAdInfo), this.hj);
                this.hh.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.vd || view2 == this.ve) {
            com.kwad.components.core.e.d.a.a(new a.C0644a(view2.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(2).v(this.qn.oI.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.notifyAdClick();
                }
            }));
        }
    }
}
