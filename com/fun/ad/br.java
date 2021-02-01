package com.fun.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes6.dex */
public class br implements TTNativeExpressAd.ExpressAdInteractionListener {
    public final /* synthetic */ bo pPP;

    public br(bo boVar) {
        this.pPP = boVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        m.a("CSJBannerExpressAd onAdClicked type: " + i);
        bo boVar = this.pPP;
        ax axVar = boVar.pPB;
        if (axVar != null) {
            ((am) axVar).a(boVar.f7766a.f7762a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        m.a("CSJBannerExpressAd onAdShow type: " + i);
        bo boVar = this.pPP;
        ax axVar = boVar.pPB;
        if (axVar != null) {
            ((am) axVar).b(boVar.f7766a.f7762a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        m.a("CSJBannerExpressAd onRenderFail message: " + str + ", code = " + i);
        bo boVar = this.pPP;
        boVar.f7767b = false;
        ba baVar = boVar.pPA;
        if (baVar != null) {
            ((aj) baVar).a(boVar.f7766a.f7762a, i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        m.a("CSJBannerExpressAd onRenderSuccess width: " + f + ", height = " + f2);
        bo boVar = this.pPP;
        boVar.f7767b = false;
        ba baVar = boVar.pPA;
        if (baVar != null) {
            ((aj) baVar).b(boVar.f7766a.f7762a);
        }
    }
}
