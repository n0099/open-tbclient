package com.fun.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes14.dex */
public class v implements TTNativeExpressAd.ExpressAdInteractionListener {
    public final /* synthetic */ s pER;

    public v(s sVar) {
        this.pER = sVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        m.a("CSJNativeExpressAd onAdClicked type: " + i);
        s sVar = this.pER;
        ax axVar = sVar.pFw;
        if (axVar != null) {
            ((am) axVar).a(sVar.f7764a.f7760a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        m.a("CSJNativeExpressAd onAdShow type: " + i);
        s sVar = this.pER;
        ax axVar = sVar.pFw;
        if (axVar != null) {
            ((am) axVar).b(sVar.f7764a.f7760a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        m.a("CSJNativeExpressAd onRenderFail message: " + str + ", code:" + i);
        s sVar = this.pER;
        sVar.f7765b = false;
        ba baVar = sVar.pFv;
        if (baVar != null) {
            ((aj) baVar).a(sVar.f7764a.f7760a, i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        m.a("CSJNativeExpressAd onRenderSuccess width: " + f + ", height:" + f2);
        s sVar = this.pER;
        sVar.f7765b = false;
        ba baVar = sVar.pFv;
        if (baVar != null) {
            ((aj) baVar).b(sVar.f7764a.f7760a);
        }
    }
}
