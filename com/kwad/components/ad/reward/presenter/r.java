package com.kwad.components.ad.reward.presenter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import com.baidu.tieba.R;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ag;
/* loaded from: classes10.dex */
public final class r extends a {
    public DetailVideoView mj;
    public ViewGroup rd;
    public FrameLayout re;
    public ImageView rf;
    public ViewGroup.LayoutParams rg = null;

    private void P(@LayoutRes int i) {
        this.re.addView(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.re, false), -1, -1);
    }

    private void hp() {
        int i;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate);
        boolean z = !ag.cB(getContext());
        boolean aY = com.kwad.sdk.core.response.a.a.aY(bQ);
        boolean z2 = com.kwad.sdk.core.response.a.a.bD(bQ) && com.kwad.components.ad.reward.kwai.b.gj();
        boolean z3 = com.kwad.components.ad.reward.k.o(this.nM.mAdTemplate) || com.kwad.components.ad.reward.k.p(this.nM.mAdTemplate) || aY || z2;
        if (!z || !z3) {
            this.rd.setVisibility(8);
            return;
        }
        this.rd.setVisibility(z2 ? 4 : 0);
        if (aY) {
            this.rf.setVisibility(8);
            i = R.layout.obfuscated_res_0x7f0d04bb;
        } else {
            i = R.layout.obfuscated_res_0x7f0d0474;
        }
        P(i);
        if (!com.kwad.sdk.core.response.a.a.ay(bQ)) {
            this.mj.updateTextureViewGravity(17);
        } else {
            this.mj.updateTextureViewGravity(21);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        ViewGroup.LayoutParams layoutParams = this.mj.getLayoutParams();
        if (layoutParams != null) {
            this.rg = new ViewGroup.LayoutParams(layoutParams);
        }
        hp();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mj = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f091421);
        this.rd = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091316);
        this.rf = (ImageView) findViewById(R.id.obfuscated_res_0x7f091317);
        this.re = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091318);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        if (this.rg == null || (detailVideoView = this.mj) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.LayoutParams layoutParams2 = this.rg;
            layoutParams.width = layoutParams2.width;
            layoutParams.height = layoutParams2.height;
            this.mj.setLayoutParams(layoutParams);
        }
        this.rg = null;
    }
}
