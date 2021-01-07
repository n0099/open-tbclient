package com.fun.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes15.dex */
public class v implements TTNativeExpressAd.ExpressAdInteractionListener {
    public final /* synthetic */ s pJr;

    public v(s sVar) {
        this.pJr = sVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        m.a("CSJNativeExpressAd onAdClicked type: " + i);
        s sVar = this.pJr;
        ax axVar = sVar.pJW;
        if (axVar != null) {
            ((am) axVar).a(sVar.f8064a.f8060a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        m.a("CSJNativeExpressAd onAdShow type: " + i);
        s sVar = this.pJr;
        ax axVar = sVar.pJW;
        if (axVar != null) {
            ((am) axVar).b(sVar.f8064a.f8060a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        m.a("CSJNativeExpressAd onRenderFail message: " + str + ", code:" + i);
        s sVar = this.pJr;
        sVar.f8065b = false;
        ba baVar = sVar.pJV;
        if (baVar != null) {
            ((aj) baVar).a(sVar.f8064a.f8060a, i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        m.a("CSJNativeExpressAd onRenderSuccess width: " + f + ", height:" + f2);
        s sVar = this.pJr;
        sVar.f8065b = false;
        ba baVar = sVar.pJV;
        if (baVar != null) {
            ((aj) baVar).b(sVar.f8064a.f8060a);
        }
    }
}
