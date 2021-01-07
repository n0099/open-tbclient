package com.fun.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes15.dex */
public class k implements TTNativeExpressAd.AdInteractionListener {
    public final /* synthetic */ h pIY;

    public k(h hVar) {
        this.pIY = hVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        m.a("CSJInteractionExpressAdLoader onAdClicked type: " + i);
        h hVar = this.pIY;
        ax axVar = hVar.pJW;
        if (axVar != null) {
            ((am) axVar).a(hVar.f8064a.f8060a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
    public void onAdDismiss() {
        m.a("CSJInteractionExpressAdLoader onAdDismiss");
        h hVar = this.pIY;
        ax axVar = hVar.pJW;
        if (axVar != null) {
            ((am) axVar).b(hVar.f8064a.f8060a);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        m.a("CSJInteractionExpressAdLoader onAdShow type: " + i);
        h hVar = this.pIY;
        ax axVar = hVar.pJW;
        if (axVar != null) {
            ((am) axVar).b(hVar.f8064a.f8060a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        m.a("CSJInteractionExpressAdLoader onRenderFail message: " + str + ", code: " + i);
        h hVar = this.pIY;
        hVar.f8065b = false;
        ba baVar = hVar.pJV;
        if (baVar != null) {
            ((aj) baVar).a(hVar.f8064a.f8060a, i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        m.a("CSJInteractionExpressAdLoader onRenderSuccess width: " + f + ", height: " + f2);
        h hVar = this.pIY;
        hVar.f8065b = false;
        ba baVar = hVar.pJV;
        if (baVar != null) {
            ((aj) baVar).b(hVar.f8064a.f8060a);
        }
    }
}
