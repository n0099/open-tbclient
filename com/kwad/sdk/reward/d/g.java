package com.kwad.sdk.reward.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
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
/* loaded from: classes3.dex */
public class g extends d implements View.OnClickListener {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57267b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f57268c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57269d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f57270e;

    /* renamed from: f  reason: collision with root package name */
    public KsPriceView f57271f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57272g;

    /* renamed from: h  reason: collision with root package name */
    public View f57273h;

    /* renamed from: i  reason: collision with root package name */
    public KSCornerImageView f57274i;

    /* renamed from: j  reason: collision with root package name */
    public b f57275j;
    public a k;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public g(ViewGroup viewGroup, b bVar) {
        this.a = viewGroup;
        this.f57275j = bVar;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) LayoutInflater.from(context).inflate(R.layout.ksad_reward_order_card_coupon, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.f57268c, adProductInfo.getIcon(), adTemplate);
        this.f57269d.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.f57270e.setVisibility(8);
            this.k.a();
        } else {
            this.f57270e.setVisibility(0);
            this.f57270e.post(new Runnable() { // from class: com.kwad.sdk.reward.d.g.1
                @Override // java.lang.Runnable
                public void run() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        g gVar = g.this;
                        View a2 = gVar.a(gVar.f57270e.getContext(), couponInfo, g.this.f57270e);
                        ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        g.this.f57270e.addView(a2, layoutParams);
                        w.a(new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL()), g.this.f57270e);
                    }
                    if (g.this.k != null) {
                        if (g.this.f57270e.getChildCount() > 0) {
                            g.this.f57270e.getChildAt(0).post(new Runnable() { // from class: com.kwad.sdk.reward.d.g.1.1
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
        this.f57271f.a(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String aF = com.kwad.sdk.core.config.b.aF();
        if (at.a(aF)) {
            return;
        }
        KSImageLoader.loadImage(this.f57274i, aF, adTemplate);
    }

    private void b() {
        this.f57267b = (ViewGroup) this.a.findViewById(R.id.ksad_reward_order_root);
        this.f57268c = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_order_icon);
        this.f57269d = (TextView) this.a.findViewById(R.id.ksad_reward_order_title);
        this.f57270e = (LinearLayout) this.a.findViewById(R.id.ksad_reward_order_coupon_list);
        this.f57271f = (KsPriceView) this.a.findViewById(R.id.ksad_reward_order_price);
        this.f57272g = (TextView) this.a.findViewById(R.id.ksad_reward_order_btn_buy);
        this.f57273h = this.a.findViewById(R.id.ksad_reward_order_text_area);
        this.f57274i = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_order_kwai_logo);
        this.f57272g.setText(com.kwad.sdk.core.config.b.aE());
        this.f57272g.setOnClickListener(this);
        this.f57268c.setOnClickListener(this);
        this.f57273h.setOnClickListener(this);
        Context context = this.a.getContext();
        if (af.e(context)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.a.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.sdk.reward.d.d
    public ViewGroup a() {
        return this.f57267b;
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
    public void onClick(View view) {
        if (this.f57275j == null) {
            return;
        }
        if (view.equals(this.f57272g)) {
            this.f57275j.c();
        } else if (view.equals(this.f57268c)) {
            this.f57275j.a();
        } else if (view.equals(this.f57273h)) {
            this.f57275j.b();
        }
    }
}
