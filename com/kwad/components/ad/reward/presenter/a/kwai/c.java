package com.kwad.components.ad.reward.presenter.a.kwai;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.k.j;
import com.kwad.components.ad.reward.k.n;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.reward.o;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements x.b {
    @Nullable
    public com.kwad.components.ad.i.b bb;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public DetailVideoView mDetailVideoView;
    public n sA;
    public Drawable sD;
    public o.b sp;
    public TailFrameView sw;
    public boolean sx;
    public j sy;
    public q sz;
    public boolean qn = false;
    public int sB = Integer.MIN_VALUE;
    public int sC = Integer.MIN_VALUE;
    public final h mRewardVerifyListener = new h() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.1
        @Override // com.kwad.components.ad.reward.d.h
        public final void onRewardVerify() {
            if (c.this.sw == null || !k.q(c.this.mAdTemplate)) {
                return;
            }
            c.this.sw.iP();
        }
    };
    public e mPlayEndPageListener = new e() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.3
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            if (com.kwad.components.ad.reward.kwai.b.i(c.this.mAdInfo) || com.kwad.components.ad.reward.kwai.b.j(c.this.mAdInfo) || com.kwad.sdk.core.response.a.a.aK(c.this.mAdTemplate)) {
                k.a(c.this.nM, c.this.getActivity(), c.this.mAdTemplate, c.this.sp);
            } else if ((!com.kwad.sdk.core.response.a.d.ce(c.this.mAdTemplate) && c.this.qn && !c.this.nM.fA()) || c.this.nM.mF || c.this.nM.mJ) {
            } else {
                boolean z = com.kwad.sdk.core.response.a.b.bx(c.this.mAdTemplate) && com.kwad.components.ad.b.a.a(c.this.mAdTemplate.mPlayAgain) && c.this.nM.mRewardVerifyCalled && c.this.nM.ft() == 1;
                c.this.sx = true;
                com.kwad.sdk.core.e.b.d("RewardPlayEndNativeCardPresenter", "onPlayEndPageShow " + z);
                if (z) {
                    com.kwad.components.ad.i.b bVar = c.this.nM.mn;
                    if (bVar != null && bVar.ay()) {
                        c.this.nM.C(true);
                        c.this.sx = false;
                    }
                    c.this.hK();
                } else if (c.this.bb != null && c.this.bb.ay()) {
                    c.this.sx = false;
                }
                if (c.this.sx) {
                    if (c.this.nM.mm != null) {
                        com.kwad.components.ad.reward.monitor.a.a(c.this.nM.mz, "end_card", com.kwad.sdk.core.response.a.b.bb(c.this.mAdTemplate), System.currentTimeMillis() - c.this.nM.mm.getLoadTime());
                    }
                    c.this.W(z);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, z ? 2 : 153, this.nM.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
        this.nM.mAdOpenInteractionListener.bB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i) {
        ViewGroup.LayoutParams layoutParams = this.mDetailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            this.mDetailVideoView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(boolean z) {
        q qVar = this.sz;
        if (qVar != null) {
            qVar.show();
        } else if (z) {
            this.sA.show();
            this.sA.b(u.D(this.mAdTemplate));
            this.nM.C(true);
        } else if (!com.kwad.sdk.core.response.a.a.bF(this.mAdInfo)) {
            this.sw.a(new com.kwad.components.ad.reward.widget.tailframe.b() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.5
                @Override // com.kwad.components.ad.reward.widget.tailframe.b
                public final void R(boolean z2) {
                    c.this.P(z2);
                }
            });
            this.sw.setVisibility(0);
        } else {
            this.sy.show();
            this.sy.b(u.D(this.mAdTemplate));
            com.kwad.sdk.core.report.a.c(this.mAdTemplate, 19, (JSONObject) null);
        }
    }

    private void hJ() {
        boolean aY = com.kwad.sdk.core.response.a.a.aY(this.mAdInfo);
        boolean cc = com.kwad.sdk.core.response.a.d.cc(this.mAdTemplate);
        if (aY && cc) {
            q qVar = new q(R.id.obfuscated_res_0x7f09129e);
            this.sz = qVar;
            qVar.a(new p.a() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.2
                @Override // com.kwad.components.ad.reward.k.p.a
                public final void hs() {
                    new u.b().acd = 6;
                }

                @Override // com.kwad.components.ad.reward.k.p.a
                public final void ht() {
                    com.kwad.components.ad.reward.b.eV().c(PlayableSource.ENDCARD_CLICK, new com.kwad.components.ad.reward.f.a(c.this.getContext()));
                    com.kwad.sdk.core.report.a.a(c.this.nM.mAdTemplate, new f().aK(67).aP(6));
                }

                @Override // com.kwad.components.ad.reward.k.p.a
                public final void hu() {
                    c.this.nM.a(c.this.getContext(), 2, 1);
                }

                @Override // com.kwad.components.ad.reward.k.p.a
                public final void hv() {
                    c.this.nM.a(c.this.getContext(), 2, 2);
                }
            });
            this.sz.e((ViewGroup) getRootView());
            this.sz.b(com.kwad.components.ad.reward.k.u.D(this.nM.mAdTemplate));
            this.sz.a(this.mAdInfo, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hK() {
        this.mDetailVideoView.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.4
            @Override // java.lang.Runnable
            public final void run() {
                DetailVideoView detailVideoView;
                int i;
                if (c.this.mDetailVideoView == null || ag.cB(c.this.getContext())) {
                    return;
                }
                boolean ay = com.kwad.sdk.core.response.a.a.ay(c.this.mAdInfo);
                int screenWidth = com.kwad.sdk.b.kwai.a.getScreenWidth(c.this.getContext());
                c cVar = c.this;
                cVar.sB = cVar.mDetailVideoView.getLayoutParams().width;
                com.kwad.sdk.core.e.b.d("RewardPlayEndNativeCardPresenter", "setPlayAgainDetailView:  videoOriginalWidth :" + c.this.sB);
                c.this.Q(screenWidth / 2);
                c cVar2 = c.this;
                cVar2.sC = cVar2.mDetailVideoView.getTextureViewGravity();
                if (ay) {
                    detailVideoView = c.this.mDetailVideoView;
                    i = 21;
                } else {
                    detailVideoView = c.this.mDetailVideoView;
                    i = 17;
                }
                detailVideoView.updateTextureViewGravity(i);
                c cVar3 = c.this;
                cVar3.sD = cVar3.mDetailVideoView.getBackground();
                c.this.mDetailVideoView.setBackgroundColor(c.this.getContext().getResources().getColor(R.color.obfuscated_res_0x7f06061d));
                c.this.hL();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hL() {
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911e0);
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        com.kwad.components.ad.reward.presenter.b.a(imageView, com.kwad.sdk.core.response.a.a.K(this.mAdInfo));
    }

    private void hM() {
        if (this.sx) {
            this.sw.destroy();
            this.sw.setVisibility(8);
            this.sy.hide();
            this.sA.hide();
        }
    }

    private boolean hN() {
        AdInfo.AdMaterialInfo.MaterialFeature au = com.kwad.sdk.core.response.a.a.au(this.mAdInfo);
        return au.height > au.width;
    }

    @Override // com.kwad.components.core.webview.jshandler.x.b
    public final void a(x.a aVar) {
        this.qn = aVar.isSuccess();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.core.playable.a aVar = this.nM.mk;
        if (aVar != null) {
            aVar.a(this);
        }
        AdTemplate adTemplate = this.nM.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        k kVar = this.nM;
        this.bb = kVar.mm;
        kVar.a(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
        this.sw.setCallerContext(this.nM);
        this.sw.a(getContext(), this.nM.mScreenOrientation == 0, hN());
        ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f0912a4);
        this.sy = viewStub != null ? new j(this.nM, viewStub) : new j(this.nM, (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912e6));
        ViewStub viewStub2 = (ViewStub) findViewById(R.id.obfuscated_res_0x7f0912a5);
        this.sA = viewStub2 != null ? new n(this.mAdTemplate, this.nM, viewStub2, this.mDetailVideoView) : new n(this.mAdTemplate, this.nM, (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091285), this.mDetailVideoView);
        hJ();
    }

    public final void b(o.b bVar) {
        this.sp = bVar;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sw = (TailFrameView) findViewById(R.id.obfuscated_res_0x7f09139b);
        DetailVideoView detailVideoView = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f091397);
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView.getLayoutTransition() != null) {
            this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.nM.mk;
        if (aVar != null) {
            aVar.b(this);
        }
        com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
        hM();
        this.nM.b(this.mPlayEndPageListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            int i = this.sC;
            if (i != Integer.MIN_VALUE) {
                detailVideoView.updateTextureViewGravity(i);
            }
            com.kwad.sdk.core.e.b.d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.sB);
            int i2 = this.sB;
            if (i2 != Integer.MIN_VALUE) {
                Q(i2);
            }
            Drawable drawable = this.sD;
            if (drawable != null) {
                this.mDetailVideoView.setBackground(drawable);
            }
        }
        n nVar = this.sA;
        if (nVar != null) {
            nVar.bt();
        }
    }
}
