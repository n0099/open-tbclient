package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.widget.KSCouponLabelTextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bg;
/* loaded from: classes10.dex */
public final class n extends d implements View.OnClickListener {
    public ViewGroup gS;
    public TextView yz;
    public KsPriceView zA;
    public TextView zB;
    public View zC;
    public KSCornerImageView zD;
    public b zE;
    public a zF;
    public ViewGroup zs;
    public KSCornerImageView zy;
    public LinearLayout zz;

    /* loaded from: classes10.dex */
    public interface a {
        void hr();
    }

    public n(ViewGroup viewGroup, b bVar) {
        this.gS = viewGroup;
        this.zE = bVar;
        initView();
    }

    public static View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) com.kwad.sdk.m.l.a(context, R.layout.obfuscated_res_0x7f0d0505, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }

    public static /* synthetic */ View a(n nVar, Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        return a(context, couponInfo, viewGroup);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (this.zE == null) {
            return;
        }
        if (view2.equals(this.zB)) {
            this.zE.gH();
        } else if (view2.equals(this.zy)) {
            this.zE.mo180if();
        } else if (view2.equals(this.zC)) {
            this.zE.ig();
        }
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.zy, adProductInfo.getIcon(), adTemplate);
        this.yz.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.zz.setVisibility(8);
            this.zF.hr();
        } else {
            this.zz.setVisibility(0);
            this.zz.post(new Runnable() { // from class: com.kwad.components.ad.reward.n.n.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        n nVar = n.this;
                        View a2 = n.a(nVar, nVar.zz.getContext(), couponInfo, n.this.zz);
                        ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        n.this.zz.addView(a2, layoutParams);
                        com.kwad.components.core.s.i.a(new com.kwad.components.core.widget.e(), n.this.zz);
                    }
                    if (n.this.zF != null) {
                        if (n.this.zz.getChildCount() > 0) {
                            n.this.zz.getChildAt(0).post(new Runnable() { // from class: com.kwad.components.ad.reward.n.n.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    n.this.zF.hr();
                                }
                            });
                        } else {
                            n.this.zF.hr();
                        }
                    }
                }
            });
        }
        this.zA.h(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String Z = com.kwad.components.ad.d.b.Z();
        if (!bg.isNullString(Z)) {
            KSImageLoader.loadImage(this.zD, Z, adTemplate);
        }
    }

    private void initView() {
        this.zs = (ViewGroup) this.gS.findViewById(R.id.obfuscated_res_0x7f09146c);
        this.zy = (KSCornerImageView) this.gS.findViewById(R.id.obfuscated_res_0x7f091469);
        this.yz = (TextView) this.gS.findViewById(R.id.obfuscated_res_0x7f09146e);
        this.zz = (LinearLayout) this.gS.findViewById(R.id.obfuscated_res_0x7f09145b);
        this.zA = (KsPriceView) this.gS.findViewById(R.id.obfuscated_res_0x7f09146b);
        this.zB = (TextView) this.gS.findViewById(R.id.obfuscated_res_0x7f091458);
        this.zC = this.gS.findViewById(R.id.obfuscated_res_0x7f09146d);
        this.zD = (KSCornerImageView) this.gS.findViewById(R.id.obfuscated_res_0x7f09146a);
        this.zB.setText(com.kwad.components.ad.d.b.Y());
        this.zB.setOnClickListener(this);
        this.zy.setOnClickListener(this);
        this.zC.setOnClickListener(this);
        Context context = this.gS.getContext();
        if (!ai.Kx()) {
            ViewGroup.LayoutParams layoutParams = this.gS.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07050b);
                this.gS.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void a(a aVar) {
        this.zF = aVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.sdk.core.response.b.a.cM(com.kwad.sdk.core.response.b.e.dP(rVar.getAdTemplate())), rVar.getAdTemplate());
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gD() {
        return this.zs;
    }
}
