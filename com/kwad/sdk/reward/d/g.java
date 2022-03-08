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
/* loaded from: classes8.dex */
public class g extends d implements View.OnClickListener {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f55829b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f55830c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55831d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f55832e;

    /* renamed from: f  reason: collision with root package name */
    public KsPriceView f55833f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55834g;

    /* renamed from: h  reason: collision with root package name */
    public View f55835h;

    /* renamed from: i  reason: collision with root package name */
    public KSCornerImageView f55836i;

    /* renamed from: j  reason: collision with root package name */
    public b f55837j;
    public a k;

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    public g(ViewGroup viewGroup, b bVar) {
        this.a = viewGroup;
        this.f55837j = bVar;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) LayoutInflater.from(context).inflate(R.layout.ksad_reward_order_card_coupon, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.f55830c, adProductInfo.getIcon(), adTemplate);
        this.f55831d.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.f55832e.setVisibility(8);
            this.k.a();
        } else {
            this.f55832e.setVisibility(0);
            this.f55832e.post(new Runnable() { // from class: com.kwad.sdk.reward.d.g.1
                @Override // java.lang.Runnable
                public void run() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        g gVar = g.this;
                        View a2 = gVar.a(gVar.f55832e.getContext(), couponInfo, g.this.f55832e);
                        ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        g.this.f55832e.addView(a2, layoutParams);
                        w.a(new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL()), g.this.f55832e);
                    }
                    if (g.this.k != null) {
                        if (g.this.f55832e.getChildCount() > 0) {
                            g.this.f55832e.getChildAt(0).post(new Runnable() { // from class: com.kwad.sdk.reward.d.g.1.1
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
        this.f55833f.a(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String aF = com.kwad.sdk.core.config.b.aF();
        if (at.a(aF)) {
            return;
        }
        KSImageLoader.loadImage(this.f55836i, aF, adTemplate);
    }

    private void b() {
        this.f55829b = (ViewGroup) this.a.findViewById(R.id.ksad_reward_order_root);
        this.f55830c = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_order_icon);
        this.f55831d = (TextView) this.a.findViewById(R.id.ksad_reward_order_title);
        this.f55832e = (LinearLayout) this.a.findViewById(R.id.ksad_reward_order_coupon_list);
        this.f55833f = (KsPriceView) this.a.findViewById(R.id.ksad_reward_order_price);
        this.f55834g = (TextView) this.a.findViewById(R.id.ksad_reward_order_btn_buy);
        this.f55835h = this.a.findViewById(R.id.ksad_reward_order_text_area);
        this.f55836i = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_order_kwai_logo);
        this.f55834g.setText(com.kwad.sdk.core.config.b.aE());
        this.f55834g.setOnClickListener(this);
        this.f55830c.setOnClickListener(this);
        this.f55835h.setOnClickListener(this);
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
        return this.f55829b;
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
        if (this.f55837j == null) {
            return;
        }
        if (view.equals(this.f55834g)) {
            this.f55837j.c();
        } else if (view.equals(this.f55830c)) {
            this.f55837j.a();
        } else if (view.equals(this.f55835h)) {
            this.f55837j.b();
        }
    }
}
