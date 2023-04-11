package com.kwad.components.ad.reward.k;

import android.content.Context;
import android.view.LayoutInflater;
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
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ax;
/* loaded from: classes8.dex */
public final class m extends d implements View.OnClickListener {
    public ViewGroup es;
    public TextView li;
    public KSCornerImageView nG;
    public ViewGroup nL;
    public LinearLayout vC;
    public KsPriceView vD;
    public TextView vE;
    public View vF;
    public KSCornerImageView vG;
    public b vH;
    public a vI;

    /* loaded from: classes8.dex */
    public interface a {
        void gV();
    }

    public m(ViewGroup viewGroup, b bVar) {
        this.es = viewGroup;
        this.vH = bVar;
        initView();
    }

    public static View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0494, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }

    public static /* synthetic */ View a(m mVar, Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        return a(context, couponInfo, viewGroup);
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.nG, adProductInfo.getIcon(), adTemplate);
        this.li.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.vC.setVisibility(8);
            this.vI.gV();
        } else {
            this.vC.setVisibility(0);
            this.vC.post(new Runnable() { // from class: com.kwad.components.ad.reward.k.m.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        m mVar = m.this;
                        View a2 = m.a(mVar, mVar.vC.getContext(), couponInfo, m.this.vC);
                        ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        m.this.vC.addView(a2, layoutParams);
                        com.kwad.components.core.m.j.a(new com.kwad.components.core.widget.f(), m.this.vC);
                    }
                    if (m.this.vI != null) {
                        if (m.this.vC.getChildCount() > 0) {
                            m.this.vC.getChildAt(0).post(new Runnable() { // from class: com.kwad.components.ad.reward.k.m.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    m.this.vI.gV();
                                }
                            });
                        } else {
                            m.this.vI.gV();
                        }
                    }
                }
            });
        }
        this.vD.f(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String aj = com.kwad.components.ad.c.b.aj();
        if (ax.dT(aj)) {
            return;
        }
        KSImageLoader.loadImage(this.vG, aj, adTemplate);
    }

    private void initView() {
        this.nL = (ViewGroup) this.es.findViewById(R.id.obfuscated_res_0x7f09131b);
        this.nG = (KSCornerImageView) this.es.findViewById(R.id.obfuscated_res_0x7f091318);
        this.li = (TextView) this.es.findViewById(R.id.obfuscated_res_0x7f09131d);
        this.vC = (LinearLayout) this.es.findViewById(R.id.obfuscated_res_0x7f09130a);
        this.vD = (KsPriceView) this.es.findViewById(R.id.obfuscated_res_0x7f09131a);
        this.vE = (TextView) this.es.findViewById(R.id.obfuscated_res_0x7f091307);
        this.vF = this.es.findViewById(R.id.obfuscated_res_0x7f09131c);
        this.vG = (KSCornerImageView) this.es.findViewById(R.id.obfuscated_res_0x7f091319);
        this.vE.setText(com.kwad.components.ad.c.b.ai());
        this.vE.setOnClickListener(this);
        this.nG.setOnClickListener(this);
        this.vF.setOnClickListener(this);
        Context context = this.es.getContext();
        if (ag.cB(context)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.es.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b7);
            this.es.setLayoutParams(layoutParams2);
        }
    }

    public final void a(a aVar) {
        this.vI = aVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        super.a(uVar);
        a(com.kwad.sdk.core.response.a.a.bN(com.kwad.sdk.core.response.a.d.bQ(uVar.getAdTemplate())), uVar.getAdTemplate());
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        return this.nL;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (this.vH == null) {
            return;
        }
        if (view2.equals(this.vE)) {
            this.vH.gn();
        } else if (view2.equals(this.nG)) {
            this.vH.hz();
        } else if (view2.equals(this.vF)) {
            this.vH.hA();
        }
    }
}
