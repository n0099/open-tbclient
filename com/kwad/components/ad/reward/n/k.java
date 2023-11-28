package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class k extends d implements com.kwad.sdk.widget.c {
    public TextView hz;
    public KSCornerImageView lu;
    public TextView lv;
    public com.kwad.components.ad.reward.g qn;
    public KsPriceView yG;
    public TextView yJ;
    public TextView yK;
    public View yL;
    public ViewStub ze;
    public ViewGroup zf;
    public KsStyledTextButton zg;
    public KsStyledTextButton zh;

    public k(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup) {
        this.zf = viewGroup;
        this.qn = gVar;
    }

    public k(com.kwad.components.ad.reward.g gVar, ViewStub viewStub) {
        this.ze = viewStub;
        this.qn = gVar;
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) {
        int i = 8;
        KSImageLoader.loadAppIcon(this.lu, aVar.gd(), adTemplate, 8);
        this.hz.setText(aVar.getTitle());
        this.lv.setText(aVar.ge());
        int dimensionPixelSize = this.zf.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070525);
        this.yG.getConfig().ae(dimensionPixelSize).ag(dimensionPixelSize).af(this.zf.getResources().getColor(R.color.obfuscated_res_0x7f0607a0));
        this.yG.d(aVar.getPrice(), aVar.getOriginPrice(), true);
        String gU = aVar.gU();
        View view2 = this.yL;
        if (!TextUtils.isEmpty(gU)) {
            i = 0;
        }
        view2.setVisibility(i);
        if (gU != null) {
            this.yJ.setText(gU);
        }
        this.yK.setText(aVar.gV());
    }

    private void d(View view2, boolean z) {
        int i = 153;
        if (view2.equals(this.zh)) {
            com.kwad.components.ad.reward.g gVar = this.qn;
            Context context = view2.getContext();
            if (z) {
                i = 38;
            }
            gVar.a(2, context, i, 1);
        } else if (view2.equals(this.zg)) {
            com.kwad.components.ad.reward.g gVar2 = this.qn;
            Context context2 = view2.getContext();
            if (z) {
                i = 37;
            }
            gVar2.a(2, context2, i, 1);
        } else if (view2.equals(this.zf)) {
            com.kwad.components.ad.reward.g gVar3 = this.qn;
            Context context3 = view2.getContext();
            if (z) {
                i = 2;
            }
            gVar3.a(2, context3, i, 2);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        d(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (com.kwad.sdk.core.response.b.d.dE(this.qn.mAdTemplate)) {
            d(view2, false);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(rVar.getAdTemplate(), com.kwad.components.ad.reward.model.a.I(rVar.getAdTemplate()));
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gD() {
        return this.zf;
    }

    public final void hide() {
        ViewGroup viewGroup = this.zf;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }
}
