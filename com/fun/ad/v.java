package com.fun.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes6.dex */
public class v implements TTNativeExpressAd.ExpressAdInteractionListener {
    public final /* synthetic */ s pOW;

    public v(s sVar) {
        this.pOW = sVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        m.a("CSJNativeExpressAd onAdClicked type: " + i);
        s sVar = this.pOW;
        ax axVar = sVar.pPB;
        if (axVar != null) {
            ((am) axVar).a(sVar.f7766a.f7762a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        m.a("CSJNativeExpressAd onAdShow type: " + i);
        s sVar = this.pOW;
        ax axVar = sVar.pPB;
        if (axVar != null) {
            ((am) axVar).b(sVar.f7766a.f7762a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        m.a("CSJNativeExpressAd onRenderFail message: " + str + ", code:" + i);
        s sVar = this.pOW;
        sVar.f7767b = false;
        ba baVar = sVar.pPA;
        if (baVar != null) {
            ((aj) baVar).a(sVar.f7766a.f7762a, i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        m.a("CSJNativeExpressAd onRenderSuccess width: " + f + ", height:" + f2);
        s sVar = this.pOW;
        sVar.f7767b = false;
        ba baVar = sVar.pPA;
        if (baVar != null) {
            ((aj) baVar).b(sVar.f7766a.f7762a);
        }
    }
}
