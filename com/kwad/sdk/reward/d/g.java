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
/* loaded from: classes7.dex */
public class g extends d implements View.OnClickListener {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f40799b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f40800c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f40801d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f40802e;

    /* renamed from: f  reason: collision with root package name */
    public KsPriceView f40803f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40804g;

    /* renamed from: h  reason: collision with root package name */
    public View f40805h;
    public KSCornerImageView i;
    public b j;
    public a k;

    /* loaded from: classes7.dex */
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
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d046b, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.f40800c, adProductInfo.getIcon(), adTemplate);
        this.f40801d.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.f40802e.setVisibility(8);
            this.k.a();
        } else {
            this.f40802e.setVisibility(0);
            this.f40802e.post(new Runnable() { // from class: com.kwad.sdk.reward.d.g.1
                @Override // java.lang.Runnable
                public void run() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        g gVar = g.this;
                        View a2 = gVar.a(gVar.f40802e.getContext(), couponInfo, g.this.f40802e);
                        ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        g.this.f40802e.addView(a2, layoutParams);
                        w.a(new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL()), g.this.f40802e);
                    }
                    if (g.this.k != null) {
                        if (g.this.f40802e.getChildCount() > 0) {
                            g.this.f40802e.getChildAt(0).post(new Runnable() { // from class: com.kwad.sdk.reward.d.g.1.1
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
        this.f40803f.a(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String aF = com.kwad.sdk.core.config.b.aF();
        if (at.a(aF)) {
            return;
        }
        KSImageLoader.loadImage(this.i, aF, adTemplate);
    }

    private void b() {
        this.f40799b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091122);
        this.f40800c = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09111f);
        this.f40801d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091124);
        this.f40802e = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091111);
        this.f40803f = (KsPriceView) this.a.findViewById(R.id.obfuscated_res_0x7f091121);
        this.f40804g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09110e);
        this.f40805h = this.a.findViewById(R.id.obfuscated_res_0x7f091123);
        this.i = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091120);
        this.f40804g.setText(com.kwad.sdk.core.config.b.aE());
        this.f40804g.setOnClickListener(this);
        this.f40800c.setOnClickListener(this);
        this.f40805h.setOnClickListener(this);
        Context context = this.a.getContext();
        if (af.e(context)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07037d);
            this.a.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.sdk.reward.d.d
    public ViewGroup a() {
        return this.f40799b;
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
        if (this.j == null) {
            return;
        }
        if (view.equals(this.f40804g)) {
            this.j.c();
        } else if (view.equals(this.f40800c)) {
            this.j.a();
        } else if (view.equals(this.f40805h)) {
            this.j.b();
        }
    }
}
