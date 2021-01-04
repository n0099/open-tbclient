package com.fun.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes15.dex */
public class br implements TTNativeExpressAd.ExpressAdInteractionListener {
    public final /* synthetic */ bo pIC;

    public br(bo boVar) {
        this.pIC = boVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        m.a("CSJBannerExpressAd onAdClicked type: " + i);
        bo boVar = this.pIC;
        ax axVar = boVar.pIo;
        if (axVar != null) {
            ((am) axVar).a(boVar.f8063a.f8059a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        m.a("CSJBannerExpressAd onAdShow type: " + i);
        bo boVar = this.pIC;
        ax axVar = boVar.pIo;
        if (axVar != null) {
            ((am) axVar).b(boVar.f8063a.f8059a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        m.a("CSJBannerExpressAd onRenderFail message: " + str + ", code = " + i);
        bo boVar = this.pIC;
        boVar.f8064b = false;
        ba baVar = boVar.pIn;
        if (baVar != null) {
            ((aj) baVar).a(boVar.f8063a.f8059a, i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        m.a("CSJBannerExpressAd onRenderSuccess width: " + f + ", height = " + f2);
        bo boVar = this.pIC;
        boVar.f8064b = false;
        ba baVar = boVar.pIn;
        if (baVar != null) {
            ((aj) baVar).b(boVar.f8063a.f8059a);
        }
    }
}
