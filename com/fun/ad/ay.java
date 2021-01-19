package com.fun.ad;

import com.qq.e.ads.nativ.express2.AdEventListener;
/* loaded from: classes14.dex */
public class ay implements AdEventListener {
    public final /* synthetic */ av pFq;

    public ay(av avVar) {
        this.pFq = avVar;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        m.a("GDTNativeExpressAd2 onADClosed");
        av avVar = this.pFq;
        ah ahVar = avVar.pFi;
        if (ahVar != null) {
            ((aa) ahVar).a(avVar.f7752a.f7760a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        m.a("GDTNativeExpressAd2 onClick");
        av avVar = this.pFq;
        ah ahVar = avVar.pFi;
        if (ahVar != null) {
            ((aa) ahVar).c(avVar.f7752a.f7760a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        m.a("GDTNativeExpressAd2 onClick");
        av avVar = this.pFq;
        ah ahVar = avVar.pFi;
        if (ahVar != null) {
            ((aa) ahVar).d(avVar.f7752a.f7760a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        this.pFq.f7753b = false;
        m.a("GDTNativeExpressAd2 onRenderFail");
        av avVar = this.pFq;
        ak akVar = avVar.pFh;
        if (akVar != null) {
            ((x) akVar).a(avVar.f7752a.f7760a, 0, "Custom error message: render fail");
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        m.a("GDTNativeExpressAd2 onRenderSuccess");
        av avVar = this.pFq;
        avVar.f7753b = false;
        ak akVar = avVar.pFh;
        if (akVar != null) {
            ((x) akVar).b(avVar.f7752a.f7760a);
        }
    }
}
