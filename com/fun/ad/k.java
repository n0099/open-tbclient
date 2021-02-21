package com.fun.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes6.dex */
public class k implements TTNativeExpressAd.AdInteractionListener {
    public final /* synthetic */ h pPd;

    public k(h hVar) {
        this.pPd = hVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        m.a("CSJInteractionExpressAdLoader onAdClicked type: " + i);
        h hVar = this.pPd;
        ax axVar = hVar.pQb;
        if (axVar != null) {
            ((am) axVar).a(hVar.f7766a.f7762a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
    public void onAdDismiss() {
        m.a("CSJInteractionExpressAdLoader onAdDismiss");
        h hVar = this.pPd;
        ax axVar = hVar.pQb;
        if (axVar != null) {
            ((am) axVar).b(hVar.f7766a.f7762a);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        m.a("CSJInteractionExpressAdLoader onAdShow type: " + i);
        h hVar = this.pPd;
        ax axVar = hVar.pQb;
        if (axVar != null) {
            ((am) axVar).b(hVar.f7766a.f7762a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        m.a("CSJInteractionExpressAdLoader onRenderFail message: " + str + ", code: " + i);
        h hVar = this.pPd;
        hVar.f7767b = false;
        ba baVar = hVar.pQa;
        if (baVar != null) {
            ((aj) baVar).a(hVar.f7766a.f7762a, i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        m.a("CSJInteractionExpressAdLoader onRenderSuccess width: " + f + ", height: " + f2);
        h hVar = this.pPd;
        hVar.f7767b = false;
        ba baVar = hVar.pQa;
        if (baVar != null) {
            ((aj) baVar).b(hVar.f7766a.f7762a);
        }
    }
}
