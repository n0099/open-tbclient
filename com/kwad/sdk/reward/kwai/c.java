package com.kwad.sdk.reward.kwai;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.kwai.b;
import com.kwad.sdk.utils.bb;
/* loaded from: classes5.dex */
public class c extends g implements b.a {
    public AdTemplate b;
    public boolean c = false;

    public static boolean a(AdInfo adInfo) {
        AdProductInfo aK = com.kwad.sdk.core.response.a.a.aK(adInfo);
        return (!com.kwad.sdk.core.response.a.a.aI(adInfo) || aK == null || aK.isCouponListEmpty()) ? false : true;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b = ((g) this).a.g;
    }

    @Override // com.kwad.sdk.reward.kwai.b.a
    public void b() {
        ((g) this).a.a(q(), 29, 1);
    }

    public void e() {
        com.kwad.sdk.core.d.a.a("RewardCouponDialogPresenter", "onBind hasShown : " + this.c);
        if (this.c) {
            return;
        }
        AdInfo j = d.j(this.b);
        ViewGroup viewGroup = (ViewGroup) ((g) this).a.j.findViewById(R.id.obfuscated_res_0x7f0910c9);
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        View view2 = viewGroup;
        if (childCount > 0) {
            view2 = viewGroup.getChildAt(0);
        }
        final int[] c = bb.c(view2);
        if (!a(j) || c == null) {
            return;
        }
        view2.post(new Runnable() { // from class: com.kwad.sdk.reward.kwai.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.d.a.a("RewardCouponDialogPresenter", "targetView x: " + c[0] + ", y: " + c[1]);
                b.a(c.this.o(), c.this.b, c.this, c);
                c.this.c = true;
            }
        });
    }
}
