package com.kwad.components.ad.reward.presenter.d.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.k;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements aq.b {
    @Nullable
    public com.kwad.components.ad.k.b ci;
    public AdInfo mAdInfo;
    public DetailVideoView mDetailVideoView;
    public TailFrameView vB;
    public volatile boolean vC;
    public boolean vD;
    public k vE;
    public Drawable vH;
    public boolean sQ = false;
    public int vF = Integer.MIN_VALUE;
    public int vG = Integer.MIN_VALUE;
    public final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            b.this.iu();
            if (b.this.vB != null && g.G(b.this.mAdTemplate)) {
                b.this.vB.jO();
            }
        }
    };
    public com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.2
        @Override // com.kwad.components.ad.reward.e.a, com.kwad.components.ad.reward.e.g
        public final int getPriority() {
            return -1;
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            if ((!e.ec(b.this.mAdTemplate) && b.this.sQ && !b.this.qn.fG()) || b.this.qn.pi || b.this.qn.po) {
                return;
            }
            b.this.vD = true;
            if (b.this.ci != null && b.this.ci.ar()) {
                b.this.vD = false;
            }
            b.this.qn.pz = true ^ b.this.vD;
            if (b.this.vD) {
                if (b.this.qn.oM != null) {
                    com.kwad.components.ad.reward.monitor.c.a(b.this.qn.mAdTemplate, b.this.qn.oX, "end_card", com.kwad.sdk.core.response.b.b.cx(b.this.mAdTemplate), System.currentTimeMillis() - b.this.qn.oM.getLoadTime(), 1);
                }
                b.this.aI();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aI() {
        iu();
        this.vB.a(new com.kwad.components.ad.reward.widget.tailframe.b() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.3
            @Override // com.kwad.components.ad.reward.widget.tailframe.b
            public final void N(boolean z) {
                b.this.K(z);
            }
        });
        this.vB.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iu() {
        if (this.vC) {
            return;
        }
        iv();
    }

    private void iv() {
        boolean z;
        com.kwad.sdk.core.e.c.d("RewardPlayEndNativeCardPresenter", "initTailView");
        TailFrameView tailFrameView = this.vB;
        Context context = getContext();
        if (this.qn.mScreenOrientation == 0) {
            z = true;
        } else {
            z = false;
        }
        tailFrameView.a(context, z, ix());
        this.vC = true;
    }

    private void iw() {
        if (this.vD) {
            iu();
            this.vB.destroy();
            this.vB.setVisibility(8);
            this.vE.hide();
        }
    }

    private boolean ix() {
        AdInfo.AdMaterialInfo.MaterialFeature aX = com.kwad.sdk.core.response.b.a.aX(this.mAdInfo);
        if (aX.height > aX.width) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vB = (TailFrameView) findViewById(R.id.obfuscated_res_0x7f091503);
        DetailVideoView detailVideoView = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f0914ff);
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView.getLayoutTransition() != null) {
            this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z) {
        int i;
        if (z) {
            i = 2;
        } else {
            i = 153;
        }
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", (String) null, new j().d(this.qn.mRootContainer.getTouchCoords()).cA(i), this.qn.mReportExtData);
        this.qn.oH.bJ();
    }

    private void P(int i) {
        ViewGroup.LayoutParams layoutParams = this.mDetailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            this.mDetailVideoView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.aq.b
    public final void a(aq.a aVar) {
        this.sQ = aVar.isSuccess();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.core.playable.a aVar = this.qn.oK;
        if (aVar != null) {
            aVar.a(this);
        }
        this.mAdInfo = e.dP(this.mAdTemplate);
        g gVar = this.qn;
        this.ci = gVar.oM;
        gVar.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.fa().a(this.mRewardVerifyListener);
        this.vB.setCallerContext(this.qn);
        ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f091400);
        if (viewStub != null) {
            this.vE = new k(this.qn, viewStub);
            return;
        }
        this.vE = new k(this.qn, (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091437));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.qn.oK;
        if (aVar != null) {
            aVar.b(this);
        }
        com.kwad.components.ad.reward.b.fa().b(this.mRewardVerifyListener);
        iw();
        this.qn.c(this.mPlayEndPageListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            int i = this.vG;
            if (i != Integer.MIN_VALUE) {
                detailVideoView.updateTextureViewGravity(i);
            }
            com.kwad.sdk.core.e.c.d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.vF);
            int i2 = this.vF;
            if (i2 != Integer.MIN_VALUE) {
                P(i2);
            }
            Drawable drawable = this.vH;
            if (drawable != null) {
                this.mDetailVideoView.setBackground(drawable);
            }
        }
    }
}
