package com.kwad.sdk.reward.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KSCornerImageView;
import com.kwad.sdk.widget.KSCouponLabelTextView;
import com.kwad.sdk.widget.KsPriceView;
/* loaded from: classes5.dex */
public class g extends d implements View.OnClickListener {
    public ViewGroup a;
    public ViewGroup b;
    public KSCornerImageView c;
    public TextView d;
    public LinearLayout e;
    public KsPriceView f;
    public TextView g;
    public View h;
    public KSCornerImageView i;
    public b j;
    public a k;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public g(ViewGroup viewGroup, b bVar) {
        this.a = viewGroup;
        this.j = bVar;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0466, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.c, adProductInfo.getIcon(), adTemplate);
        this.d.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.e.setVisibility(8);
            this.k.a();
        } else {
            this.e.setVisibility(0);
            this.e.post(new Runnable() { // from class: com.kwad.sdk.reward.d.g.1
                @Override // java.lang.Runnable
                public void run() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        g gVar = g.this;
                        View a2 = gVar.a(gVar.e.getContext(), couponInfo, g.this.e);
                        ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        g.this.e.addView(a2, layoutParams);
                        w.a(new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL()), g.this.e);
                    }
                    if (g.this.k != null) {
                        if (g.this.e.getChildCount() > 0) {
                            g.this.e.getChildAt(0).post(new Runnable() { // from class: com.kwad.sdk.reward.d.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    g.this.k.a();
                                }
                            });
                        } else {
                            g.this.k.a();
                        }
                    }
                }
            });
        }
        this.f.a(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String aF = com.kwad.sdk.core.config.b.aF();
        if (at.a(aF)) {
            return;
        }
        KSImageLoader.loadImage(this.i, aF, adTemplate);
    }

    private void b() {
        this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f09111b);
        this.c = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091118);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09111d);
        this.e = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09110a);
        this.f = (KsPriceView) this.a.findViewById(R.id.obfuscated_res_0x7f09111a);
        this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091107);
        this.h = this.a.findViewById(R.id.obfuscated_res_0x7f09111c);
        this.i = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091119);
        this.g.setText(com.kwad.sdk.core.config.b.aE());
        this.g.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.h.setOnClickListener(this);
        Context context = this.a.getContext();
        if (af.e(context)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070387);
            this.a.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.sdk.reward.d.d
    public ViewGroup a() {
        return this.b;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        super.a(adTemplate);
        a(com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.j(adTemplate)), adTemplate);
    }

    public void a(a aVar) {
        this.k = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.j == null) {
            return;
        }
        if (view2.equals(this.g)) {
            this.j.c();
        } else if (view2.equals(this.c)) {
            this.j.a();
        } else if (view2.equals(this.h)) {
            this.j.b();
        }
    }
}
