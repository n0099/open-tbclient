package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.d.e;
import com.kwad.sdk.reward.d.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KsAuthorIconView;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes7.dex */
public class c extends g implements View.OnClickListener, RewardActionBarControl.a {

    /* renamed from: b  reason: collision with root package name */
    public KsAuthorIconView f41053b;

    /* renamed from: c  reason: collision with root package name */
    public KsLogoView f41054c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f41055d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.reward.d.d f41056e;

    /* renamed from: f  reason: collision with root package name */
    public int f41057f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout.LayoutParams f41058g;

    public c(ViewGroup viewGroup) {
        this.f41055d = viewGroup;
    }

    public static FrameLayout.LayoutParams a(Context context, AdInfo adInfo, KsLogoView ksLogoView, int i) {
        FrameLayout.LayoutParams layoutParams = null;
        if (ksLogoView != null && context != null) {
            ViewGroup.LayoutParams layoutParams2 = ksLogoView.getLayoutParams();
            if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams = a(layoutParams3);
            boolean z = false;
            ksLogoView.setVisibility(0);
            z = ((!af.e(context) && (com.kwad.sdk.core.response.a.a.aH(adInfo) || com.kwad.sdk.core.response.a.a.aI(adInfo))) || (af.e(context) && com.kwad.sdk.core.response.a.a.aH(adInfo) && com.kwad.sdk.core.response.a.a.aA(adInfo))) ? true : true;
            layoutParams3.gravity = 85;
            if (z) {
                i = R.dimen.obfuscated_res_0x7f07037c;
            }
            layoutParams3.bottomMargin = context.getResources().getDimensionPixelOffset(i);
            layoutParams3.rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07037c);
            ksLogoView.setLayoutParams(layoutParams3);
        }
        return layoutParams;
    }

    public static FrameLayout.LayoutParams a(FrameLayout.LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = layoutParams.gravity;
        return layoutParams2;
    }

    private void a(AdTemplate adTemplate, com.kwad.sdk.widget.c cVar) {
        this.f41053b.setVisibility(0);
        this.f41053b.a(adTemplate);
        this.f41053b.a(com.kwad.sdk.core.config.b.aK(), cVar);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdInfo j = com.kwad.sdk.core.response.a.d.j(((g) this).a.f40747g);
        com.kwad.sdk.widget.c cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aJ());
        boolean z = com.kwad.sdk.core.config.b.aH() == 2;
        this.f41057f = this.f41054c.getVisibility();
        this.f41058g = a(q(), j, this.f41054c, R.dimen.obfuscated_res_0x7f070385);
        if (z) {
            a(((g) this).a.f40747g, cVar);
        }
        ((g) this).a.n.a(this);
        boolean aA = com.kwad.sdk.core.response.a.a.aA(j);
        com.kwad.sdk.reward.d.a aVar = new com.kwad.sdk.reward.d.a(q(), ((g) this).a);
        this.f41056e = aA ? new f(this.f41055d, aVar) : new e(this.f41055d, z, aVar);
        w.a(cVar, this.f41056e.a());
        this.f41056e.a(((g) this).a.f40747g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.n.a((RewardActionBarControl.a) null);
        this.f41054c.setVisibility(this.f41057f);
        FrameLayout.LayoutParams layoutParams = this.f41058g;
        if (layoutParams != null) {
            this.f41054c.setLayoutParams(layoutParams);
        }
        this.f41053b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f41054c = (KsLogoView) a(R.id.obfuscated_res_0x7f091020);
        KsAuthorIconView ksAuthorIconView = (KsAuthorIconView) a(R.id.obfuscated_res_0x7f0910ee);
        this.f41053b = ksAuthorIconView;
        ksAuthorIconView.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.a
    public void d() {
        this.f41055d.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.f41053b)) {
            ((g) this).a.a(q(), 1, 1);
        }
    }
}
