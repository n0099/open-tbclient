package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import com.baidu.tieba.R;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;
/* loaded from: classes10.dex */
public final class v extends b {
    public ViewGroup tA;
    public FrameLayout tB;
    public ImageView tC;
    public DetailVideoView tz;
    public ViewGroup.LayoutParams tD = null;
    public com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.v.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            v.this.tz.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.v.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    v.this.tz.setVisibility(0);
                }
            }, 200L);
        }
    };

    private void hI() {
        if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        hI();
        ViewGroup.LayoutParams layoutParams = this.tz.getLayoutParams();
        if (layoutParams != null) {
            this.tD = new ViewGroup.LayoutParams(layoutParams);
        }
        this.qn.oI.a(this.gO);
        hJ();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.tz = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f0914ff);
        this.tA = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0913e8);
        this.tC = (ImageView) findViewById(R.id.obfuscated_res_0x7f0913e9);
        this.tB = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0913ea);
    }

    private void O(@LayoutRes int i) {
        this.tB.addView(com.kwad.sdk.m.l.a(getContext(), i, this.tB, false), -1, -1);
    }

    private void hJ() {
        boolean z;
        boolean z2;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate);
        getContext();
        boolean z3 = !ai.Kx();
        boolean bH = com.kwad.sdk.core.response.b.a.bH(dP);
        int i = 0;
        if (com.kwad.sdk.core.response.b.a.cB(dP) && com.kwad.components.ad.reward.a.b.gA()) {
            z = true;
        } else {
            z = false;
        }
        if (!com.kwad.components.ad.reward.g.E(this.qn.mAdTemplate) && !com.kwad.components.ad.reward.g.F(this.qn.mAdTemplate) && !bH && !z) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z3 && z2) {
            ViewGroup viewGroup = this.tA;
            if (z) {
                i = 4;
            }
            viewGroup.setVisibility(i);
            if (bH) {
                this.tC.setVisibility(8);
                O(R.layout.obfuscated_res_0x7f0d04f4);
            } else {
                O(R.layout.obfuscated_res_0x7f0d04a0);
            }
            if (!com.kwad.sdk.core.response.b.a.aY(dP)) {
                this.tz.updateTextureViewGravity(17);
                return;
            } else {
                this.tz.updateTextureViewGravity(21);
                return;
            }
        }
        this.tA.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        this.qn.oI.b(this.gO);
        if (this.tD != null && (detailVideoView = this.tz) != null) {
            ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.LayoutParams layoutParams2 = this.tD;
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
                this.tz.setLayoutParams(layoutParams);
            }
            DetailVideoView detailVideoView2 = this.tz;
            if (detailVideoView2 != null) {
                detailVideoView2.setVisibility(4);
            }
            this.tD = null;
        }
    }
}
