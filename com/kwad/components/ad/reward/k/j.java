package com.kwad.components.ad.reward.k;

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
/* loaded from: classes8.dex */
public final class j extends d implements com.kwad.sdk.widget.c {
    public TextView eQ;
    public KSCornerImageView it;
    public TextView iu;
    public KsPriceView nI;
    public com.kwad.components.ad.reward.k nM;
    public TextView uO;
    public TextView uP;
    public View uQ;
    public ViewStub vk;
    public ViewGroup vl;
    public KsStyledTextButton vm;
    public KsStyledTextButton vn;

    public j(com.kwad.components.ad.reward.k kVar, ViewGroup viewGroup) {
        this.vl = viewGroup;
        this.nM = kVar;
    }

    public j(com.kwad.components.ad.reward.k kVar, ViewStub viewStub) {
        this.vk = viewStub;
        this.nM = kVar;
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) {
        KSImageLoader.loadAppIcon(this.it, aVar.eL(), adTemplate, 8);
        this.eQ.setText(aVar.getTitle());
        this.iu.setText(aVar.fO());
        int dimensionPixelSize = this.vl.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703cf);
        this.nI.getConfig().ab(dimensionPixelSize).ad(dimensionPixelSize).ac(this.vl.getResources().getColor(R.color.obfuscated_res_0x7f060612));
        this.nI.d(aVar.getPrice(), aVar.getOriginPrice(), true);
        String gy = aVar.gy();
        this.uQ.setVisibility(TextUtils.isEmpty(gy) ? 8 : 0);
        if (gy != null) {
            this.uO.setText(gy);
        }
        this.uP.setText(aVar.gz());
    }

    private void d(View view2, boolean z) {
        if (view2.equals(this.vn)) {
            this.nM.a(view2.getContext(), z ? 38 : 153, 1);
        } else if (view2.equals(this.vm)) {
            this.nM.a(view2.getContext(), z ? 37 : 153, 1);
        } else if (view2.equals(this.vl)) {
            this.nM.a(view2.getContext(), z ? 2 : 153, 2);
        }
    }

    private void initView() {
        ViewGroup viewGroup = this.vl;
        if (viewGroup == null) {
            return;
        }
        this.it = (KSCornerImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0912b2);
        this.eQ = (TextView) this.vl.findViewById(R.id.obfuscated_res_0x7f0912b4);
        this.iu = (TextView) this.vl.findViewById(R.id.obfuscated_res_0x7f0912b1);
        this.nI = (KsPriceView) this.vl.findViewById(R.id.obfuscated_res_0x7f0912b3);
        this.vm = (KsStyledTextButton) this.vl.findViewById(R.id.obfuscated_res_0x7f0912ae);
        this.vn = (KsStyledTextButton) this.vl.findViewById(R.id.obfuscated_res_0x7f0912ad);
        this.uO = (TextView) this.vl.findViewById(R.id.obfuscated_res_0x7f0912a1);
        this.uQ = this.vl.findViewById(R.id.obfuscated_res_0x7f0912a2);
        this.uP = (TextView) this.vl.findViewById(R.id.obfuscated_res_0x7f0912a3);
        new com.kwad.sdk.widget.f(this.vm, this);
        new com.kwad.sdk.widget.f(this.vn, this);
        new com.kwad.sdk.widget.f(this.vl, this);
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        super.a(uVar);
        a(uVar.getAdTemplate(), com.kwad.components.ad.reward.model.a.w(uVar.getAdTemplate()));
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        d(view2, true);
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        return this.vl;
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        if (com.kwad.sdk.core.response.a.c.bF(this.nM.mAdTemplate)) {
            d(view2, false);
        }
    }

    public final void hide() {
        ViewGroup viewGroup = this.vl;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final void show() {
        ViewStub viewStub;
        if (this.vl == null && (viewStub = this.vk) != null) {
            this.vl = (ViewGroup) viewStub.inflate();
            initView();
        }
        if (this.eQ == null) {
            initView();
        }
        ViewGroup viewGroup = this.vl;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }
}
