package com.fun.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes15.dex */
public class v implements TTNativeExpressAd.ExpressAdInteractionListener {
    public final /* synthetic */ s pHJ;

    public v(s sVar) {
        this.pHJ = sVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        m.a("CSJNativeExpressAd onAdClicked type: " + i);
        s sVar = this.pHJ;
        ax axVar = sVar.pIo;
        if (axVar != null) {
            ((am) axVar).a(sVar.f8063a.f8059a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        m.a("CSJNativeExpressAd onAdShow type: " + i);
        s sVar = this.pHJ;
        ax axVar = sVar.pIo;
        if (axVar != null) {
            ((am) axVar).b(sVar.f8063a.f8059a, view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        m.a("CSJNativeExpressAd onRenderFail message: " + str + ", code:" + i);
        s sVar = this.pHJ;
        sVar.f8064b = false;
        ba baVar = sVar.pIn;
        if (baVar != null) {
            ((aj) baVar).a(sVar.f8063a.f8059a, i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        m.a("CSJNativeExpressAd onRenderSuccess width: " + f + ", height:" + f2);
        s sVar = this.pHJ;
        sVar.f8064b = false;
        ba baVar = sVar.pIn;
        if (baVar != null) {
            ((aj) baVar).b(sVar.f8063a.f8059a);
        }
    }
}
