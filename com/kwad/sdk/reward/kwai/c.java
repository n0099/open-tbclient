package com.kwad.sdk.reward.kwai;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.kwai.b;
import com.kwad.sdk.utils.bb;
/* loaded from: classes3.dex */
public class c extends g implements b.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57319b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57320c = false;

    public static boolean a(AdInfo adInfo) {
        AdProductInfo aK = com.kwad.sdk.core.response.a.a.aK(adInfo);
        return (!com.kwad.sdk.core.response.a.a.aI(adInfo) || aK == null || aK.isCouponListEmpty()) ? false : true;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f57319b = ((g) this).a.f57207g;
    }

    @Override // com.kwad.sdk.reward.kwai.b.a
    public void b() {
        ((g) this).a.a(q(), 29, 1);
    }

    public void e() {
        com.kwad.sdk.core.d.a.a("RewardCouponDialogPresenter", "onBind hasShown : " + this.f57320c);
        if (this.f57320c) {
            return;
        }
        AdInfo j2 = d.j(this.f57319b);
        ViewGroup viewGroup = (ViewGroup) ((g) this).a.f57210j.findViewById(R.id.ksad_reward_order_coupon_list);
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        View view = viewGroup;
        if (childCount > 0) {
            view = viewGroup.getChildAt(0);
        }
        final int[] c2 = bb.c(view);
        if (!a(j2) || c2 == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.kwad.sdk.reward.kwai.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.d.a.a("RewardCouponDialogPresenter", "targetView x: " + c2[0] + ", y: " + c2[1]);
                b.a(c.this.o(), c.this.f57319b, c.this, c2);
                c.this.f57320c = true;
            }
        });
    }
}
