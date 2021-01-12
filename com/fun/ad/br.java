package com.fun.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes14.dex */
public class br implements TTNativeExpressAd.ExpressAdInteractionListener {
    public final /* synthetic */ bo pFJ;

    public br(bo boVar) {
        this.pFJ = boVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        m.a("CSJBannerExpressAd onAdClicked type: " + i);
        bo boVar = this.pFJ;
        ax axVar = boVar.pFv;
        if (axVar != null) {
            ((am) axVar).a(boVar.f7764a.f7760a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        m.a("CSJBannerExpressAd onAdShow type: " + i);
        bo boVar = this.pFJ;
        ax axVar = boVar.pFv;
        if (axVar != null) {
            ((am) axVar).b(boVar.f7764a.f7760a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        m.a("CSJBannerExpressAd onRenderFail message: " + str + ", code = " + i);
        bo boVar = this.pFJ;
        boVar.f7765b = false;
        ba baVar = boVar.pFu;
        if (baVar != null) {
            ((aj) baVar).a(boVar.f7764a.f7760a, i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        m.a("CSJBannerExpressAd onRenderSuccess width: " + f + ", height = " + f2);
        bo boVar = this.pFJ;
        boVar.f7765b = false;
        ba baVar = boVar.pFu;
        if (baVar != null) {
            ((aj) baVar).b(boVar.f7764a.f7760a);
        }
    }
}
