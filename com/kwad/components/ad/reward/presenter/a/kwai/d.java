package com.kwad.components.ad.reward.presenter.a.kwai;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.i.b;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.m;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements b.a {
    public FrameLayout bS;
    public com.kwad.components.ad.i.b bb;
    public DetailVideoView mDetailVideoView;
    public com.kwad.components.ad.i.b mn;
    @Nullable
    public FrameLayout sF;
    public int qC = Integer.MIN_VALUE;
    public final h mRewardVerifyListener = new h() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.d.1
        @Override // com.kwad.components.ad.reward.d.h
        public final void onRewardVerify() {
            if (d.this.bb == null || !k.q(d.this.nM.mAdTemplate)) {
                return;
            }
            d.this.bb.af(true);
        }
    };
    public com.kwad.sdk.core.webview.a.kwai.a bJ = new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.d.2
        @Override // com.kwad.sdk.core.webview.a.kwai.a
        public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
            d.this.nM.mAdOpenInteractionListener.bB();
        }
    };

    private void hO() {
        FrameLayout frameLayout;
        com.kwad.components.ad.i.b bVar;
        AdTemplate adTemplate = this.nM.mAdTemplate;
        if (!com.kwad.sdk.core.response.a.b.bx(adTemplate) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.b.bz(adTemplate)) || (frameLayout = this.sF) == null || (bVar = this.mn) == null) {
            return;
        }
        k kVar = this.nM;
        bVar.a(frameLayout, kVar.mRootContainer, adTemplate, kVar.mApkDownloadHelper, kVar.mScreenOrientation);
        this.mn.a((b.InterfaceC0608b) null);
        ViewGroup.LayoutParams layoutParams = this.sF.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            if (ag.cB(getContext())) {
                marginLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e1);
            } else {
                marginLayoutParams.bottomMargin = 0;
                int screenWidth = com.kwad.sdk.b.kwai.a.getScreenWidth(getContext()) / 2;
                marginLayoutParams.width = screenWidth;
                marginLayoutParams.height = -1;
                marginLayoutParams.rightMargin = -screenWidth;
            }
            this.sF.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.kwad.components.ad.i.b.a
    public final void a(com.kwad.components.ad.i.b bVar) {
        Animator a;
        if (bVar.equals(this.mn)) {
            if (ag.cB(getContext())) {
                this.qC = com.kwad.sdk.b.kwai.a.A(this.mDetailVideoView);
                com.kwad.sdk.b.kwai.a.i(this.mDetailVideoView, 49);
                a = r.a(this.nM.mAdTemplate, this.mn.kW(), this.mDetailVideoView);
            } else {
                a = r.a(this.nM.mAdTemplate, this.mDetailVideoView, this.mn.kW());
            }
            if (a != null) {
                a.start();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        k kVar = this.nM;
        AdTemplate adTemplate = kVar.mAdTemplate;
        m mVar = kVar.mm;
        this.bb = mVar;
        if (mVar == null) {
            return;
        }
        com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
        this.bb.a(this.bJ);
        com.kwad.components.ad.i.b bVar = this.bb;
        FrameLayout frameLayout = this.bS;
        k kVar2 = this.nM;
        bVar.a(frameLayout, kVar2.mRootContainer, adTemplate, kVar2.mApkDownloadHelper, kVar2.mScreenOrientation);
        this.bb.a((b.InterfaceC0608b) null);
        com.kwad.components.ad.i.b bVar2 = this.nM.mn;
        this.mn = bVar2;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        hO();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bS = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091431);
        this.sF = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091312);
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f091421);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        int i;
        super.onUnbind();
        com.kwad.components.ad.i.b bVar = this.bb;
        if (bVar != null) {
            bVar.kV();
            this.bb.bt();
        }
        com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
        com.kwad.components.ad.i.b bVar2 = this.mn;
        if (bVar2 != null) {
            bVar2.kV();
            this.mn.bt();
            this.mn.a((b.a) null);
        }
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView == null || (i = this.qC) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.b.kwai.a.i(detailVideoView, i);
    }
}
